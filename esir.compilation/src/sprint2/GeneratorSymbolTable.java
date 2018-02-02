package sprint2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Provider;

import esir.compilation.WhdslStandaloneSetupGenerated;
import esir.compilation.whdsl.Affect;
import esir.compilation.whdsl.Call;
import esir.compilation.whdsl.Command;
import esir.compilation.whdsl.Commands;
import esir.compilation.whdsl.Cons;
import esir.compilation.whdsl.Definition;
import esir.compilation.whdsl.EnclosedExpr;
import esir.compilation.whdsl.Expr;
import esir.compilation.whdsl.ExprAnd;
import esir.compilation.whdsl.ExprEq;
import esir.compilation.whdsl.ExprNot;
import esir.compilation.whdsl.ExprOr;
import esir.compilation.whdsl.For;
import esir.compilation.whdsl.ForEach;
import esir.compilation.whdsl.Function;
import esir.compilation.whdsl.Hd;
import esir.compilation.whdsl.If;
import esir.compilation.whdsl.Input;
import esir.compilation.whdsl.Nill;
import esir.compilation.whdsl.Nop;
import esir.compilation.whdsl.Output;
import esir.compilation.whdsl.Program;
import esir.compilation.whdsl.Symbol;
import esir.compilation.whdsl.Tl;
import esir.compilation.whdsl.Variable;
import esir.compilation.whdsl.While;
import sprint2.operations.AFFECT;
import sprint2.operations.BOUCHON;
import sprint2.operations.CALL;
import sprint2.operations.CONS;
import sprint2.operations.EXPAND;
import sprint2.operations.EXPEQUAL;
import sprint2.operations.EXPNOT;
import sprint2.operations.EXPOR;
import sprint2.operations.FOR;
import sprint2.operations.FOREACH;
import sprint2.operations.HD;
import sprint2.operations.IF;
import sprint2.operations.NOP;
import sprint2.operations.READ;
import sprint2.operations.TL;
import sprint2.operations.WHILE;
import sprint2.operations.WRITE;

public class GeneratorSymbolTable {

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	private SymbolTable symbolTable;

	public static GeneratorSymbolTable getInstance(){
		return new WhdslStandaloneSetupGenerated().createInjectorAndDoEMFRegistration().getInstance(GeneratorSymbolTable.class);
	}

	public int init(String inputFile,String outFile ,boolean file_3a) throws SymbolTableError, IOException {

		File output = new File(outFile+".go");

		symbolTable =new SymbolTable();

		//Récupération du fichier while source
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createFileURI(inputFile), true);

