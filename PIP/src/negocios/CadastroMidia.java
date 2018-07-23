package negocios;

import base.Midia;
import excecoes.ArrayCheioException;
import excecoes.ProdutoInexistenteException;
import excecoes.ProdutoJaExisteException;
import dados.RepositorioMidiaInterface;

public class CadastroMidia 
{
	private RepositorioMidiaInterface repositorio;
	
	public CadastroMidia(RepositorioMidiaInterface rep)
	{
		repositorio = rep;
	}
	
	public void cadastrarMidia(Midia midia) throws ArrayCheioException, ProdutoJaExisteException
	{
		if(repositorio.existeMidia(midia.getNome()) == false)
		{
			repositorio.inserirMidia(midia);
		}
		else
		{
			throw new ProdutoJaExisteException();
		}
	}
	
	public void remover(Midia midia) throws ProdutoInexistenteException
	{
		if(repositorio.existeMidia(midia.getNome()) == true)
		{
			repositorio.removerMidia(midia);
		}
	}
}
