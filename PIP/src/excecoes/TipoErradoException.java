package excecoes;

public class TipoErradoException extends Exception 
{
	public TipoErradoException()
	{
		super("Você esta tentando alugar um filme, mas o produto solicitado nao eh um filme");
	}
}
