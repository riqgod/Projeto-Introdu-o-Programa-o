package excecoes;

@SuppressWarnings("serial")
public class FNEException extends Exception {

	public FNEException() {
		super("Funcionario n�o existe.");
	}
}
