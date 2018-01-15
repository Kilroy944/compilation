package sprint2.operations;

import java.util.ArrayList;
import java.util.List;

import sprint2.Code3Address;
import sprint2.FunctionRepresentation;
import sprint2.MainSprint2;

public class EXPNOT extends Operation{

	private List<Code3Address> listCode;

	public EXPNOT() {
		super("EXPNOT");
		listCode = new ArrayList<>();

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
			ind += MainSprint2.Indent;

		String ret = "NOT \n";

		for (Code3Address c : listCode) {
			ret += c.toString(indent + 1) + "\n";
		}
		

		return ret + ind;
	}

	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3,int indent) {
		String result="";
		
		String ind = "";
		for (int i = 0; i < indent; i++)
			ind += "\t";
		
		for(Code3Address c : listCode){
			result+=ind+c.printCodeGo(fr,indent);
		}
		
		result+=ind+arg1+"=!(libWH.IsTrue("+arg2+"))\n";
		return result;
	}
}
