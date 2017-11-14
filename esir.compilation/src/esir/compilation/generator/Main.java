package esir.compilation.generator;


import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import esir.compilation.WhdslStandaloneSetupGenerated;


public class Main {
	
	
	//Injection class Google Guice

	@Inject
	private IResourceValidator validator;
	@Inject
	private WhdslGenerator generator;
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	@Inject 
	private JavaIoFileSystemAccess file;
	
	
	public static void main(String[] args) throws ErrorPrettyPrinterException {
		// gestion des arguments
		Options options = new Options();
		options.addOption("o", true, "nom du fichier de sortie");

		CommandLineParser parser = new BasicParser();
		CommandLine cmd;
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println("Erreur dans les arguments : " + e.getMessage());
			e.printStackTrace();
			return;
		}

		String input, output;
		if (cmd.getArgs().length != 1) {
			System.out.println("Erreur dans les arguments : fichier d'entrée manquant ou plusieurs renseignés");
			return;
		}
		input = cmd.getArgs()[0];
		output = cmd.hasOption("o") ? cmd.getOptionValue("o") : "sortie.whpp";

		// pretty printing
		System.out.println("START Pretty printing");
		
		Injector injector = new WhdslStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		main.runGenerator(input, output);
		
		System.out.println("END Pretty printing");
	}
	
	private int runGenerator(String string,String sortie) throws ErrorPrettyPrinterException{

		ResourceSet resourceSet = resourceSetProvider.get();
		Resource resource = resourceSet.getResource(URI.createFileURI(string), true);
		
		//Analyse du fichier
		List<Issue> listIssue = validator.validate(resource,CheckMode.ALL, CancelIndicator.NullImpl);
	
		
		//Affichage des erreurs rencontrées dans le fichier
		if (!listIssue.isEmpty()) {
			for (Issue issue : listIssue) {
				throw new ErrorPrettyPrinterException(issue.getMessage());
			}
			return -1;
		}

		
		file.setOutputPath("./");
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		
		generator.doGenerate(resource, file, context, sortie);

		System.out.println("Success");
		
		return 0;
	}
}