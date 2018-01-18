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

		boolean file_3a = false;
		boolean file_go = false;

		int nb_arg_needed = 2;


		//Récupération arguments
		Options options = new Options();
		options.addOption("test", false, "effectuer les tests");
		options.addOption("f3a", false, "génére fichier 3@");
		options.addOption("fGo", false, "génére fichier Go");


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

		if(cmd.hasOption("f3a")){
			file_3a = true;
			nb_arg_needed++;
		}
		if(cmd.hasOption("fGo")){
			file_go = true;
			nb_arg_needed++;
		}

		if(args.length == nb_arg_needed){
			if(!new File(args[0]).exists()){
				System.out.println("Erreur: fichier d'entrée inexistant");
				return;
			}

			if (!args[0].endsWith(".wh")) {
				System.out.println("Erreur dans les arguments : le fichier d'entrée doit avoir l'extension .wh");
				return;
			}
			try {
				genTs.init(args[0], args[1], file_3a);
				compileGo(args[1], file_go);
			} catch (DoubleFunctionException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Erreur dans les arguments : nb d'arguments incorrect");
			return;
		}
	}

	private static void compileGo(String prog, boolean file_go) {

		System.out.println("###### COMPILATION GO #######");
		Process p;
		try {
			p = Runtime.getRuntime().exec("go build "+prog+".go");


			// Consommation de la sortie standard de l'application externe dans un Thread separe
			new Thread() {
				public void run() {
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
						String line = "";
						try {
							while((line = reader.readLine()) != null) {
								System.out.println(line);
							}
						} finally {
							reader.close();
						}
					} catch(IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}.start();


			p.waitFor();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(!file_go){
			new File(prog+".go").delete();
		}

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

			String path_fichier_sortie = "./"+rep_code_3A.getPath()+"/"+(file.getName().split(".wh")[0]);

			try{
				genTs.init(file.getPath(), path_fichier_sortie, true);
			}catch(IOException ioe){
				ioe.printStackTrace();
			}

		}
		System.out.println("---------------FIN TEST---------------");
		return 0;

	}
}
