package excecoes;

@SuppressWarnings("serial")
public class FNEException extends Exception {

	public FNEException() {
		super("Funcionario não existe.");
	}
}
