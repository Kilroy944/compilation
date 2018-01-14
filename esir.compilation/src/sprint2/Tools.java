package sprint2;

public class Tools {

	
	public static String convertVar(String v){
		if(v.charAt(1)=='t'){//Variable temporaire
			return "vt["+v.substring(2)+"]";
		}
		else{
			return v;
		}
	}
	
}
