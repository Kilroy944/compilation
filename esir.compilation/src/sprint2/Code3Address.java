package sprint2;

public class Code3Address {

	private Op operator;
	private String argr1;
	private String argr2;
	private String response;
	
	public Code3Address(Op operator, String argr1, String argr2, String reponse) {
		super();
		this.operator = operator;
		this.argr1 = argr1;
		this.argr2 = argr2;
		this.response = reponse;
	}

	@Override
	public String toString() {
		return "<operator=" + operator + ", argr1=" + argr1 + ", argr2=" + argr2 + ", response=" + response
				+ ">";
	}
}
