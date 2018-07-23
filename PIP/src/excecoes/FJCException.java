package excecoes;

@SuppressWarnings("serial")
public class FJCException extends Exception {

	public FJCException() {
		super ("Funcionario já cadastrado.");
	}
}
