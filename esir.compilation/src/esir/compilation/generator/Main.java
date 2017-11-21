package esir.compilation.generator;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;
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
		
		//Récupération arguments
		Options options = new Options();
		options.addOption("o", true, "nom du fichier de sortie");
		options.addOption("indent", true, "valeur indent");
		options.addOption("if", true, "indent if");
		options.addOption("for", true, "indent for");
		options.addOption("foreach", true, "indent foreach");
		options.addOption("while", true, "indent while");
		options.addOption("test", true, "effectuer les tests");
		
		
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
		output = cmd.hasOption("o") ? cmd.getOptionValue("o") : "sortie.whdsl";
		
		
		//Injection class Google Guice
		Injector injector = new WhdslStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		
		String indent_value = main.create_indent(" ",cmd.hasOption("indent") ? Integer.parseInt(cmd.getOptionValue("indent")) : 3);
		String indent_if = main.create_indent(indent_value,cmd.hasOption("if") ? Integer.parseInt(cmd.getOptionValue("if")) : 1);
		String indent_for = main.create_indent(indent_value,cmd.hasOption("for") ? Integer.parseInt(cmd.getOptionValue("for")) : 1);
		String indent_foreach = main.create_indent(indent_value,cmd.hasOption("foreach") ? Integer.parseInt(cmd.getOptionValue("foreach")) : 1);
		String indent_while = main.create_indent(indent_value,cmd.hasOption("while") ? Integer.parseInt(cmd.getOptionValue("while")) : 1);

		
		//Pretty printing
		System.out.println("START Pretty printing");
		main.prettyprint(injector,input,output, indent_value, indent_if, indent_for,indent_foreach, indent_while);
		System.out.println("END Pretty printing");
		
		if(cmd.hasOption("test")){
			try {
				test(null,null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private int prettyprint(Injector injector, String string,String sortie, String indent_value, String indent_if, String indent_for, String indent_foreach, String indent_while) throws ErrorPrettyPrinterException{

		ResourceSet resourceSet = injector.getInstance(ResourceSet.class);
		Resource resource = resourceSet.getResource(URI.createFileURI(string), true);
		
		//Analyse du fichier
		IResourceValidator validator = injector.getInstance(IResourceValidator.class);;
		List<Issue> listIssue = validator.validate(resource,CheckMode.ALL, CancelIndicator.NullImpl);
	
		
		//Affichage des erreurs rencontrées dans le fichier
		if (!listIssue.isEmpty()) {
			for (Issue issue : listIssue) {
				throw new ErrorPrettyPrinterException(issue.getMessage(), issue.getLineNumber(), issue.getOffset());
			}
			return -1;
		}

		JavaIoFileSystemAccess file = injector.getInstance(JavaIoFileSystemAccess.class);
		file.setOutputPath("./");
		
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		
		WhdslGenerator generator = injector.getInstance(WhdslGenerator.class);
		generator.doGenerate(resource, file, context, sortie, indent_value, indent_if, indent_for, indent_foreach, indent_while);

		System.out.println("Success");
		
		return 0;
	}
	
	
	private String create_indent(String value, int nb_repeat){
		String value_return = "";
		
		for(int i=0; i<nb_repeat; i++){
			value_return= value_return+value;
		}
		return value_return;
	}
	
	// Méthode qui vérifie l'égalité entre 2 listes de fichiers
    public static boolean test(List<String> good, List<String> a_test) throws IOException {
        for (int i = 0; i < good.size() && i < a_test.size(); i++) {
        	System.out.println(good.get(i)+" "+a_test.get(i));
            if (FileUtils.contentEquals(new File("les_tests/"+good.get(i)), new File("les_tests/"+a_test.get(i))) == false) {
            	System.out.println("oui");
                return false;
            }
        }
        return true;
    }
}