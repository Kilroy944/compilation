package sprint2.operations;

import java.util.ArrayList;

import sprint2.Code3Address;

public class IF extends Operation{

	private ArrayList<Code3Address> listCodeCondition;
	private ArrayList<Code3Address> listCodeThen;
	private ArrayList<Code3Address> listCodeElse;

	
	public IF(String name, ArrayList<Code3Address> lc, ArrayList<Code3Address> lt, ArrayList<Code3Address> le  ) {
		super(name);

		this.listCodeCondition=lc;
		this.listCodeElse=le;
		this.listCodeThen=lt;
	    
	}

	
	
}
