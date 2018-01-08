package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Code3AdressList {

	public HashMap<String, ArrayList<Code3Address>> code;
	
	public int counterTag = 0;
	public String currentTag = "l0";
	
	public Code3AdressList(){
		code=new HashMap<>();
	}
	
	public void addCode3Adress(String tag,Code3Address c){
		
		if(code.containsKey(tag)){
			code.get(tag).add(c);
		}
		else{
			ArrayList<Code3Address> l =  new ArrayList<Code3Address>();
			l.add(c);
			code.put(tag,l);
		}
	}
	
	public void setCurrentTag(String currentTag) {
		this.currentTag = currentTag;
		
	}

	public String getCurrentTag() {
		return currentTag;
	}

	public String getNextTag(){
		counterTag++;
		return "l"+counterTag;
	}

	@Override
	public String toString() {
		String result = "";
		
		for (Entry<String, ArrayList<Code3Address>> entry : code.entrySet())
		{
			result+=entry.getKey()+" : ";
		    for(Code3Address code : entry.getValue()){
		    	result+="\t"+code.toString()+"\n";
		    }
		    result+=System.getProperty("line.separator");
		}
		
		return result;
	}
	
	
	
	
	
}
