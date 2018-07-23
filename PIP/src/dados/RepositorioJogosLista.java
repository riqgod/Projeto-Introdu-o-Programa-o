package dados;

import base.Jogos;
import excecoes.JIException;
import excecoes.JNEException;

public class RepositorioJogosLista implements RepositorioJogos {

	private Jogos jogo;
	private RepositorioJogosLista proximo;

	public RepositorioJogosLista() {
		this.jogo = null;
		this.proximo = null;
	}

	public Jogos getJogo() {
		return jogo;
	}

	public void setJogo(Jogos jogo) {
		this.jogo = jogo;
	}

	public RepositorioJogosLista getProximo() {
		return proximo;
	}

	public void setProximo(RepositorioJogosLista proximo) {
		this.proximo = proximo;
	}

	public void inserirJogos(Jogos jogo) {
		if (this.jogo == null) {
			this.jogo = jogo;
			this.proximo = new RepositorioJogosLista();
		} else {
			this.proximo.inserirJogos(jogo);
		}
	}

	public void removerJogos(Jogos jogo) throws JNEException {
		if (this.jogo != null) {
			if (this.jogo.equals(jogo)) {
				if (this.proximo == null) {
					this.jogo = null;
				} else if (this.proximo.proximo == null) {
					this.jogo = this.proximo.jogo;
					this.proximo = null;
				} else {
					this.jogo = this.proximo.jogo;
					this.proximo = this.proximo.proximo;
				}
			} else {
				this.proximo.removerJogos(jogo);
			}
		} else {
			throw new JNEException();
		}
	}

	public void atualizarJogos(Jogos jogoAntigo, Jogos jogoAtualizado) throws JNEException {
		jogoAntigo = procurarJogos(jogoAntigo.getNome());
		jogoAntigo.setNome(jogoAtualizado.getNome());
		jogoAntigo.setDescricao(jogoAtualizado.getDescricao());
		jogoAntigo.setPlataforma(jogoAtualizado.getPlataforma());
		jogoAntigo.setNumeroJogadores(jogoAtualizado.getNumeroJogadores());
		jogoAntigo.setQuantidade(jogoAtualizado.getQuantidade());
		jogoAntigo.setPreco(jogoAtualizado.getPreco());
	}

	public Jogos procurarJogos(String nome) throws JNEException {
		Jogos resposta = null;
		if (this.jogo != null) {
			if (this.jogo.getNome().equalsIgnoreCase(nome)) {
				resposta = this.jogo;
			} else {
				resposta = this.proximo.procurarJogos(nome);
			}
		} else {
			throw new JNEException();
		}
		return resposta;
	}

	public boolean existeJogos(String nome) {
		boolean existe = false;
		if (this.jogo != null) {
			if (this.jogo.getNome().equalsIgnoreCase(nome)) {
				return existe = true;
			} else if (this.proximo != null) {
				return existe = this.proximo.existeJogos(nome);
			} else {
				return existe = false;
			}
		} else {
			return existe = false;
		}
	}
}