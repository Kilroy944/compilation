package sprint2.operations;

import sprint2.FunctionRepresentation;

public class HD extends Operation{

	public HD() {
		super("HD");
	}

	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3) {
		return arg1+"= libWH.Hd("+arg2+")\n";
	}

}
