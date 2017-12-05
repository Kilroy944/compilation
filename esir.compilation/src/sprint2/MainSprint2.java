package sprint2;

import java.net.URI;
import java.util.List;

import org.antlr.runtime.tree.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

import esir.compilation.WhdslStandaloneSetupGenerated;
import esir.compilation.whdsl.Program;

public class MainSprint2 {

	public static void main(String[] args){
		//Injection class Google Guice
		Injector injector = new WhdslStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		MainSprint2 main = injector.getInstance(MainSprint2.class);


		// Load the resource
		ResourceSet set = resourceSetProvider.get();
		IResourceValidator validator = injector.getInstance(IResourceValidator.class);
		Resource resource = set.getResource(URI.createFileURI(new Path("test"), true);

		// Validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			return;
		}

		TreeIterator<EObject> tree = resource.getAllContents();
		while (tree.hasNext()) {
			EObject next = tree.next(); //AST
			if (next instanceof Program) {
				//discoverFunctions((Program) next); // Just read the function's names and inputs / outputs
				//iterateAST((Program) next); // Start to discover all the program
			}
		}
	}

}
