package excecoes;

public class AtualizacaoIncompativelException extends Exception
{	
	public AtualizacaoIncompativelException()
	{
		super("Voce tentou atualizar o produto com um tipo diferente do dele");
	}
}
