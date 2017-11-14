package esir.compilation.generator;


import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

import esir.compilation.WhdslStandaloneSetupGenerated;


//https://stackoverflow.com/questions/46683036/how-do-i-include-xtext-generator-in-my-maven-project

public class Main {
	
	
	public static void main(String[] args) throws ErrorPrettyPrinterException {
		
		System.out.println("START Pretty printing");
		
		//Injection class Google Guice
		Injector injector = new WhdslStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		main.prettyprint(injector,"test.whdsl","sortie.whdsl");
		
		System.out.println("END Pretty printing");
	}
	
	private int prettyprint(Injector injector, String string,String sortie) throws ErrorPrettyPrinterException{

		ResourceSet resourceSet = injector.getInstance(ResourceSet.class);
		Resource resource = resourceSet.getResource(URI.createFileURI(string), true);
		
		//Analyse du fichier
		IResourceValidator validator = injector.getInstance(IResourceValidator.class);;
		List<Issue> listIssue = validator.validate(resource,CheckMode.ALL, CancelIndicator.NullImpl);
	
		
		//Affichage des erreurs rencontrées dans le fichier
		if (!listIssue.isEmpty()) {
			for (Issue issue : listIssue) {
				throw new ErrorPrettyPrinterException(issue.getMessage());
			}
			return -1;
		}

		JavaIoFileSystemAccess file = injector.getInstance(JavaIoFileSystemAccess.class);
		file.setOutputPath("./");
		
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		
		WhdslGenerator generator = injector.getInstance(WhdslGenerator.class);
		generator.doGenerate(resource, file, context, sortie);

		System.out.println("Success");
		
		return 0;
	}
}