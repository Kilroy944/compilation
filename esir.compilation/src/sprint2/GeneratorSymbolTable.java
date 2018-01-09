package sprint2;

import java.util.ArrayList;
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
import esir.compilation.whdsl.Expr;
import esir.compilation.whdsl.Exprs;
import esir.compilation.whdsl.For;
import esir.compilation.whdsl.ForEach;
import esir.compilation.whdsl.Function;
import esir.compilation.whdsl.Hd;
import esir.compilation.whdsl.If;
import esir.compilation.whdsl.Input;
import esir.compilation.whdsl.LExpr;
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
import sprint2.operations.FOR;
import sprint2.operations.HD;
import sprint2.operations.IF;
import sprint2.operations.NOP;
import sprint2.operations.Nil;
import sprint2.operations.READ;
import sprint2.operations.TL;
import sprint2.operations.WHILE;
import sprint2.operations.WRITE;

public class GeneratorSymbolTable {

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	
	private String inputFile,outputFile;
		
	private SymbolTable symbolTable;
	
	public static GeneratorSymbolTable getInstance(){
		return new WhdslStandaloneSetupGenerated().createInjectorAndDoEMFRegistration().getInstance(GeneratorSymbolTable.class);
	}
	
	public void init(String inputFile,String outFile) throws DoubleFunctionException {
		
		this.inputFile=inputFile;
		this.outputFile=outFile;
		symbolTable =new SymbolTable();
		
		//Récupération du fichier while source
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createFileURI(inputFile), true);

		//Vérifie si le fichier while est correct
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			return;
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
		
