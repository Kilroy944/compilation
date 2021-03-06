package esir.compilation.generator;


import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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


	public static void main(String[] args) throws IOException {

		//Récupération arguments
		Options options = new Options();
		options.addOption("o", true, "nom du fichier de sortie");
		options.addOption("all", true, "valeur indent");
		options.addOption("if", true, "indent if");
		options.addOption("for", true, "indent for");
		options.addOption("foreach", true, "indent foreach");
		options.addOption("while", true, "indent while");
		options.addOption("test", false, "effectuer les tests");
		options.addOption("help", false, "manuel d'utilisation");


		//Injection class Google Guice
		Injector injector = new WhdslStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);


		CommandLineParser parser = new BasicParser();
		CommandLine cmd;
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println("Erreur dans les arguments : " + e.getMessage());
			return;
		}

		//HELP
		if(cmd.hasOption("help")){
			printMan();
			return;
		}

		//TEST
		if(cmd.hasOption("test")){
			main.test(cmd,main, injector);
			return;
		}



		String input, output;
		if (cmd.getArgs().length != 1) {
			System.out.println("Erreur dans les arguments : fichier d'entrée manquant ou plusieurs renseignés");
			return;
		}
		input = cmd.getArgs()[0];
		
		if(!new File(input).exists()){
			System.out.println("Erreur: fichier d'entrée inexistant");
			return;
		}
		
		if (!input.endsWith(".wh")) {
			System.out.println("Erreur dans les arguments : le fichier d'entrée doit avoir l'extension .wh");
			return;
		}
		
		output = cmd.hasOption("o") ? cmd.getOptionValue("o") : input.split(".wh")[0] + ".whpp";

		String indent_value = main.create_indent(" ",cmd.hasOption("all") ? Integer.parseInt(cmd.getOptionValue("all")) : 2);
		String indent_if = main.create_indent(indent_value,cmd.hasOption("if") ? Integer.parseInt(cmd.getOptionValue("if")) : 1);
		String indent_for = main.create_indent(indent_value,cmd.hasOption("for") ? Integer.parseInt(cmd.getOptionValue("for")) : 1);
		String indent_foreach = main.create_indent(indent_value,cmd.hasOption("foreach") ? Integer.parseInt(cmd.getOptionValue("foreach")) : 1);
		String indent_while = main.create_indent(indent_value,cmd.hasOption("while") ? Integer.parseInt(cmd.getOptionValue("while")) : 1);


		//Pretty printing
		System.out.println("START Pretty printing");
		try {
			main.prettyprint(injector,input,output, indent_value, indent_if, indent_for,indent_foreach, indent_while);
		} catch (ErrorPrettyPrinterException e) {
			e.printStackTrace();
		}
		System.out.println("END Pretty printing");

	}


	//-test rep_non_indent rep_good
	private int prettyprint(Injector injector, String string,String sortie, String indent_value, String indent_if, String indent_for, String indent_foreach, String indent_while) throws ErrorPrettyPrinterException{

		ResourceSet resourceSet = injector.getInstance(ResourceSet.class);
		Resource resource = resourceSet.getResource(URI.createFileURI(string), true);

		//Analyse du fichier
		IResourceValidator validator = injector.getInstance(IResourceValidator.class);
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


	
	public static void printMan(){
		BufferedReader fent;
		try {
			
			InputStream is =Main.class.getClassLoader().getResourceAsStream("README.md");
			fent = new BufferedReader(new InputStreamReader(is));
			
			//fent = new BufferedReader(new FileReader(new File("./README.md")));
			String enr;
			while ( ( enr = fent.readLine( ) ) != null ) // null en cas de fin de fichier
			{
				System.out.println( enr );
			}
			fent.close( );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	

	private void test(CommandLine cmd, Main main, Injector injector) throws IOException {
		
		if (cmd.getArgs().length != 2) {
			System.out.println("Erreur dans les arguments : répertoire de test");
			return;
		}

		/*Ouverture du répertoire des fichiers à indenter*/
		File rep_non_indent = new File(cmd.getArgs()[0]);

		if(!(rep_non_indent.exists() && rep_non_indent.isDirectory())){
			System.out.println("Repertoire de test inexistant");
			return;
		}

		/*Ouverture du répertoire des fichiers indenter*/
		File rep_good = new File(cmd.getArgs()[1]);
		
		if(!(rep_good.exists() && rep_good.isDirectory())){
			System.out.println("Repertoire de test inexistant");
			return;
		}

		/*Récupération des fichiers .wh à indenter*/
		File[] fichier_non_indent = rep_non_indent.listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".wh");
			}
		});

		File rep_pretty_print = new File("./rep_pretty_print");
		rep_pretty_print.mkdir();
		
		/*Pour tous les fichiers non indentés */
		for (File file : fichier_non_indent) {

			System.out.println("---------------DEBUT TEST---------------");
			System.out.println("Test pretty print: "+file.getName());

			String path_fichier_sortie = "./"+rep_pretty_print.getPath()+"/"+(file.getName().split(".wh")[0])+".whpp";

			try {
				if(main.prettyprint(injector, file.getPath(), path_fichier_sortie,"  ","  ","  ","  ","  ") != 0){
					System.out.println("ERREUR: echec de la validation");
				}
				else{
					/*Recupère le fichier good correspondant à celui qui à été indenté*/
					File fichier_good = new File("./"+rep_good.getPath()+"/"+(file.getName().split(".wh")[0])+".whpp");

					/*Si le fichier good existe, il est comparé à celui indenté par le pretty*/
					if(!(fichier_good.exists())){
						System.out.println("Comparaison impossible: fichier à comparer non trouvé");
					}
					else{
						if (FileUtils.contentEquals(new File(path_fichier_sortie),fichier_good) == false) {
							System.out.println("ERREUR: Fichier pretty print et fichier bien indenté différent");
						}
						else{
							System.out.println("SUCCES: Pretty print réussi");
						}
					}
				}
			} catch (ErrorPrettyPrinterException e) {
				System.out.println(e.getMessage());
			}


		}
		System.out.println("---------------FIN TEST---------------");

	}
}