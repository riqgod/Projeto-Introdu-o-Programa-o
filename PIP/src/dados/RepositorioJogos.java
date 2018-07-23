package dados;

import base.Jogos;
import excecoes.JIException;
import excecoes.JNEException;
import excecoes.RepositorioException;

public interface RepositorioJogos {
	
	public void inserirJogos(Jogos jogo) throws RepositorioException;

	public void atualizarJogos(Jogos jogoAntigo, Jogos jogoAtualizado) throws JNEException;

	public void removerJogos(Jogos jogo) throws JNEException;

	public Jogos procurarJogos(String nome) throws JNEException;

	public boolean existeJogos(String nome);

}