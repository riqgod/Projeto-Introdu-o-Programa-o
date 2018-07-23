package excecoes;

public class ArrayCheioException extends Exception
{
	public ArrayCheioException()
	{
		super("Array lotado, remova um produto antes de tentar adicionar outro.");
	}
}
