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

	public SymbolTable(){
		listFunctions=new LinkedHashMap<>();
		listSymbol=new HashMap<>();
		addSymbol("nil");
	}
	
	public void addFunction(String name,int nbInput,int nbOutput) throws DoubleFunctionException{
		
		if(!listFunctions.containsKey(name)){
			listFunctions.put(name, new FunctionRepresentation("f"+counterFunction,nbInput,nbOutput));
			counterFunction++;
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
	
	
	public void writeFile(File output) throws IOException{
		FileWriter outFile = new FileWriter(output);
		BufferedWriter writer = new BufferedWriter(outFile);
		
		String result="";
		
		result+="Table des symboles : \n";
		for (Entry<String, Integer> entry : listSymbol.entrySet()){
			result+=entry+"\n";
		}
		
		for (Entry<String, FunctionRepresentation> entry : listFunctions.entrySet())
		{
			result+=entry.toString();
		}
		
		writer.write(result);
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
		
		result+=printCodeGo();
		
		return result;
	}
	
	public String printCodeGo(){
		
		String result = "package main\n";
		
		result+="\ntype Tree struct {\nLeft  *Tree \nRight *Tree \n}\n";
		
		
		
		//Allocation symbole
		for(int i=0;i<listSymbol.size();i++){
			result +="var s"+i+" *Tree\n";
		}
		
		result+="\nfunc main(){\n";
		
		boolean first = true;
		
		for (Entry<String, FunctionRepresentation> entry : listFunctions.entrySet())
		{
			if(first){
				int nbIn = entry.getValue().getNbInput();
				result+="\t"+entry.getValue().getName()+"(";
					boolean firstIn =true;
					for(int i=0;i<nbIn;i++){
						
						if(firstIn){
							result+="nil";
							firstIn=false;
						}
						else{
							result+=",nil";
						}
						
					}
				result+=")";
				result+=" \n}\n";
				result+=entry.getValue().printCodeGo();
				first=false;
			}
			else{
				result+=entry.getValue().printCodeGo();
			}
		}
		
		
		return result;
	}
	
}