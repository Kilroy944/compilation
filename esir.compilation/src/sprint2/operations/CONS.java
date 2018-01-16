package sprint2.operations;

import sprint2.FunctionRepresentation;
import sprint2.MainSprint2;

public class CONS extends Operation{

	public CONS() {
		super("cons");
	}

	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3,int indent) {
		String ind = "";
		for (int i = 0; i < indent; i++)
			ind += MainSprint2.Indent;
		return ind+"*"+arg1+" = *libWH.Cons("+arg2+","+arg3+")\n";
	}

}
