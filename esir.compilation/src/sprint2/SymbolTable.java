package sprint2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class SymbolTable {

	private LinkedHashMap<String, FunctionRepresentation> listFunctions;

	private HashMap<String, Integer> listSymbol;

	private int counterFunction = 0;
	private int counterSymbol = 0;
	private String lastFunction = "";
	
	
	public SymbolTable(){
		listFunctions=new LinkedHashMap<>();
		listSymbol=new HashMap<>();
		addSymbol("nil");
	}

	public void addFunction(String name,int nbInput,int nbOutput) throws DoubleFunctionException{

		if(!listFunctions.containsKey(name)){
			listFunctions.put(name, new FunctionRepresentation("f"+counterFunction,nbInput,nbOutput));
			counterFunction++;
			lastFunction = name;
		}
		else{
			throw new DoubleFunctionException(name);
		}
	}

	public String addSymbol(String name) throws DoubleFunctionException{
		if(!listSymbol.containsKey(name)){
			listSymbol.put(name, counterSymbol);
			return "s" + counterSymbol++;
		}
		else{
			return "s"+listSymbol.get(name);
		}
	}

	public FunctionRepresentation getFunction(String name) {
		return listFunctions.get(name);
	}

	public boolean hasFunction(String name){
		return listFunctions.containsKey(name);
	}

	public boolean hasSymbol(String name){
		return listSymbol.containsKey(name);
	}

	public String getSymbol(String name) {
		return "s"+listSymbol.get(name);
	}


	public void writeFile3Add(File output) throws IOException{
		FileWriter outFile = new FileWriter(output);
		BufferedWriter writer = new BufferedWriter(outFile);

		writer.write(toString());
		writer.close();
	}

	public void writeFileGo(File output) throws IOException{
		FileWriter outFile = new FileWriter(output);
		BufferedWriter writer = new BufferedWriter(outFile);

		writer.write(printCodeGo());
		writer.close();
	}



	@Override
	public String toString(){

		String result="";

		result+="Table des symboles : \n";
		for (Entry<String, Integer> entry : listSymbol.entrySet()){
			result+=entry+"\n";
		}

		for (Entry<String, FunctionRepresentation> entry : listFunctions.entrySet())
		{
			result+=entry.toString();
		}
		
		return result;
	}

	public String printCodeGo(){

		String result = "package main\n";
		
		result+= "import (libWH \"./libGO\"\n\t\"fmt\"\n\t\"os\"\n\t \"strconv\"\n)\n";

		//Allocation symbole
		for(int i=0;i<listSymbol.size();i++){
			result +="var s"+i+" *libWH.Tree\n";
		}
		
		FunctionRepresentation fr = listFunctions.get(lastFunction);

		result+="\nfunc main(){\n";

		result+="\nnbOut := "+fr.getNbInput()+"\n"
				+"if (len(os.Args)-1)>=nbOut {\n";
		
		//Ajout arg
		for(int i=1;i<fr.getNbInput()+1;i++){
			result+="\ti"+i+", err"+i+" := strconv.Atoi(os.Args["+i+"])\n";
		}
		result+="\n\tif ";
		
		for(int i=1;i<fr.getNbInput()+1;i++){
			result+="err"+i+" == nil && ";
		}
		if(fr.getNbInput()!=0){
			result=result.substring(0,result.length()-3);
		}
		result+="{\n\t\t";
		
		if(fr.getNbOutput()!=0){
			//Ajout var result
			for(int i=0;i<fr.getNbOutput();i++){
				result+="v"+i+",";
			}
			result=result.substring(0,result.length()-1);
			result+=":=";
		}
		
		result+=fr.getName()+"(";
		//Ajout arg
		for(int i=1;i<fr.getNbInput()+1;i++){
			result+="libWH.NumberToTree(i"+i+"),";
		}
		if(fr.getNbInput()!=0){
			result=result.substring(0,result.length()-1);
		}
		result+=")\n";
		
		
				
		for(int i=0;i<fr.getNbOutput();i++){
			result+="\t\tfmt.Println(libWH.TreeToNumber(v"+i+"))\n";
		}
		result+="\t}else{\n\t\tfmt.Println(\"L'un des arguments n'est pas un nombre\")\n\t}\n";
		result+="}else{\n\tfmt.Println(\"Nombre d'arguments incorrect\") \n}\n";
		result+="}\n";
		
		for (Entry<String, FunctionRepresentation> entry : listFunctions.entrySet())
		{	
			result+=entry.getValue().printCodeGo();
		}

		return result;
	}

}