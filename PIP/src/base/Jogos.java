package base;

public class Jogos {
	private String nome;
	private String descricao;
	private String plataforma;
	private int numeroJogadores;
	private int quantidade;
	private double preco;

	public Jogos(String nome, String descricao, String plataforma, int numeroJogadores, int quantidade, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.plataforma = plataforma;
		this.numeroJogadores = numeroJogadores;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getNumeroJogadores() {
		return numeroJogadores;
	}

	public void setNumeroJogadores(int numeroJogadores) {
		this.numeroJogadores = numeroJogadores;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}