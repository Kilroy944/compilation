package sprint2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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

		//Récupération arguments
		Options options = new Options();
		options.addOption("o", true, "nom du fichier de sortie");
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
		}
		if(cmd.hasOption("fGo")){
			file_go = true;
		}

		if(args.length >= 1){
			if(!new File(args[0]).exists()){
				System.out.println("Erreur: fichier d'entrée inexistant");
				return;
			}

			if (!args[0].endsWith(".wh")) {
				System.out.println("Erreur dans les arguments : le fichier d'entrée doit avoir l'extension .wh");
				return;
			}
			try {
				
				String output = cmd.hasOption("o") ? cmd.getOptionValue("o") : args[0].split(".wh")[0];
				
				genTs.init(args[0], output, file_3a);
				compileGo(output, file_go);
			}  catch (SymbolTableError e) {
				System.out.println("Une erreur est survenue : "+e.getMessage()+"\n");
			}
		}
		else{
			System.out.println("Erreur dans les arguments : nb d'arguments incorrect");
			return;
		}
	}

	private static void compileGo(String prog, boolean file_go) {
		System.out.println("###### BUILD GO #######");
		 
		try { 
			Runtime r = Runtime.getRuntime(); 
			Process p = r.exec("go build "+prog+".go"); 
 
			String s =null; 
 
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream())); 
 
			StringBuffer buffer = new StringBuffer();
 
			while ((s = reader.readLine()) != null) { 
				 buffer.append(s);
			} 
 
			String result = buffer.toString();
			
			System.out.println(result);
 
		}catch(Exception e) { 
				System.out.println("Erreur d'execution de la compilation"+ e.getMessage()); 
		}


		if(!file_go){
			new File(prog+".go").delete();
		}
		
		System.out.println("###### BUILD END #######");

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
			} catch (SymbolTableError e) {
				System.out.println("Une erreur est survenue : "+e.getMessage()+"\n");
			}

		}
		System.out.println("---------------FIN TEST---------------");
		return 0;

	}
}
