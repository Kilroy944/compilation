package sprint2.operations;

public abstract class Operation {

	String name;
	
	public Operation(String name){
		this.name=name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public String toString(int indent) {
		return name;
	}
	
	//public abstract String toString(int indent);
	//public abstract String toStringGo(int indent);

}
