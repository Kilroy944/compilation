package esir.compilation.generator;

@SuppressWarnings("serial")
public class ErrorPrettyPrinterException extends Exception{
	public ErrorPrettyPrinterException(String message, Integer line, Integer character) {
		super("Erreur de pretty printing ligne " + line + " caractère " + character + " : " + message);
    }
}
