package negocios;

import base.Jogos;
import excecoes.JCException;
import excecoes.JNEException;
import excecoes.RepositorioException;
import dados.RepositorioJogos;
import dados.RepositorioJogosArray;
import dados.RepositorioJogosLista;
import excecoes.TRIException;
import excecoes.PQNException;

public class RepsJogos {
	public static final String tipoArray = "ARRAY";
	public static final String tipoLista = "LISTA";
	
	private static RepositorioJogos rep;
	
	public RepsJogos(String tipoRepositorio) throws TRIException{
		if(tipoRepositorio.equals(tipoArray)){
			this.rep = (RepositorioJogos) new RepositorioJogosArray(3);
		}else if(tipoRepositorio.equals(tipoLista)){
			this.rep = (RepositorioJogos) new RepositorioJogosLista();
		}else{
			TRIException e;
			e = new TRIException();
			throw e;
		}
	}
	
	public void inserirJogos(Jogos jogo) throws RepositorioException, PQNException, JCException{
		if (rep.existeJogos(jogo.getNome()) == false) {
			if(jogo.getPreco() < 0 || jogo.getQuantidade() < 0){
				PQNException e;
				e = new PQNException();
				throw e;
			}else{
				rep.inserirJogos(jogo);
			}
		} else {
			throw new JCException();
		}
	}
	
	public void removerJogos(Jogos jogo) throws JNEException{
		rep.removerJogos(jogo);
	}
	
	public Jogos procurarJogos(String nome) throws JNEException{
		return rep.procurarJogos(nome);
	}
	
	public void atualizarJogos(Jogos jogoAntigo, Jogos jogoAtualizado) throws JNEException{
		rep.atualizarJogos(jogoAntigo, jogoAtualizado);
	}
}
