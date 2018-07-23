package excecoes;

public class RepositorioException extends Exception {
	public RepositorioException() {
		super("Repositório Lotado");
	}

}
