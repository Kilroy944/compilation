package sprint2.operations;

import java.util.ArrayList;
import java.util.List;

import sprint2.Code3Address;

public class IF extends Operation{

	private List<Code3Address> listCodeCondition;
	private List<Code3Address> listCodeThen;
	private List<Code3Address> listCodeElse;

	
	public IF() {
		super("IF");

		this.listCodeCondition=new ArrayList<>();
		this.listCodeElse=new ArrayList<>();
		this.listCodeThen=new ArrayList<>();
	    
	}

	@Override
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

	public List<Code3Address> getListCodeCondition() {
		return listCodeCondition;
	}


	public void setListCodeCondition(List<Code3Address> listCodeCondition) {
		this.listCodeCondition = listCodeCondition;
	}


	public List<Code3Address> getListCodeThen() {
		return listCodeThen;
	}


	public void setListCodeThen(List<Code3Address> listCodeThen) {
		this.listCodeThen = listCodeThen;
	}


	public List<Code3Address> getListCodeElse() {
		return listCodeElse;
	}


	public void setListCodeElse(List<Code3Address> listCodeElse) {
		this.listCodeElse = listCodeElse;
	}

	
	
	
}
