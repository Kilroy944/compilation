package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class FunctionRepresentation {

	private String name;
	private int counterVar = 0;
	private int counterTempVar = 0;

	private int nbInput,nbOutput;
	
	private HashMap<String, Integer> variableTable;
	private HashMap<String, Integer> tempVariableTable;
	
	private ArrayList<Code3Address> code;
	
	public FunctionRepresentation(String name,int nbInput,int nbOutput){
		variableTable=new HashMap<>();
		tempVariableTable=new HashMap<>();
		code = new ArrayList<Code3Address>();
		
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
	
	public ArrayList<Code3Address> getCode(){
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
			
		for (Code3Address c : code)
		{
			result+=c.toString();
		    result+=System.getProperty("line.separator");
		}
		
		result+=System.getProperty("line.separator");
		return result;
	}

	public String addVar(String v) {
		
		if(!variableTable.containsKey(v)){
			variableTable.put(v, counterVar);
			counterVar++;	
			return "v"+(counterVar-1);
		}
		else{
			return "v"+variableTable.get(v);	
		}
	}

	public void addCode3Address(Code3Address c){
		code.add(c);
	}
	
	public String addTempVar(String v) {
		
		if(!tempVariableTable.containsKey(v)){
			tempVariableTable.put(v, counterTempVar);
			counterTempVar++;	
		}
		return "vt"+(counterTempVar-1);
			
	}
	
	public int getNbInput() {
		return nbInput;
	}

	public int getNbOutput() {
		return nbOutput;
	}
	
}
