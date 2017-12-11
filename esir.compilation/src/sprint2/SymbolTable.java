package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SymbolTable {

	//Voir : https://en.wikipedia.org/wiki/Three-address_code
	
	//Une étiquette par fonction/commande avec une liste de code3@ associée
	private HashMap<String, ArrayList<Code3Address>> table;
	private int uniqueTagId = 0;

	
	public SymbolTable(){
		table=new HashMap<>();
	}
	
	/**
	 * Ajout d'une étiquette
	 * @param tag
	 */
	public String addTag(String tag){
		
		String newTag = tag+uniqueTagId;
		table.put(newTag, new ArrayList<Code3Address>());
		uniqueTagId++;
		return newTag;
	}
	
	/**
	 * Ajout d'une opération à la l'étiquette
	 * @param tag
	 * @param code
	 */
	public void addOp(String tag, Code3Address code){
		table.get(tag).add(code);
	}
	
	public String toString(){
		
		StringBuilder result = new StringBuilder();
		
		for (Entry<String, ArrayList<Code3Address>> entry : table.entrySet())
		{
			result.append(entry.getKey()+" : ");
		    for(Code3Address code : entry.getValue()){
		    	result.append("\t"+code.toString());
			    result.append(System.getProperty("line.separator"));

		    }
		}
		return result.toString();
	}
	
	
}
