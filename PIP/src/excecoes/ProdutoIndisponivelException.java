package excecoes;

public class ProdutoIndisponivelException extends Exception
{
	public ProdutoIndisponivelException()
	{
		super("Produto Indisponivel no momento, espere a reposicao de estoque ou procure outro produto.");
	}
}
