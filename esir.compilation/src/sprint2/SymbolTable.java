package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SymbolTable {

	
	//Voir : https://en.wikipedia.org/wiki/Three-address_code
	
	private HashMap<String, FunctionRepresentation> listFunctions;
	private int counterFunction = 0;
	
	public SymbolTable(){
		listFunctions=new HashMap<>();
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

	public FunctionRepresentation getFunction(String name) {
		return listFunctions.get(name);
	}
	
	public boolean hasFunction(String name){
		return listFunctions.containsKey(name);
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