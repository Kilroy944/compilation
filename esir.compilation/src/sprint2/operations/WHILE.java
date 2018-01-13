package sprint2.operations;

import java.util.ArrayList;
import java.util.List;

import sprint2.Code3Address;
import sprint2.FunctionRepresentation;

public class WHILE extends Operation{

	private List<Code3Address> listCodeCondition;
	private List<Code3Address> listCodeDo;
	
	
	public WHILE() {
		super("WHILE");

		this.listCodeCondition=new ArrayList<>();
		this.listCodeDo=new ArrayList<>();
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

		String ret = "WHILE \n";

		ret += ind + "\t(cond)\n";
		for (Code3Address c : listCodeCondition) {
			ret += c.toString(indent + 1) + "\n";
		}
		ret += ind + "\t(do)\n";
		for (Code3Address c : listCodeDo) {
			ret += c.toString(indent + 1) + "\n";
		}

		return ret + ind;
	}


	public List<Code3Address> getListCodeCondition() {
		return listCodeCondition;
	}


	public void setListCodeCondition(List<Code3Address> listCodeCondition) {
		this.listCodeCondition = listCodeCondition;
	}


	public List<Code3Address> getListCodeDo() {
		return listCodeDo;
	}


	public void setListCodeDo(List<Code3Address> listCodeDo) {
		this.listCodeDo = listCodeDo;
	}

	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
