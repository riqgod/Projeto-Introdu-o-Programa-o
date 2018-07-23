package excecoes;

public class ProdutoJaExisteException extends Exception
{
	public ProdutoJaExisteException()
	{
		super("O produto ja foi cadastrado");
	}
}
