package dados;

import base.Jogos;
import excecoes.JNEException;
import excecoes.RepositorioException;

public class RepositorioJogosArray implements RepositorioJogos {

	private Jogos[] jogos;
	private int indice;
	private int tamanho;

	public RepositorioJogosArray(int tam) {
		jogos = new Jogos[tam];
		indice = 0;
		tamanho = tam;
	}

	public void inserirJogos(Jogos jogo) throws RepositorioException {
		if (indice < tamanho) {
			this.jogos[indice] = jogo;
			indice = indice + 1;
		} else {
			throw new RepositorioException();
		}
	}

	private int getIndiceJogos(String nome) {
		String n;
		boolean achou = false;
		int i = 0;
		while ((!achou) && (i < this.indice)) {
			n = jogos[i].getNome();
			if (n.equals(nome)) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

	public Jogos procurarJogos(String nome) throws JNEException {
		Jogos resposta = null;
		int i = this.getIndiceJogos(nome);
		if (i == this.indice) {
			throw new JNEException();
		} else {
			resposta = this.jogos[i];
		}
		return resposta;
	}

	public void removerJogos(Jogos jogo) throws JNEException {
		int i = this.getIndiceJogos(jogo.getNome());
		if (i == this.indice) {
			throw new JNEException();
		} else {
			this.indice = this.indice - 1;
			this.jogos[i] = this.jogos[this.indice];
			this.jogos[this.indice] = null;
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

	public boolean existeJogos(String nome) {
		int i = this.getIndiceJogos(nome);
		return (i != this.indice);
	}

}