		//Vérifie si le fichier while est correct
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);


		if (!list.isEmpty()) {
			String result="\n";
			for (Issue issue : list) {
				result+=issue+"\n";
			}
			throw new SymbolTableError(result+"\nLe fichier while ne possède pas une syntaxe correcte");
		}

		//Création de l'arbre de parcours
		TreeIterator<EObject> tree = resource.getAllContents();
		while (tree.hasNext()) {
			EObject next = tree.next(); 
			if (next instanceof Program) {//Si l'élément courant est un programme
				registerFunctions((Program) next);
				iterateElement((Program) next);
			}
		}

		if(file_3a){
			try{
				symbolTable.writeFile3Add(new File(outFile+"3a.txt"));
			}catch(FileNotFoundException e){
				System.err.println("Erreur emplacement fichier sortie");
				return -1;
			}
		}
		
		try{
			symbolTable.writeFileGo(output);
		}catch(FileNotFoundException e){
			System.err.println("Erreur emplacement fichier sortie");
			return -1;
		}

		return 0;
	}


	/**
	 * Sauvegarde dans une liste les définitions des fonctions d'un programme et s'assure de leur unicité
	 * @param program
	 * @throws DoubleFunctionException 
	 */
	private void registerFunctions(Program program) throws SymbolTableError {

		for (Function f : program.getFunctions()) {

			symbolTable.addFunction(f.getName(),f.getDefinition().getInput().getVars().getList().size()
					,f.getDefinition().getOutput().getVars().getList().size());
		}
	}

	private void iterateElement(Program p) throws SymbolTableError{
		for (Function f : p.getFunctions()) {
			iterateElement(f,symbolTable.getFunction(f.getName()));
		}
	}
	private void iterateElement(Function f, FunctionRepresentation fr) throws SymbolTableError{
		iterateElement(f.getDefinition(),fr);
	}
	private void iterateElement(Definition c, FunctionRepresentation fr) throws SymbolTableError{
		iterateElement(c.getInput(),fr);
		ReturnIterateCmd rt = iterateElement(c.getCommands(), fr);

		for(Code3Address code : rt.getListCode()){
			fr.addCode3Address(code);
		}

		iterateElement(c.getOutput(),fr);
	}

	private void iterateElement(Input i, FunctionRepresentation fr ){

		EList<String> vars = i.getVars().getList();

		for(String v : vars){
			String idV = fr.addVar(v);
			fr.addCode3Address(new Code3Address(new READ(), idV, "_", "_") );
		}

	}

	private void iterateElement(Output o, FunctionRepresentation fr){
		EList<String> vars = o.getVars().getList();

		for(String v : vars){

			String idV = fr.addVar(v);

			fr.addCode3Address(new Code3Address(new WRITE(), idV, "_", "_") );
		}
	}

	private ReturnIterateCmd iterateElement(Commands c, FunctionRepresentation fr) throws SymbolTableError {

		ArrayList<Code3Address> fusion = new ArrayList<>();

		EList<Command> l = c.getList();
		if(l!=null){
			for(Command co : l){
				ReturnIterateCmd rt = iterateElement(co, fr);
				fusion.addAll(rt.getListCode());
			}
		}

		return new ReturnIterateCmd(fusion);
	}

	private ReturnIterateCmd iterateElement(Command c, FunctionRepresentation fr) throws SymbolTableError {

		EObject o = c.getCmd();

		if(o instanceof For){
			return iterateElement((For)o,fr);
		}
		else if(o instanceof Affect){
			return iterateElement((Affect)o,fr);
		}
		else if(o instanceof If){
			return iterateElement((If)o,fr);
		}
		else if(o instanceof Nop){
			return iterateElement((Nop)o,fr);
		}
		else if(o instanceof While){
			return iterateElement((While)o, fr);
		}
		else if(o instanceof ForEach){
			return iterateElement((ForEach)o, fr);
		}
		else {
			Code3Address code = new Code3Address(new BOUCHON(), "_", "_", "_");
			ArrayList<Code3Address> la =new ArrayList<>();
			la.add(code);

			return new ReturnIterateCmd(la);
		}

	}


	private ReturnIterateCmd iterateElement(Nop a, FunctionRepresentation fr) {

		Code3Address code = new Code3Address(new NOP(), "_", "_", "_");
		ArrayList<Code3Address> la =new ArrayList<>();
		la.add(code);

		return new ReturnIterateCmd(la);
	}

	private ReturnIterateCmd iterateElement(Affect a, FunctionRepresentation fr) throws SymbolTableError {
		EList<String> vars =a.getVars().getList();
		EList<Expr> exprs = a.getExprs().getList();

		List<Code3Address> listAffectation =new ArrayList<>();

		List<Code3Address> listAffectationTemp =new ArrayList<>();

		
		HashMap<String, String> oldVariableValue = new HashMap<>();

		for (Expr e : exprs) {
			if(e instanceof Variable && vars.contains(((Variable) e).getValue()) && !oldVariableValue.containsKey(fr.addVar(((Variable) e).getValue()))){
				String idVt = fr.getNewTempVar();
				oldVariableValue.put(fr.addVar(((Variable) e).getValue()), idVt);

				Code3Address codeOldValue = new Code3Address(new AFFECT(), idVt,fr.addVar(((Variable) e).getValue()), "_");
				listAffectation.add(codeOldValue);
			}
		}

		for (Expr e : exprs) {
		
			ReturnIterateExpr rtExp = iterateElement(e, fr);
			listAffectation.addAll(rtExp.getListCode());

			for (int i = 0; i < rtExp.getNbAddr(); i++) {
				String v;
				try {
					v = vars.get(0);
					vars.remove(0);
				} catch (IndexOutOfBoundsException ie) {
					throw new SymbolTableError("Le nombre de variable à gauche et à droite de l'affectation ne correspondent pas");
				}


				String idV = fr.addVar(v);
				Code3Address codeAff;

				if(oldVariableValue.containsKey(rtExp.getListAddr().get(i))){
					codeAff = new Code3Address(new AFFECT(), idV, oldVariableValue.get(rtExp.getListAddr().get(i)), "_");
				}
				else{
					codeAff = new Code3Address(new AFFECT(), idV, rtExp.getListAddr().get(i), "_");
				}
				listAffectationTemp.add(codeAff);
			}
		}
		
		
		listAffectation.addAll(listAffectationTemp);
		

		if (vars.size() != 0) {
			throw new SymbolTableError("Le nombre de variable à gauche et à droite de l'affectation ne correspondent pas");
		}

		return new ReturnIterateCmd(listAffectation);
	}

	private ReturnIterateExpr iterateElement(Expr e, FunctionRepresentation fr) throws SymbolTableError {

		if (e instanceof Nill) {
			return iterateElement((Nill) e, fr);
		}
		else if (e instanceof Variable) {
			return iterateElement((Variable) e, fr);
		}
		else if (e instanceof Cons) {
			return iterateElement((Cons) e, fr);
		}
		else if (e instanceof Hd) {
			return iterateElement((Hd) e, fr);
		}
		else if (e instanceof Tl) {
			return iterateElement((Tl) e, fr);
		}
		else if (e instanceof Call) {
			return iterateElement((Call)e,fr);
		}
		else if(e instanceof Symbol){
			return iterateElement((Symbol)e,fr);
		}
		else if(e instanceof ExprAnd){
			return iterateElement((ExprAnd)e,fr);
		}
		else if(e instanceof ExprOr){
			return iterateElement((ExprOr)e,fr);
		}
		else if(e instanceof ExprEq){
			return iterateElement((ExprEq)e,fr);
		}
		else if(e instanceof ExprNot){
			return iterateElement((ExprNot)e,fr);
		}
		else if(e instanceof EnclosedExpr){
			return iterateElement((EnclosedExpr)e,fr);
		}
		else if(e instanceof esir.compilation.whdsl.List){
			return iterateElement((esir.compilation.whdsl.List)e,fr);
		} 

		Code3Address code = new Code3Address(new BOUCHON(), "_", "_", "_");
		ArrayList<Code3Address> la =new ArrayList<>();
		la.add(code);

		return new ReturnIterateExpr(new ArrayList<>(), la);
	}

	private ReturnIterateExpr iterateElement(esir.compilation.whdsl.List l, FunctionRepresentation fr) throws SymbolTableError {			

		EList<Expr> listExp = l.getExprs().getList();
		List<Code3Address> code = new ArrayList<>();
		List<String> addrs = new ArrayList<>();

		List<String> listTempAddr = new ArrayList<>();


		for(Expr e : listExp){
			ReturnIterateExpr rtExp1 = iterateElement(e,fr);
			code.addAll(rtExp1.getListCode());
			listTempAddr.addAll(rtExp1.getListAddr());
		}

		if (listTempAddr.size() < 2) throw new SymbolTableError("Deux paramètres sont attendu pour une list, nombre de paramètres données :"+listTempAddr.size());

		boolean first = true;
		String res="",previousRes="";

		while(listTempAddr.size() > 0)
		{
			res = fr.getNewTempVar();

			if(first){
				code.add(new Code3Address(new CONS(), res,listTempAddr.get(listTempAddr.size()-1), symbolTable.getSymbol("nil") ));
				listTempAddr.remove(listTempAddr.size()-1);
				first=false;
			}
			else{
				code.add(new Code3Address(new CONS(), res,listTempAddr.get(listTempAddr.size()-1), previousRes));
				listTempAddr.remove(listTempAddr.size()-1);
			}
			previousRes = res;

		}

		addrs.add(res);
		return new ReturnIterateExpr(addrs, code);
	}


	private ReturnIterateExpr iterateElement(Symbol s, FunctionRepresentation fr) throws SymbolTableError {

		if(symbolTable.hasFunction(s.getValue())){
			throw new SymbolTableError("La fonction "+s.getValue()+" ne peut être appelée sans paramètre");
		}


		String idS = symbolTable.addSymbol(s.getValue());
		List<String> listAddr = new ArrayList<>();
		listAddr.add(idS);

		return new ReturnIterateExpr(listAddr, new ArrayList<Code3Address>());
	}



	private ReturnIterateExpr iterateElement(ExprAnd e, FunctionRepresentation fr) throws SymbolTableError {

		EXPAND expAnd = new EXPAND();

		String idVt = fr.getNewTempVar();

		ReturnIterateExpr rtGauche = iterateElement(e.getLeft(),fr);
		ReturnIterateExpr rtDroite = iterateElement(e.getRight(),fr);

		if (rtDroite.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu à droite pour l'expression and, nombre de paramètres données :"+ rtDroite.getNbAddr());
		if (rtGauche.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu à gauche pour l'expression and, nombre de paramètres données :"+ rtGauche.getNbAddr());


		expAnd.getListCodeLeft().addAll(rtGauche.getListCode());
		expAnd.getListCodeRight().addAll(rtDroite.getListCode());


		List<String> listAddr = new ArrayList<>();
		listAddr.add(idVt);

		List<Code3Address> listCode = new ArrayList<>();
		listCode.add(new Code3Address(expAnd,idVt, rtGauche.getListAddr().get(0), rtDroite.getListAddr().get(0)));

		return new ReturnIterateExpr(listAddr, listCode);

	}

	private ReturnIterateExpr iterateElement(ExprOr e, FunctionRepresentation fr) throws SymbolTableError {

		EXPOR expOr = new EXPOR();

		String idVt = fr.getNewTempVar();

		ReturnIterateExpr rtGauche = iterateElement(e.getLeft(),fr);
		ReturnIterateExpr rtDroite = iterateElement(e.getRight(),fr);

		if (rtDroite.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu à droite pour l'expression or, nombre de paramètres données :"+ rtDroite.getNbAddr());
		if (rtGauche.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu à gauche pour l'expression or, nombre de paramètres données :"+ rtGauche.getNbAddr());


		expOr.getListCodeLeft().addAll(rtGauche.getListCode());
		expOr.getListCodeRight().addAll(rtDroite.getListCode());

		List<String> listAddr = new ArrayList<>();
		listAddr.add(idVt);

		List<Code3Address> listCode = new ArrayList<>();
		listCode.add(new Code3Address(expOr,idVt, rtGauche.getListAddr().get(0), rtDroite.getListAddr().get(0)));

		return new ReturnIterateExpr(listAddr, listCode);
	}

	private ReturnIterateExpr iterateElement(ExprNot e, FunctionRepresentation fr) throws SymbolTableError {
		EXPNOT expNot = new EXPNOT();

		String idVt = fr.getNewTempVar();

		ReturnIterateExpr rtExp = iterateElement(e.getExpr(),fr);

		if (rtExp.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu pour l'expression not, nombre de paramètres données :"+ rtExp.getNbAddr());

		expNot.getListCode().addAll(rtExp.getListCode());

		List<String> listAddr = new ArrayList<>();
		listAddr.add(idVt);

		List<Code3Address> listCode = new ArrayList<>();
		listCode.add(new Code3Address(expNot, idVt,rtExp.getListAddr().get(0),"_"));


		return new ReturnIterateExpr(listAddr, listCode);	
	}

	private ReturnIterateExpr iterateElement(ExprEq e, FunctionRepresentation fr) throws SymbolTableError {

		EXPEQUAL expEqual = new EXPEQUAL();

		String idVt = fr.getNewTempVar();

		ReturnIterateExpr rtGauche = iterateElement(e.getLeft(),fr);
		ReturnIterateExpr rtDroite = iterateElement(e.getRight(),fr);

		if (rtDroite.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu à droite pour l'expression equal, nombre de paramètres données :"+ rtDroite.getNbAddr());
		if (rtGauche.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu à gauche pour l'expression equal, nombre de paramètres données :"+ rtGauche.getNbAddr());


		expEqual.getListCodeLeft().addAll(rtGauche.getListCode());
		expEqual.getListCodeRight().addAll(rtDroite.getListCode());

		List<String> listAddr = new ArrayList<>();
		listAddr.add(idVt);

		List<Code3Address> listCode = new ArrayList<>();
		listCode.add(new Code3Address(expEqual,idVt, rtGauche.getListAddr().get(0), rtDroite.getListAddr().get(0)));

		return new ReturnIterateExpr(listAddr, listCode);	
	}

	private ReturnIterateExpr iterateElement(EnclosedExpr e, FunctionRepresentation fr) throws SymbolTableError {


		return iterateElement(e.getExpr(), fr);

	}

	private ReturnIterateExpr iterateElement(Nill n, FunctionRepresentation fr) {

		List<String> addrs = new ArrayList<>();
		addrs.add(symbolTable.getSymbol("nil"));

		return new ReturnIterateExpr(addrs, new ArrayList<>());
	}

	private ReturnIterateExpr iterateElement(Variable v, FunctionRepresentation fr) {
		String addr = fr.addVar(v.getValue());
		List<String> addrs = new ArrayList<>();
		addrs.add(addr);
		return new ReturnIterateExpr(addrs, new ArrayList<>());
	}

	private ReturnIterateExpr iterateElement(Hd h, FunctionRepresentation fr) throws SymbolTableError {
		ReturnIterateExpr arg = iterateElement(h.getExpr(), fr);

		if (arg.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu pour le hd, nombre de paramètres données :"+ arg.getNbAddr());

		String res = fr.getNewTempVar();

		List<Code3Address> code = new ArrayList<>();
		code.addAll(arg.getListCode());
		code.add(new Code3Address(new HD(), res, arg.getListAddr().get(0), "_"));
		List<String> addrs = new ArrayList<>();
		addrs.add(res);

		return new ReturnIterateExpr(addrs, code);
	}


	private ReturnIterateExpr iterateElement(Tl h, FunctionRepresentation fr) throws SymbolTableError {
		ReturnIterateExpr arg = iterateElement(h.getExpr(), fr);

		if (arg.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu pour le tl, nombre de paramètres données :"+ arg.getNbAddr());

		String res = fr.getNewTempVar();

		List<Code3Address> code = new ArrayList<>();
		code.addAll(arg.getListCode());
		code.add(new Code3Address(new TL(), res, arg.getListAddr().get(0), "_"));
		List<String> addrs = new ArrayList<>();
		addrs.add(res);

		return new ReturnIterateExpr(addrs, code);
	}

	private ReturnIterateExpr iterateElement(Cons c, FunctionRepresentation fr) throws SymbolTableError {

		EList<Expr> listExp = c.getExprs().getList();
		List<Code3Address> code = new ArrayList<>();
		List<String> addrs = new ArrayList<>();

		List<String> listTempAddr = new ArrayList<>();


		for(Expr e : listExp){
			ReturnIterateExpr rtExp1 = iterateElement(e,fr);
			code.addAll(rtExp1.getListCode());
			listTempAddr.addAll(rtExp1.getListAddr());
		}

		if (listTempAddr.size() < 2) throw new SymbolTableError("Au moins deux paramètres sont attendu pour le cons, nombre de paramètres données :"+ listTempAddr.size());

		boolean first = true;
		String res="",previousRes="";

		while(listTempAddr.size() > 0)
		{
			res = fr.getNewTempVar();

			if(first){
				code.add(new Code3Address(new CONS(), res,listTempAddr.get(listTempAddr.size()-2) , listTempAddr.get(listTempAddr.size()-1)));
				listTempAddr.remove(listTempAddr.size()-1);
				listTempAddr.remove(listTempAddr.size()-1);
				first=false;
			}
			else{
				code.add(new Code3Address(new CONS(), res,listTempAddr.get(listTempAddr.size()-1), previousRes));
				listTempAddr.remove(listTempAddr.size()-1);
			}
			previousRes = res;

		}

		addrs.add(res);
		return new ReturnIterateExpr(addrs, code);
	}

	private ReturnIterateExpr iterateElement(Call c, FunctionRepresentation fr) throws SymbolTableError{

		EList<Expr> le = c.getParams().getList();

		if(symbolTable.hasFunction(c.getName())){

			ArrayList<Code3Address> listCodeExp = new ArrayList<>();
			CALL call = new CALL();

			for(Expr e : le){
				ReturnIterateExpr rtExp = iterateElement(e,fr);
				listCodeExp.addAll(rtExp.getListCode());
				call.getListVarCall().addAll(rtExp.getListAddr());
			}

			for(int i=0; i<symbolTable.getFunction(c.getName()).getNbOutput(); i++ ){
				String idVarTemp = fr.getNewTempVar();
				call.getListVarReturn().add(idVarTemp);
			}

			//Verification nb input 
			if( call.getListVarCall().size() != symbolTable.getFunction(c.getName()).getNbInput() ){
				throw new SymbolTableError("Le nombre d'arguments données à la fonction "+c.getName()+" est incorrect");
			}

			listCodeExp.add(new Code3Address(call, "_", symbolTable.getFunction(c.getName()).getName(), "_"));			
			
			return new ReturnIterateExpr(call.getListVarReturn(), listCodeExp);
		}
		else{
			//Symbol simple avec paramètre
			//throw new SymbolTableError("La fonction "+c.getName()+" n'existe pas");
			EList<Expr> listExp = c.getParams().getList();
			List<Code3Address> code = new ArrayList<>();
			List<String> addrs = new ArrayList<>();

			List<String> listTempAddr = new ArrayList<>();


			for(Expr e : listExp){
				ReturnIterateExpr rtExp1 = iterateElement(e,fr);
				code.addAll(rtExp1.getListCode());
				listTempAddr.addAll(rtExp1.getListAddr());
			}

			if (listTempAddr.size() < 2) throw new SymbolTableError("Deux paramètres sont attendu pour une list, nombre de paramètres données :"+listTempAddr.size());

			boolean first = true;
			String res="",previousRes="";

			while(listTempAddr.size() > 0)
			{
				res = fr.getNewTempVar();

				if(first){
					code.add(new Code3Address(new CONS(), res,listTempAddr.get(listTempAddr.size()-1), symbolTable.getSymbol("nil") ));
					listTempAddr.remove(listTempAddr.size()-1);
					first=false;
				}
				else{
					code.add(new Code3Address(new CONS(), res,listTempAddr.get(listTempAddr.size()-1), previousRes));
					listTempAddr.remove(listTempAddr.size()-1);
				}
				previousRes = res;

			}
			res = fr.getNewTempVar();

			code.add(new Code3Address(new CONS(), res,symbolTable.addSymbol(c.getName()) , previousRes));

			addrs.add(res);
			return new ReturnIterateExpr(addrs, code);
		}
	}

	private ReturnIterateCmd iterateElement(For f, FunctionRepresentation fr) throws SymbolTableError {

		FOR fo = new FOR();

		Expr cond = f.getCondition();

		ReturnIterateExpr rtCond = iterateElement(cond,fr);

		if (rtCond.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu pour le for, nombre de paramètres données :"+ rtCond.getNbAddr());

		//Do

		Commands do_ = f.getCommands();
		ReturnIterateCmd rtDo = iterateElement(do_, fr);

		fo.setListCodeCondition(rtCond.getListCode());
		fo.setListCodeDo(rtDo.getListCode());

		Code3Address codeFor = new Code3Address(fo, "_", rtCond.getListAddr().get(0), "_");
		ArrayList<Code3Address> l =new ArrayList<>();
		l.add(codeFor);

		return new ReturnIterateCmd(l);

	}

	private ReturnIterateCmd iterateElement(While w, FunctionRepresentation fr) throws SymbolTableError {

		WHILE wh = new WHILE();

		Expr cond = w.getCondition();

		ReturnIterateExpr rtCond = iterateElement(cond,fr);

		if (rtCond.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu pour le while, nombre de paramètres données :"+ rtCond.getNbAddr());

		//Do

		Commands do_ = w.getCommands();
		ReturnIterateCmd rtDo = iterateElement(do_, fr);

		wh.setListCodeCondition(rtCond.getListCode());
		wh.setListCodeDo(rtDo.getListCode());

		Code3Address codeWhile = new Code3Address(wh, "_", rtCond.getListAddr().get(0), "_");
		ArrayList<Code3Address> l =new ArrayList<>();
		l.add(codeWhile);

		return new ReturnIterateCmd(l);

	}	

	private ReturnIterateCmd iterateElement(ForEach fe, FunctionRepresentation fr) throws SymbolTableError {

		FOREACH fo = new FOREACH();

		Expr cond = fe.getElem();

		ReturnIterateExpr rtCond = iterateElement(cond,fr);

		//In 

		Expr in = fe.getEnsemb();

		ReturnIterateExpr rtIn = iterateElement(in,fr);

		if (rtCond.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu pour le foreach, nombre de paramètres données :"+ rtCond.getNbAddr());
		if (rtIn.getNbAddr() != 1) throw new SymbolTableError("Un seul paramètre est attendu pour le foreach, nombre de paramètres données :"+ rtIn.getNbAddr());

		//Do

		Commands do_ = fe.getCommands();
		ReturnIterateCmd rtDo = iterateElement(do_, fr);

		fo.setListCodeCondition(rtCond.getListCode());
		fo.setListCodeDo(rtDo.getListCode());
		fo.setListCodeIn(rtIn.getListCode());

		Code3Address codeFor = new Code3Address(fo, "_", rtCond.getListAddr().get(0), rtIn.getListAddr().get(0));
		ArrayList<Code3Address> l =new ArrayList<>();
		l.add(codeFor);

		return new ReturnIterateCmd(l);


	}	

	private ReturnIterateCmd iterateElement(If i, FunctionRepresentation fr) throws SymbolTableError {
		IF if_ = new IF();

		Expr cond = i.getCondition();

		ReturnIterateExpr rtCond = iterateElement(cond,fr);

		if (rtCond.getNbAddr() != 1) throw new SymbolTableError("Le if n'attend qu'un seul paramètre, nombre de paramètres donnés : "+ rtCond.getNbAddr());

		//If
		ReturnIterateCmd rtThen = iterateElement(i.getThenCommands(), fr);

		//Else

		Commands els = i.getElseCommands();
		if(els !=null){

			ReturnIterateCmd rtElse = iterateElement(els, fr);
			if_.setListCodeElse(rtElse.getListCode());
		}
		if_.setListCodeCondition(rtCond.getListCode());
		if_.setListCodeThen(rtThen.getListCode());


		Code3Address codeIf = new Code3Address(if_, "_", rtCond.getListAddr().get(0), "_");
		ArrayList<Code3Address> l =new ArrayList<>();
		l.add(codeIf);

		return new ReturnIterateCmd(l);
	}

}
