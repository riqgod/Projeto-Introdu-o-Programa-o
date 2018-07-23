package negocios;

import base.Filme;
import base.Midia;
import base.Seriado;
import dados.RepositorioMidiaArray;
import dados.RepositorioMidiaInterface;
import dados.RepositorioMidiaLista;
import excecoes.ArrayCheioException;
import excecoes.AtualizacaoIncompativelException;
import excecoes.PQNException;
import excecoes.ProdutoIndisponivelException;
import excecoes.ProdutoInexistenteException;
import excecoes.ProdutoJaExisteException;
import excecoes.TRIException;

public class RepsMidia
{
	public static final String tipoArray = "ARRAY";
	public static final String tipoLista = "LISTA";
	
	private RepositorioMidiaInterface rep;
	
	public RepsMidia(String tipoRepositorio) throws TRIException
	{
		if(tipoRepositorio.equals(tipoArray))
		{
			this.rep = new RepositorioMidiaArray(6);
		}
		else if(tipoRepositorio.equals(tipoLista))
		{
			this.rep =  new RepositorioMidiaLista();
		}
		else
		{
			TRIException e;
			e = new TRIException();
			throw e;
		}
	}
	
	public void inserirMidia(Midia midia) throws PQNException, ArrayCheioException, ProdutoJaExisteException
	{
		if(midia.getPreco() < 0)
		{
			PQNException e;
			e = new PQNException();
			throw e;
		}
		if(rep.existeMidia(midia.getNome())== true)
		{
			throw new ProdutoJaExisteException();
		}
		else
		{
			rep.inserirMidia(midia);
		}
	}
	
	public void removerMidia(Midia midia) throws ProdutoInexistenteException
	{
		rep.removerMidia(midia);
	}
	
	public Midia procurarMidia(String nome) throws ProdutoInexistenteException
	{
		return rep.procurarMidia(nome);
	}
	
	public void atualizar(Midia midiaAntiga, Midia midiaNova) throws ProdutoInexistenteException, AtualizacaoIncompativelException{
		rep.atualizarMidia(midiaAntiga, midiaNova);
	}
}
