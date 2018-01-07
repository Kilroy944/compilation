package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class FunctionRepresentation {

	private String name;
	private int counterVar = 0;

	private int nbInput,nbOutput;
	
	private HashMap<String, Integer> variableTable;
	private HashMap<String, Integer> tempVariableTable;
	
	private Code3AdressList code;
	
	public FunctionRepresentation(String name,int nbInput,int nbOutput){
		variableTable=new HashMap<>();
		tempVariableTable=new HashMap<>();
		code = new Code3AdressList();
		code.setCurrentTag("l0");
		
		this.name=name;

		this.nbInput=nbInput;
		this.nbOutput=nbOutput;
	}
	
	public void setName(String name){
		this.name=name;
	}


	public String getName() {
		return name;
	}
	
	public Code3AdressList getCode(){
		return code;
	}
	
	public String toString(){
	
		String result="["+name+", nbIn : "+nbInput+", nbOut : "+nbOutput+"]\n";
		
		result+="Table des variables : \n";
		for (Entry<String, Integer> entry : variableTable.entrySet()){
			result+=entry+"\n";
		}
		result+="Table des variables temporaires : \n";
		for (Entry<String, Integer> entry : tempVariableTable.entrySet()){
			result+=entry+"\n";
		}
		
		result+="Table des codes 3@ : \n";
		
		result+=code.toString();
		

		/*for (Entry<String, ArrayList<Code3Address>> entry : table.entrySet())
		{
			result+=entry.getKey()+" : ";
		    for(Code3Address code : entry.getValue()){
		    	result+="\t"+code.toString()+"\n";
		    }
		    result+=System.getProperty("line.separator");
		}*/
		result+=System.getProperty("line.separator");
		return result;
	}

	public void addVar(String v) {
		
		if(!variableTable.containsKey(v)){
			variableTable.put(v, counterVar);
			counterVar++;	
		}
			
	}

	public int getNbInput() {
		return nbInput;
	}

	public int getNbOutput() {
		return nbOutput;
	}
	
}
