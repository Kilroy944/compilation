package sprint2;

import sprint2.operations.Operation;

public class Code3Address {

	private Operation operator;
	private String arg1;
	private String arg2;
	private String arg3;
	
	public Code3Address(Operation operator, String argr1, String argr2, String argr3) {
		super();
		this.operator = operator;
		this.arg1 = argr1;
		this.arg2 = argr2;
		this.arg3 = argr3;
	}

	@Override
	public String toString() {
		return toString(0);
	}

	public String toString(int indent) {
		String ind = "";
		for (int i = 0; i < indent; i++)
			ind += "\t";

		return ind + "<" + operator.toString(indent) + ", " + arg1 + ", " + arg2 + ", " + arg3
				+ ">";
	}

	public String printCodeGo(FunctionRepresentation fr){
		return operator.printCodeGo(fr, arg1, arg2, arg3);
	}
	
	public Operation getOperation(){
		return operator;
	}

	public String getArg1() {
		return arg1;
	}

	public String getArg2() {
		return arg2;
	}

	public String getArg3() {
		return arg3;
	}
	
	
}
