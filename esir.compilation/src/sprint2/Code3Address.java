package sprint2;

import sprint2.operations.Operation;

public class Code3Address {

	private Operation operator;
	private String argr1;
	private String argr2;
	private String argr3;
	
	public Code3Address(Operation operator, String argr1, String argr2, String argr3) {
		super();
		this.operator = operator;
		this.argr1 = argr1;
		this.argr2 = argr2;
		this.argr3 = argr3;
	}

	@Override
	public String toString() {
		return toString(0);
	}
	
	public String toString(int indent) {
		String ind = "";
		for (int i = 0; i < indent; i++)
			ind += "\t";

		return ind + "<" + operator.toString(indent) + ", " + argr1 + ", " + argr2 + ", " + argr3
				+ ">";
	}
	
	
	
}
