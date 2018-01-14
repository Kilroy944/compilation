package sprint2;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class MainSprint2 {


	/*args[0] = fichier d'entrée args[1] = fichier de sortie*/
	public static void main(String args[]) throws IOException{
		
		//Récupération arguments
		Options options = new Options();
		options.addOption("test", false, "effectuer les tests");
		
		CommandLineParser parser = new BasicParser();
		CommandLine cmd;
		
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println("Erreur dans les arguments : " + e.getMessage());
			return;
		}
		
		GeneratorSymbolTable genTs = GeneratorSymbolTable.getInstance();
		
		
		if(cmd.hasOption("test")){
			test(cmd, genTs);
			return;
		}
		
		if(args.length == 0){
			try {
				genTs.init("input.wh");
			} catch (DoubleFunctionException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				genTs.init(args[0], args[1]);
			} catch (DoubleFunctionException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void test(CommandLine cmd, GeneratorSymbolTable genTs) {
		
		if (cmd.getArgs().length != 1) {
			System.out.println("Erreur dans les arguments : répertoire de test");
			return;
		}

		/*Ouverture du répertoire des fichiers à tester*/
		File rep_test = new File(cmd.getArgs()[0]);

		if(!(rep_test.exists() && rep_test.isDirectory())){
			System.out.println("Repertoire de test inexistant");
			return;
		}


		/*Récupération des fichiers .wh à indenter*/
		File[] fichier_a_test = rep_test.listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".wh");
			}
		});

		File rep_code_3A = new File("./rep_code_3A");
		rep_code_3A.mkdir();
		
		System.out.println("---------------DEBUT TEST---------------");

		/*Pour tous les fichiers a tester */
		for (File file : fichier_a_test) {
			System.out.println("Test code 3@: "+file.getName());

			String path_fichier_sortie = "./"+rep_code_3A.getPath()+"/"+(file.getName().split(".wh")[0])+".txt";
			
			try{
			genTs.init(file.getPath(), path_fichier_sortie);
			}catch(IOException ioe){
				ioe.printStackTrace();
			}

		}
		System.out.println("---------------FIN TEST---------------");

	}
}
