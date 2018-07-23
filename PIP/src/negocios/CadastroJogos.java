package negocios;

import base.Jogos;
import excecoes.JCException;
import excecoes.JNEException;
import excecoes.RepositorioException;
import dados.RepositorioJogos;

public class CadastroJogos {

	private RepositorioJogos jogos;

	public CadastroJogos(RepositorioJogos repositorio) {
		jogos = repositorio;
	}

	public void cadastrarJogos(Jogos jogo) throws RepositorioException, JCException{
		if(!jogos.existeJogos(jogo.getNome())){
			jogos.inserirJogos(jogo);
		} else {
			throw new JCException();
		}
	}
	
	public void removerCadastroJogos (Jogos jogo) throws JNEException {
		if(!jogos.existeJogos(jogo.getNome())) {
			jogos.removerJogos(jogo);
		} else {
			throw new JNEException();
		}
	}

}
