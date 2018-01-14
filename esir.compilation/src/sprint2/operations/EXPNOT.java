package sprint2.operations;

import java.util.ArrayList;
import java.util.List;

import sprint2.Code3Address;
import sprint2.FunctionRepresentation;

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
			ind += "\t";

		String ret = "NOT \n";

		for (Code3Address c : listCode) {
			ret += c.toString(indent + 1) + "\n";
		}
		

		return ret + ind;
	}

	@Override
	public String printCodeGo() {
		// TODO Auto-generated method stub
		return null;
	}


}
