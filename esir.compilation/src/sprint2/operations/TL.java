package sprint2.operations;

import sprint2.FunctionRepresentation;

public class TL extends Operation{

	public TL() {
		super("TL");
	}

	@Override
	public String printCodeGo(FunctionRepresentation fr, String arg1, String arg2, String arg3) {
		return arg1+"= libWH.Tl("+arg2+")\n";
	}

}
