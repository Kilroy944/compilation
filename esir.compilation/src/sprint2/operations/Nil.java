package sprint2.operations;

import sprint2.FunctionRepresentation;

public class Nil extends Operation {

	public Nil() {
		super("nil");
	}

	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3) {
		return arg1+" = nil \n";
	}

}
