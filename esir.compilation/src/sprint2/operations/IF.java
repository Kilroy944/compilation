package sprint2.operations;

import java.util.ArrayList;

import sprint2.Code3Address;

public class IF extends Operation{

	private ArrayList<Code3Address> listCodeCondition;
	private ArrayList<Code3Address> listCodeThen;
	private ArrayList<Code3Address> listCodeElse;

	
	public IF() {
		super("IF");

		this.listCodeCondition=new ArrayList<>();
		this.listCodeElse=new ArrayList<>();
		this.listCodeThen=new ArrayList<>();
	    
	}

	public String toString(){
		
		String ret = "IF \n";
		
		for(Code3Address c : listCodeCondition){
			ret += "\t"+c.toString()+"\n";
		}
		for(Code3Address c : listCodeThen){
			ret += "\t"+c.toString()+"\n";
		}
		for(Code3Address c : listCodeElse){
			ret += "\t"+c.toString()+"\n";
		}
		
		return ret;
	}

	public ArrayList<Code3Address> getListCodeCondition() {
		return listCodeCondition;
	}


	public void setListCodeCondition(ArrayList<Code3Address> listCodeCondition) {
		this.listCodeCondition = listCodeCondition;
	}


	public ArrayList<Code3Address> getListCodeThen() {
		return listCodeThen;
	}


	public void setListCodeThen(ArrayList<Code3Address> listCodeThen) {
		this.listCodeThen = listCodeThen;
	}


	public ArrayList<Code3Address> getListCodeElse() {
		return listCodeElse;
	}


	public void setListCodeElse(ArrayList<Code3Address> listCodeElse) {
		this.listCodeElse = listCodeElse;
	}

	
	
	
}
