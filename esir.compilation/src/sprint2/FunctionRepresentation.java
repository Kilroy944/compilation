package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

		int nbVarRead = 0; 		

		String result = "\nfunc "+name+ "(";

		//Param In

		while(!code.isEmpty() && code.get(0).getOperation() instanceof READ){
			result+=code.get(0).getArg1();
			result+=", ";
			code.remove(0);
			nbVarRead++;

		}
		result=result.substring(0, result.length()-2); 
		result +=" *libWH.Tree) ";

		//Param Out

		int index = (code.size())-1;

		result+="(";

		String out="";
		while(!code.isEmpty() && code.get(index).getOperation() instanceof WRITE){
			out=code.get(index).getArg1()+","+out;
			code.remove(index);
			index=code.size()-1;
			result+="*libWH.Tree, ";
		}
		out=out.substring(0, out.length()-1); 

		result=result.substring(0, result.length()-2); 
		result+=") {\n\n";
		
		//Allocation var
		for(int i=nbVarRead;i<variableTable.size();i++){
			result +="var v"+i+" *libWH.Tree = &(libWH.Tree{\"nil\",&(libWH.Tree{\"nil\",nil,nil}),&(libWH.Tree{\"nil\",nil,nil})})\n";
			result +="_ = v"+i+"\n";
		}


		//Allocation var temporaires
		for(int i=0;i<counterTempVar;i++){
			result +="var vt"+i+" *libWH.Tree = &(libWH.Tree{\"nil\",&(libWH.Tree{\"nil\",nil,nil}),&(libWH.Tree{\"nil\",nil,nil})})\n";
			result +="_ = vt"+i+"\n";
		}
		result+="\n";


		//Parcours des autres codes 3@
		for (Code3Address c : code)
		{
			result+=c.printCodeGo(this,0);
			result+=System.getProperty("line.separator");
		}


		return result+="\nreturn "+out+" \n}\n";
	}
}
