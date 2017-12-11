package sprint2;

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

import com.google.inject.Provider;
import com.google.inject.Inject;

import esir.compilation.WhdslStandaloneSetupGenerated;
import esir.compilation.generator.WhdslGenerator;
import esir.compilation.whdsl.*;

public class GeneratorSymbolTable {

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	
	private String inputFile,outputFile;
	
	private HashMap<String, FunctionRepresentation> listFunctions;
	
	
	private SymbolTable symbolTable;
	
	
	public static GeneratorSymbolTable getInstance(){
		return new WhdslStandaloneSetupGenerated().createInjectorAndDoEMFRegistration().getInstance(GeneratorSymbolTable.class);
	}
	
	public void init(String inputFile,String outFile) {
		
		this.inputFile=inputFile;
		this.outputFile=outFile;
		listFunctions=new HashMap<>();
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
	 */
	private void registerFunctions(Program program) {
		
		for (Function f : program.getFunctions()) {
			
			if(!listFunctions.containsKey(f.getName())){
				listFunctions.put(f.getName(), new FunctionRepresentation());
			}
			else{
				
			}
		}
	}
	
	private void iterateElement(Program p){
		for (Function f : p.getFunctions()) {
			iterateElement(f,listFunctions.get(f.getName()));
		}
	}
	private void iterateElement(Function f, FunctionRepresentation fr){
		
		//Ajout etiquette + mise à jour du nom de la fonction avec son id unique
		fr.setName(symbolTable.addTag(f.getName()));
		
		iterateElement(f.getDefinition(),fr);
	}
	private void iterateElement(Definition c, FunctionRepresentation fr){

		iterateElement(c.getInput(),fr);
		iterateElement(c.getOutput(),fr);
	}
	
	private void iterateElement(Input i, FunctionRepresentation fr){
		
		EList<String> vars = i.getVars().getList();
	
		for(String v : vars){
			Code3Address codeRead = new Code3Address(Op.READ, v, "", "");
			symbolTable.addOp(fr.getName(), codeRead);
		}
		
	}
	
	private void iterateElement(Output o, FunctionRepresentation fr){
		EList<String> vars = o.getVars().getList();
		
		for(String v : vars){
			Code3Address codeWrite = new Code3Address(Op.WRITE, v, "", "");
			symbolTable.addOp(fr.getName(), codeWrite);
		}
	}
	
	private void iterateElement(Command c, FunctionRepresentation fr){
	}
	
}
