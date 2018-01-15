package sprint2.operations;

import java.util.ArrayList;
import java.util.List;

import sprint2.Code3Address;
import sprint2.FunctionRepresentation;
import sprint2.MainSprint2;

public class CALL extends Operation{

	private List<String> listVarCall;
	private List<String> listVarReturn;

	private List<Code3Address> listCode;

	
	public CALL() {
		super("CALL");
		listVarCall= new ArrayList<>();
		listVarReturn= new ArrayList<>();
		listCode= new ArrayList<>();

	}


	public List<String> getListVarCall() {
		return listVarCall;
	}


	public void setListVarCall(List<String> listVarCall) {
		this.listVarCall = listVarCall;
	}


	public List<String> getListVarReturn() {
		return listVarReturn;
	}


	public void setListVarReturn(List<String> listVarReturn) {
		this.listVarReturn = listVarReturn;
	}


	public List<Code3Address> getListCode() {
		return listCode;
	}


	public void setListCode(List<Code3Address> listCode) {
		this.listCode = listCode;
	}

	@Override
	public String toString(){
		return toString(0);
	}

	@Override
	public String toString(int indent) {
		String ind = "";
		for (int i = 0; i < indent; i++)
			ind += "\t";

		String ret = "CALL \n";

		ret += ind + "\t(code param)\n";
		for (Code3Address c : listCode) {
			ret += c.toString(indent + 1) + "\n";
		}
		ret += ind + "\t(var call)\n";
		for (String v : listVarCall) {
			ret += ind + "\t"+v + "\n";
		}
		ret += ind + "\t(var return)\n";
		for (String v : listVarReturn) {
			ret += ind + "\t"+v + "\n";
		}

		return ret + ind;
	}


	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3,int indent) {
		String result="";
		
		String ind = "";
		for (int i = 0; i < indent; i++)
			ind += MainSprint2.Indent;
		
		for(String v : listVarReturn){
			result+=v+",";
		}
		result=result.substring(0,result.length()-1);
		
		result+="="+arg2+"(";
		for(String v : listVarCall){
			result+=v+",";
		}
		result=result.substring(0,result.length()-1);
		
		result+=")\n";
		
		return ind+result;
	}

}
