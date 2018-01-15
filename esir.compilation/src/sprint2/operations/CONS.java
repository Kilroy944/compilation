package sprint2.operations;

import sprint2.FunctionRepresentation;

public class CONS extends Operation{

	public CONS() {
		super("cons");
	}

	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3) {
		return arg1+"= libWH.Cons("+arg2+","+arg3+")\n";
	}

}
