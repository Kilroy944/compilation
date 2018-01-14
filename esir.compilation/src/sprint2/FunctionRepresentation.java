package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import sprint2.operations.READ;
import sprint2.operations.WRITE;

public class FunctionRepresentation {

	private String name;
	private int counterVar = 0;
	private int counterTempVar = 0;

	private int nbInput,nbOutput;
	
	private HashMap<String, Integer> variableTable;
	
	private ArrayList<Code3Address> code;
	
	public FunctionRepresentation(String name,int nbInput,int nbOutput){
		variableTable=new HashMap<>();
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
	
	public String getNewTempVar() {
		return "vt" + counterTempVar++;
	}
	
	public int getNbInput() {
		return nbInput;
	}

	public int getNbOutput() {
		return nbOutput;
	}
	
	
	
	@Override
	public String toString(){
	
		String result="["+name+", nbIn : "+nbInput+", nbOut : "+nbOutput+"]\n";
		
		result+="Table des variables : \n";
		for (Entry<String, Integer> entry : variableTable.entrySet()){
			result+=entry+"\n";
		}
		result += "Nombre de variables temporaires : " + counterTempVar + "\n";
		
		result += "Liste de codes 3@ : \n";
			
		for (Code3Address c : code)
		{
			result+=c.toString();
		    result+=System.getProperty("line.separator");
		}
		
		result+=System.getProperty("line.separator");
		return result;
	}

	
	public String printCodeGo(){
		
		String result = "\nfunc "+name+ "(";
		
		//Param In
		
		while(!code.isEmpty() && code.get(0).getOperation() instanceof READ){
			result+=code.get(0).getArg1();
			result+=", ";
			code.remove(0);

		}
		result=result.substring(0, result.length()-2); 
		result +=" *Tree)";
		
		//Param Out
		
		int index = (code.size())-1;
		
		result+=" (";
		
		while(!code.isEmpty() && code.get(index).getOperation() instanceof WRITE){
			result+=code.get(index).getArg1();
			result+=", ";
			code.remove(index);
			index=code.size()-1;
		}
		result=result.substring(0, result.length()-2); 
		result +=" *Tree)";
		
		result+="{\n";
		
		//Allocation var temporaires
		if(counterTempVar!=0){
			result +="var vt["+counterTempVar+"] *Tree\n";
		}
		
		//Parcours des autres codes 3@
		for (Code3Address c : code)
		{
			result+=c.printCodeGo();
		    result+=System.getProperty("line.separator");
		}
		
		
		return result+="\n\treturn \n}\n";
	}
}
