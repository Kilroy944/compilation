package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class FunctionRepresentation {

	private String name;
	private int counterVar = 0;
	private int counterOp = 0;

	private int nbInput,nbOutput;

	//Une étiquette par fonction/commande avec une liste de code3@ associée
	private HashMap<String, ArrayList<Code3Address>> table;
	
	private HashMap<String, Boolean> variableTable;

	
	public FunctionRepresentation(String name,int nbInput,int nbOutput){
		table=new HashMap<>();
		variableTable=new HashMap<>();
		
		this.name=name;
		table.put(name, new ArrayList<Code3Address>());

		this.nbInput=nbInput;
		this.nbOutput=nbOutput;
	}
	
	public void setName(String name){
		this.name=name;
	}


	public String getName() {
		return name;
	}
	
	/**
	 * Ajout d'une étiquette
	 * @param tag
	 */
	public String addTag(String tag){
	
		String newTag = tag+counterOp;
		table.put(newTag, new ArrayList<Code3Address>());
		counterOp++;
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
			
		String result="["+name+", nbIn : "+nbInput+", nbOut : "+nbOutput+"]\n";
		
		result+="Table des variables : \n";
		for (Entry<String, Boolean> entry : variableTable.entrySet()){
			result+=entry+"\n";
		}
		
		result+="Table des codes 3@ : \n";

		for (Entry<String, ArrayList<Code3Address>> entry : table.entrySet())
		{
			result+=entry.getKey()+" : ";
		    for(Code3Address code : entry.getValue()){
		    	result+="\t"+code.toString()+"\n";
		    }
		    result+=System.getProperty("line.separator");
		}
	
		return result;
	}

	public void addVar(String v) {
		variableTable.put(v, false);
	}
}
