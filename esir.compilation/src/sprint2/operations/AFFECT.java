package sprint2.operations;

import java.util.ArrayList;
import java.util.List;

import sprint2.Code3Address;
import sprint2.FunctionRepresentation;
import sprint2.MainSprint2;

public class AFFECT extends Operation{

	private List<Code3Address> listCodeExp;
	
	public AFFECT() {
		super("AFFECT");
		listCodeExp = new ArrayList<>();
	}

	public List<Code3Address> getListCodeExp() {
		return listCodeExp;
	}

	public void setListCodeExp(List<Code3Address> listCodeExp) {
		this.listCodeExp = listCodeExp;
	}

	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3,int indent) {
		String ind = "";
		for (int i = 0; i < indent; i++)
			ind += MainSprint2.Indent;
		return ind+arg1+" = "+arg2+"\n";
	}
}
