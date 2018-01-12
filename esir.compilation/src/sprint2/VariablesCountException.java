package sprint2;

public class VariablesCountException extends RuntimeException{
	
	public VariablesCountException(int attendu, int donne) {
		super("Mauvais nombre de variables rencontré : " + attendu + " attendues, " + donne + " données");
    }
	
	
}
