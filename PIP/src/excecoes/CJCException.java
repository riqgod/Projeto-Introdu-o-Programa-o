package excecoes;

public class CJCException extends Exception
{
	public CJCException()
	{
		super("Cliente ja cadastrado");
	}
}