		System.out.println(symbolTable);
	}
	
	
	/**
	 * Sauvegarde dans une liste les définitions des fonctions d'un programme et s'assure de leur unicité
	 * @param program
	 * @throws DoubleFunctionException 
	 */
	private void registerFunctions(Program program) throws DoubleFunctionException {
		
		for (Function f : program.getFunctions()) {
			
				symbolTable.addFunction(f.getName(),f.getDefinition().getInput().getVars().getList().size()
						,f.getDefinition().getOutput().getVars().getList().size());
		}
	}
	
	private void iterateElement(Program p){
		for (Function f : p.getFunctions()) {
			iterateElement(f,symbolTable.getFunction(f.getName()));
		}
	}
	private void iterateElement(Function f, FunctionRepresentation fr){
		iterateElement(f.getDefinition(),fr);
	}
	private void iterateElement(Definition c, FunctionRepresentation fr){
		iterateElement(c.getInput(),fr);
		ReturnIterate rt = iterateElement(c.getCommands(),fr);
		
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
	
	private ReturnIterate iterateElement(Commands c, FunctionRepresentation fr){
		
		ArrayList<Code3Address> fusion = new ArrayList<>();
		
		EList<Command> l = c.getList();
		if(l!=null){
			for(Command co : l){
				ReturnIterate rt = iterateElement(co,fr);	
				fusion.addAll(rt.getListCode());
			}
		}
		
		return new ReturnIterate("", fusion);		
	}
	private ReturnIterate iterateElement(Command c, FunctionRepresentation fr){
		
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
			Code3Address codeIf = new Code3Address(new BOUCHON(), "_", "_", "_");
			ArrayList<Code3Address> la =new ArrayList<>();
			la.add(codeIf);
			
			return new ReturnIterate("_", la);
		}
		
	}
	
	
	private ReturnIterate iterateElement(Nop a, FunctionRepresentation fr) {
		
		Code3Address code = new Code3Address(new NOP(), "_", "_", "_");
		ArrayList<Code3Address> la =new ArrayList<>();
		la.add(code);
		
		return new ReturnIterate("_", la);
	}
	
	private ReturnIterate iterateElement(Affect a, FunctionRepresentation fr) {
		EList<String> vars =a.getVars().getList();
		EList<Expr> exprs = a.getExprs().getList();
		//Vérifier que le nombre de var a gauche et droite est correcte

		List<Code3Address> listAffectation =new ArrayList<>();

		
		int indexExpr = 0;
		for(String v : vars){
			String idV = fr.addVar(v);
			
			ReturnIterate rtExp = iterateElement(exprs.get(indexExpr),fr);
			indexExpr++;
			Code3Address codeIf = new Code3Address(new AFFECT(), idV , rtExp.getAddr(), "_");
			listAffectation.add(codeIf);
		}
		
		return new ReturnIterate("_", listAffectation);
	}

	private ReturnIterate iterateElement(Exprs exprs, FunctionRepresentation fr) {
		EList<Expr> l = exprs.getList();

		for(Expr e : l){
			iterateElement(e,fr);
		}
		
		Code3Address codeIf = new Code3Address(new BOUCHON(), "_", "_", "_");
		ArrayList<Code3Address> la =new ArrayList<>();
		la.add(codeIf);
		
		return new ReturnIterate("_", la);
		
	}

	private ReturnIterate iterateElement(Expr e, FunctionRepresentation fr) {
		 
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
			iterateElement((Call)e,fr);
		}
		

		Code3Address codeIf = new Code3Address(new BOUCHON(), "_", "_", "_");
		ArrayList<Code3Address> la =new ArrayList<>();
		la.add(codeIf);
		
		return new ReturnIterate("_", la);
	}
	/*
	 * 	{Nill} value=NIL | 
	{Variable} value=VARIABLE |
	{Symbol} value=SYMBOLE |
	'(' (
		{Cons} 'cons' exprs=LExpr |
		{List} 'list' exprs=LExpr |
		{Hd} 'hd' expr=Expr |
		{Tl} 'tl' expr=Expr |
		{Call} name=SYMBOLE params=LExpr |
		{EnclosedExpr} expr=Expr
	) ')'
	 * */

	private ReturnIterate iterateElement(Nill n, FunctionRepresentation fr) {
		String res = fr.getNewTempVar();

		List<Code3Address> code = new ArrayList<>();
		code.add(new Code3Address(new Nil(), res, "_", "_"));

		return new ReturnIterate(res, code);
	}
	
	private ReturnIterate iterateElement(Variable v, FunctionRepresentation fr) {
		return new ReturnIterate(fr.addVar(v.getValue()), new ArrayList<>());
	}

	private ReturnIterate iterateElement(Hd h, FunctionRepresentation fr) {
		ReturnIterate arg = iterateElement(h.getExpr(), fr);

		String res = fr.getNewTempVar();

		List<Code3Address> code = new ArrayList<>();
		code.addAll(arg.getListCode());
		code.add(new Code3Address(new HD(), res, arg.getAddr(), "_"));

		return new ReturnIterate(res, code);
	}
	
	
	private ReturnIterate iterateElement(Tl h, FunctionRepresentation fr) {
		ReturnIterate arg = iterateElement(h.getExpr(), fr);

		String res = fr.getNewTempVar();

		List<Code3Address> code = new ArrayList<>();
		code.addAll(arg.getListCode());
		code.add(new Code3Address(new TL(), res, arg.getAddr(), "_"));

		return new ReturnIterate(res, code);
	}
	
	private ReturnIterate iterateElement(Cons c, FunctionRepresentation fr) {
		// 2 args pour l'instant
		if (c.getExprs().getList().size() != 2) throw new IllegalArgumentException("Cons à 2 param seulement");
		
		ReturnIterate arg1 = iterateElement(c.getExprs().getList().get(0), fr);
		ReturnIterate arg2 = iterateElement(c.getExprs().getList().get(1), fr);

		String res = fr.getNewTempVar();

		List<Code3Address> code = new ArrayList<>();
		code.addAll(arg1.getListCode());
		code.addAll(arg2.getListCode());
		code.add(new Code3Address(new CONS(), res, arg1.getAddr(), arg2.getAddr()));

		return new ReturnIterate(res, code);
	}
	
	private ReturnIterate iterateElement(Call c/*,int nbOutput*/, FunctionRepresentation fr){
		
		
		if(symbolTable.hasFunction(c.getName())){
			
			if( c.getParams().getList().size() != symbolTable.getFunction(c.getName()).getNbInput() ){
				throw new SymbolTableError();
			}
			
			EList<Expr> le = c.getParams().getList();
			ArrayList<Code3Address> listCodeExp = new ArrayList<>();
			CALL call = new CALL();
			
			for(Expr e : le){
				ReturnIterate rtExp = iterateElement(e,fr);
				listCodeExp.addAll(rtExp.getListCode());
				call.getListVarCall().add(rtExp.getAddr());
			}
			//Comment lier les returns de la fonction aux variables affectées
			//Retourner plusieurs addr dans ReturnIterate ?
			for(int i=0; i<symbolTable.getFunction(c.getName()).getNbOutput(); i++ ){
				String idVarTemp = fr.getNewTempVar();
				call.getListVarReturn().add(idVarTemp);
			}
			
			List<Code3Address> code = new ArrayList<>();
			code.add(new Code3Address(call, "_", symbolTable.getFunction(c.getName()).getName(), "_"));			
			
			return new ReturnIterate("_", code);
		}
		else{
			throw new SymbolTableError();
		}
	}
	private ReturnIterate iterateElement(For f, FunctionRepresentation fr){
		
		FOR fo = new FOR();
		
		Expr cond = f.getCondition();
		
		ReturnIterate rtCond = iterateElement(cond,fr);
		
		//Do
		
		Commands do_ = f.getCommands();
		ReturnIterate rtDo = iterateElement(do_,fr);
		
		fo.setListCodeCondition(rtCond.getListCode());
		fo.setListCodeDo(rtDo.getListCode());

		Code3Address codeFor = new Code3Address(fo, "_", rtCond.getAddr(), "_");
		ArrayList<Code3Address> l =new ArrayList<>();
		l.add(codeFor);
		
		return new ReturnIterate("_", l);
	
	}
	
	private ReturnIterate iterateElement(While w, FunctionRepresentation fr){
		
		WHILE wh = new WHILE();
		
		Expr cond = w.getCondition();
		
		ReturnIterate rtCond = iterateElement(cond,fr);
		
		//Do
		
		Commands do_ = w.getCommands();
		ReturnIterate rtDo = iterateElement(do_,fr);
		
		wh.setListCodeCondition(rtCond.getListCode());
		wh.setListCodeDo(rtDo.getListCode());

		Code3Address codeWhile = new Code3Address(wh, "_", rtCond.getAddr(), "_");
		ArrayList<Code3Address> l =new ArrayList<>();
		l.add(codeWhile);
		
		return new ReturnIterate("_", l);
		
	}	
	
	private ReturnIterate iterateElement(ForEach fe, FunctionRepresentation fr){
		Code3Address codeIf = new Code3Address(new BOUCHON(), "_", "_", "_");
		ArrayList<Code3Address> la =new ArrayList<>();
		la.add(codeIf);
		
		return new ReturnIterate("_", la);
	}	
	
	private ReturnIterate iterateElement(If i, FunctionRepresentation fr){
		
		IF if_ = new IF();
		
		Expr cond = i.getCondition();
		
		ReturnIterate rtCond = iterateElement(cond,fr);
		
		//If
		ReturnIterate rtThen = iterateElement(i.getThenCommands(), fr);
		
		//Else
		
		Commands els = i.getElseCommands();
		if(els !=null){
			
			ReturnIterate rtElse = iterateElement(els, fr);
			if_.setListCodeElse(rtElse.getListCode());
		}
			if_.setListCodeCondition(rtCond.getListCode());
			if_.setListCodeThen(rtThen.getListCode());
		

		Code3Address codeIf = new Code3Address(if_, "_", rtCond.getAddr(), "_");
		ArrayList<Code3Address> l =new ArrayList<>();
		l.add(codeIf);
		
		return new ReturnIterate("_", l);
	}

}
