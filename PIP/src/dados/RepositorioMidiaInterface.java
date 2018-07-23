package dados;

import base.Midia;
import excecoes.ArrayCheioException;
import excecoes.AtualizacaoIncompativelException;
import excecoes.ProdutoInexistenteException;

public interface RepositorioMidiaInterface 
{
	void inserirMidia(Midia midia) throws ArrayCheioException;
	boolean existeMidia(String nome);
	void atualizarMidia(Midia midiaAntiga, Midia midiaNova) throws ProdutoInexistenteException, AtualizacaoIncompativelException;
	Midia procurarMidia (String nome) throws ProdutoInexistenteException;
	void removerMidia(Midia midia) throws ProdutoInexistenteException;
}
