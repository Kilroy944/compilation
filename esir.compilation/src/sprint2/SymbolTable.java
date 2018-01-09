package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SymbolTable {

	private HashMap<String, FunctionRepresentation> listFunctions;
	
	private HashMap<String, Integer> listSymbol;
	
	private int counterFunction = 0;
	private int counterSymbol = 0;

	public SymbolTable(){
		listFunctions=new HashMap<>();
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

	public void addSymbol(String name) throws DoubleFunctionException{
		if(!listSymbol.containsKey(name)){
			listSymbol.put(name, counterSymbol);
			counterSymbol++;
		}
		else{
			throw new DoubleFunctionException(name);
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
	
	public int getSymbol(String name) {
		return listSymbol.get(name);
	}
	
	
	public String toString(){
				
		String result="";
		
		for (Entry<String, FunctionRepresentation> entry : listFunctions.entrySet())
		{
			result+=entry.toString();
		}
		return result;
	}
}