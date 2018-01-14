package sprint2.operations;

import sprint2.FunctionRepresentation;

public class NOP extends Operation{

	public NOP() {
		super("nop");
	}

	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3) {
		return "";
	}
	
}
