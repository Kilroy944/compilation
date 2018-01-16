package sprint2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class MainSprint2 {


	public static String Indent = "   ";


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

		if(args.length == 2){
			if(!new File(args[0]).exists()){
				System.out.println("Erreur: fichier d'entrée inexistant");
				return;
			}

			if (!args[0].endsWith(".wh")) {
				System.out.println("Erreur dans les arguments : le fichier d'entrée doit avoir l'extension .wh");
				return;
			}
			if (!args[1].endsWith(".go")) {
				System.out.println("Erreur dans les arguments : le fichier de sortie doit avoir l'extension .go");
				return;
			}
			try {
				genTs.init(args[0], args[1]);
				execGo(args[1]);
			} catch (DoubleFunctionException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Erreur dans les arguments : nb d'arguments incorrect");
			return;
		}
	}

	private static void execGo(String prog) {
		
	/*	System.out.println("###### COMPILATION GO #######");
		Process p;
		System.out.println("go build "+prog);
		try {
			p = Runtime.getRuntime().exec("go build "+prog);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("###### EXECUTION GO #######");
		try {
			p = Runtime.getRuntime().exec("./"+prog.split(".go")[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}

	private static int test(CommandLine cmd, GeneratorSymbolTable genTs) {

		if (cmd.getArgs().length != 1) {
			System.out.println("Erreur dans les arguments : répertoire de test");
			return -1;
		}

		/*Ouverture du répertoire des fichiers à tester*/
		File rep_test = new File(cmd.getArgs()[0]);

		if(!(rep_test.exists() && rep_test.isDirectory())){
			System.out.println("Repertoire de test inexistant");
			return -1;
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
		return 0;

	}
}
