package sprint2.operations;

import java.util.ArrayList;
import java.util.List;

import sprint2.Code3Address;
import sprint2.FunctionRepresentation;

public class IF extends Operation{

	private List<Code3Address> listCodeCondition;
	private List<Code3Address> listCodeThen;
	private List<Code3Address> listCodeElse;


	public IF() {
		super("IF");

		this.listCodeCondition=new ArrayList<>();
		this.listCodeElse=new ArrayList<>();
		this.listCodeThen=new ArrayList<>();

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

		String ret = "IF \n";

		ret += ind + "\t(cond)\n";
		for (Code3Address c : listCodeCondition) {
			ret += c.toString(indent + 1) + "\n";
		}
		ret += ind + "\t(then)\n";
		for (Code3Address c : listCodeThen) {
			ret += c.toString(indent + 1) + "\n";
		}
		ret += ind + "\t(else)\n";
		for (Code3Address c : listCodeElse) {
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


	public List<Code3Address> getListCodeThen() {
		return listCodeThen;
	}


	public void setListCodeThen(List<Code3Address> listCodeThen) {
		this.listCodeThen = listCodeThen;
	}


	public List<Code3Address> getListCodeElse() {
		return listCodeElse;
	}


	public void setListCodeElse(List<Code3Address> listCodeElse) {
		this.listCodeElse = listCodeElse;
	}

	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3) {
		String result="";

		for (Code3Address code3Address : listCodeCondition) {
			result += code3Address.printCodeGo(fr);
		}
		result+="if isTrue("+arg2+"){\n";

		for (Code3Address code3Address : listCodeThen) {
			result += code3Address.printCodeGo(fr);
		}

		result+="\n}\n";

		if (listCodeElse.size() != 0){
			result+="else{\n";
			
			for (Code3Address code3Address : listCodeElse) {
				result += code3Address.printCodeGo(fr);
			}
			result+="\n}\n";
		}

		return result;
	}






}
