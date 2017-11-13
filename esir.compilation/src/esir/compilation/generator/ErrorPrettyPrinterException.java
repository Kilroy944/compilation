package esir.compilation.generator;

@SuppressWarnings("serial")
public class ErrorPrettyPrinterException extends Exception{
	public ErrorPrettyPrinterException(String message) {
        super("Erreur de pretty printing : "+message);
    }
}
