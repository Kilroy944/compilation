package sprint2.operations;

public abstract class Operation {

	String name;
	
	public Operation(String name){
		this.name=name;
	}
	
	public String toString(){
		return name;
	}
}
