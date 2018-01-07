package sprint2;

public class DoubleFunctionException extends RuntimeException{
	
	public DoubleFunctionException(String nomFonction) {
		super("Une fonction identique "+nomFonction+" existe déjà");
    }
	
	
}
