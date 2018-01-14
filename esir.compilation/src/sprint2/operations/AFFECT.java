package sprint2.operations;

import java.util.ArrayList;
import java.util.List;

import sprint2.Code3Address;
import sprint2.FunctionRepresentation;

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
	public String printCodeGo() {
		// TODO Auto-generated method stub
		return null;
	}


}
