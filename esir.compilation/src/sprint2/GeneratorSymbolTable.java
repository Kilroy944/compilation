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

import com.google.inject.Provider;
import com.google.inject.Inject;

import esir.compilation.WhdslStandaloneSetupGenerated;
import esir.compilation.generator.WhdslGenerator;
import esir.compilation.whdsl.*;
import sprint2.operations.BOUCHON;
import sprint2.operations.IF;
import sprint2.operations.READ;
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
		iterateElement(c.getCommands(),fr);
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
	
	private void iterateElement(Commands c, FunctionRepresentation fr){
		
		EList<Command> l = c.getList();
		if(l!=null){
			for(Command co : l){
				iterateElement(co,fr);	
			}
		}
		
		
	}
	private void iterateElement(Command c, FunctionRepresentation fr){
		
		EObject o = c.getCmd();
		
		if(o instanceof For){
			iterateElement((For)o,fr);
		}
		else if(o instanceof Affect){
			iterateElement((Affect)o,fr);
		}
		else if(o instanceof If){
			iterateElement((If)o,fr);
		}
		else if(o instanceof Nop){
			iterateElement((Nop)o,fr);
		}
		else if(o instanceof While){
			iterateElement((While)o, fr);
		}
		else if(o instanceof ForEach){
			iterateElement((ForEach)o, fr);
		}
		else {
			fr.addCode3Address(new Code3Address(new BOUCHON(), "_", "_", "_"));;
		}
		
	}
	
	private void iterateElement(Nop a, FunctionRepresentation fr) {
		//fr.getCode().addCode3Adress(fr.getCode().getCurrentTag(), new Code3Address(Op.NOP, "_", "_", "_"));;
	}
	
	private void iterateElement(Affect a, FunctionRepresentation fr) {
		iterateElement(a.getExprs(),fr);
		EList<String> vars =a.getVars().getList();
		EList<Expr> exprs = a.getExprs().getList();
		//Vérifier que le nombre de var a gauche et droite est correcte

		int indexExpr = 0;
		for(String v : vars){
			fr.addVar(v);
			
		/*	String startTag = fr.getCode().getCurrentTag();
			String tagExp = fr.getCode().getNextTag();
			
			fr.getCode().addCode3Adress(startTag, new Code3Address(Op.AFFECT, v, tagExp, "_"));;
			
			fr.getCode().setCurrentTag(tagExp);

			iterateElement(exprs.get(indexExpr), fr);
			
			fr.getCode().setCurrentTag(startTag);*/
		}
		
	}

	private void iterateElement(Exprs exprs, FunctionRepresentation fr) {
		EList<Expr> l = exprs.getList();

		for(Expr e : l){
			iterateElement(e,fr);
		}
	}

	private void iterateElement(Expr e, FunctionRepresentation fr, ArrayList<Code3Address> a) {
		 
		if(e instanceof Call){
			iterateElement((Call)e,fr);
		}
		else if(e instanceof Cons){
			iterateElement((Cons)e,fr);
		}
		else{
			//fr.getCode().addCode3Adress(fr.getCode().getCurrentTag(), new Code3Address(Op.BOUCHON, "_", "_", "_"));;
		}
		
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
	
	
	private void iterateElement(Cons c, FunctionRepresentation fr){
		
		//String startTag = fr.getCode().getCurrentTag();

		c.getExprs();
	//	int idA = fr.addTempVar("A");

		//fr.getCode().addCode3Adress(startTag, new Code3Address(Op.CONS, ""+idA, "var suite" , "_"));
		
	}
	
	
	
	private void iterateElement(Call c/*,int nbOutput*/, FunctionRepresentation fr){
		
		
		if(symbolTable.hasFunction(c.getName())){
			
			if( c.getParams().getList().size() != symbolTable.getFunction(c.getName()).getNbInput() ){
				throw new SymbolTableError();
			}
			
			
		}
		else{
			throw new SymbolTableError();
		}
	}
	private void iterateElement(For c, FunctionRepresentation fr){
		/*
		String startTag = fr.getCode().getCurrentTag();

		String tagCond = fr.getCode().getNextTag();
		fr.getCode().setCurrentTag(tagCond);

		Expr cond = c.getCondition();
		iterateElement(cond,fr);

		String tagFor = fr.getCode().getNextTag();
		fr.getCode().setCurrentTag(tagFor);

		Commands fo = c.getCommands();
		
		iterateElement(fo, fr);
		
		fr.getCode().addCode3Adress(startTag, new Code3Address(Op.FOR, tagCond, tagFor, "_"));
		fr.getCode().setCurrentTag(startTag);*/

	}
	
	private ReturnIterate iterateElement(While w, FunctionRepresentation fr){
		
		return null;
		/*String startTag = fr.getCode().getCurrentTag();

		String tagCond = fr.getCode().getNextTag();
		fr.getCode().setCurrentTag(tagCond);

		Expr cond = w.getCondition();
		iterateElement(cond,fr);

		String tagWhile = fr.getCode().getNextTag();
		fr.getCode().setCurrentTag(tagWhile);

		Commands fo = w.getCommands();
		
		iterateElement(fo, fr);
		
		fr.getCode().addCode3Adress(startTag, new Code3Address(Op.WHILE, tagCond, tagWhile, "_"));
		fr.getCode().setCurrentTag(startTag);*/
		
	}	
	
	private ReturnIterate iterateElement(ForEach fe, FunctionRepresentation fr){
		return null;
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
