package sprint2;

public class Code3Address {

	private Op operator;
	private Addr argr1;
	private Addr argr2;
	private Addr result;
	
	public Code3Address(Op operator, Addr argr1, Addr argr2, Addr result) {
		super();
		this.operator = operator;
		this.argr1 = argr1;
		this.argr2 = argr2;
		this.result = result;
	}

	@Override
	public String toString() {
		return "<operator=" + operator + ", argr1=" + argr1 + ", argr2=" + argr2 + ", response=" + result
				+ ">";
	}
}
