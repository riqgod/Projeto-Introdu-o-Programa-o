package base;

public class Filme extends Midia
{
	private int quantidadeDisponivel;
	
	public Filme(String nome, String descricao, String genero, double nota, int preco, int quantidadeDisponivel) 
	{
		super(nome, descricao, genero, nota, preco);
		
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidade) {
		this.quantidadeDisponivel = quantidade;
	}

	public String toString(String nome)
	{
		String b = "";
		b = b + "Titulo do filme: " + getNome() + "\nDescricao do filme: " + getDescricao() + "\nGenero do filme: " + getGenero() + "\nNota do filme: " + getNota() + "\nPreco do filme: " + getPreco() + "\nQuantidade disponivel: " + getQuantidadeDisponivel();
		return b;
	}
}
