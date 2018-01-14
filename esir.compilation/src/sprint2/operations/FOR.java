package sprint2.operations;

import java.util.ArrayList;
import java.util.List;

import sprint2.Code3Address;
import sprint2.FunctionRepresentation;

public class FOR extends Operation{

	private List<Code3Address> listCodeCondition;
	private List<Code3Address> listCodeDo;
	
	
	public FOR() {
		super("FOR");

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

		String ret = "FOR \n";

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

		String var = arg2;
		if(arg2.charAt(1)=='t'){//Variable temporaire
			var = "vt["+arg2.substring(2)+"]";
		}
		
		String result="";
		
		for (Code3Address c : listCodeCondition)
		{
			result+=c.printCodeGo(fr);
			result+=System.getProperty("line.separator");
		}
		
		result += "var e = treeToNumber("+var+") \nfor i:=0;i<e;i++ {\n  ";
		
		//Parcours des autres codes 3@
		for (Code3Address c : listCodeDo)
		{
			result+=c.printCodeGo(fr);
			result+=System.getProperty("line.separator");
		}
		
		return result+"}";
	}

}
