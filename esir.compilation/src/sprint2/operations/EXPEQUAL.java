package sprint2.operations;

import java.util.ArrayList;
import java.util.List;

import sprint2.Code3Address;

public class EXPEQUAL extends Operation{
	private List<Code3Address> listCodeLeft;
	private List<Code3Address> listCodeRight;

	public EXPEQUAL() {
		super("EXPEQUAL");
		listCodeLeft = new ArrayList<>();
		listCodeRight = new ArrayList<>();

	}

	public List<Code3Address> getListCodeLeft() {
		return listCodeLeft;
	}

	public void setListCodeLeft(List<Code3Address> listCodeLeft) {
		this.listCodeLeft = listCodeLeft;
	}

	public List<Code3Address> getListCodeRight() {
		return listCodeRight;
	}

	public void setListCodeRight(List<Code3Address> listCodeRight) {
		this.listCodeRight = listCodeRight;
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

		String ret = "EQUAL \n";

		ret += ind + "\t(gauche)\n";
		for (Code3Address c : listCodeLeft) {
			ret += c.toString(indent + 1) + "\n";
		}
		ret += ind + "\t(droite)\n";
		for (Code3Address c : listCodeRight) {
			ret += c.toString(indent + 1) + "\n";
		}

		return ret + ind;
	}
}
