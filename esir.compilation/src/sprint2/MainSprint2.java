package sprint2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;

import esir.compilation.generator.Main;

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
		options.addOption("help", false, "aide");


		CommandLineParser parser = new BasicParser();
		CommandLine cmd;

		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println("Erreur dans les arguments : " + e.getMessage());
			return;
		}

		GeneratorSymbolTable genTs = GeneratorSymbolTable.getInstance();

		
		if(cmd.hasOption("help")){
			printMan();
			return;
		}
		
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
				
				if(genTs.init(args[0], output, file_3a) != 0){
					return;
				}
				compileGo(output, file_go);
			}  catch (SymbolTableError e) {
				System.out.println("\nUne erreur est survenue : "+e.getMessage()+"\n");
			}
		}
		else{
			System.out.println("Erreur dans les arguments : nombre d'arguments incorrect");
			return;
		}
	}
	

	private static void compileGo(String prog, boolean file_go) {
		System.out.println("###### BUILD GO #######");
		
		
		//Copie librairie GO
		String[] tab = prog.split("/");
		String rep_output = "";
		
		for(int i=0 ; i<tab.length-1;i++){
			rep_output = rep_output+tab[i]+"/";
		}
		rep_output = rep_output+"libGO";
		
		try {
			
			URL path = MainSprint2.class.getResource("/libWH.go");
			new File(rep_output).mkdirs();
			FileUtils.copyURLToFile(path,new File(rep_output+"/libWH.go"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		//Execution commande build
		try { 
			Runtime r = Runtime.getRuntime();
			Process p = r.exec("go build -o "+prog+" "+prog+".go"); 
 
			String s =null; 
 
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream())); 
 
			StringBuffer buffer = new StringBuffer();
 
			while ((s = reader.readLine()) != null) { 
				 buffer.append(s);
			} 
 
			String result = buffer.toString();
			
			System.out.println(result);
 
		}catch(Exception e) { 
				System.out.println("Erreur d'execution de la compilation :\n"+ e.getMessage()); 
		}


		if(!file_go){
			new File(prog+".go").delete();
			try {
				FileUtils.deleteDirectory(new File(rep_output));
			} catch (IOException e) {
				e.printStackTrace();
			}
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
				System.out.println("\nUne erreur est survenue : "+e.getMessage()+"\n");
			}

		}
		System.out.println("---------------FIN TEST---------------");
		
		return 0;

	}
	
	public static void printMan(){
		BufferedReader fent;
		try {
			
			InputStream is =Main.class.getClassLoader().getResourceAsStream("README_COMP.md");
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
}
