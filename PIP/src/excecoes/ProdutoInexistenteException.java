package excecoes;

public class ProdutoInexistenteException extends Exception
{
	public ProdutoInexistenteException()
	{
		super("O produto que voce procura nao existe no sistema da loja, tente procurar outro produto.");
	}
}
