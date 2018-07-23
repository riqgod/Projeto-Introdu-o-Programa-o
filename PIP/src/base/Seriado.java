package base;

public class Seriado extends Midia
{

	private int episodiosTemporadas;
	private int numeroTemporadas;
	private int disponibilidadeTemporada;
	
	public int getDisponibilidadeTemporada() {
		return disponibilidadeTemporada;
	}

	public void setDisponibilidadeTemporada(int disponibilidadeTemporada) {
		this.disponibilidadeTemporada = disponibilidadeTemporada;
	}

	private int[] temporadasDisponibilidade;
	// o elemento 0 do array é a quantidade de episodios disponiveis na 1a temporada,
	//o primeiro elemento do array a quantidade de episodios disponiveis na 2a temporada e assim por diante.
	
	public Seriado(String nome, String descricao, String genero, double nota, int preco, int episodiosTemporadas, int numeroTemporadas, int disponibilidadeTemporada)
	{
		super(nome, descricao, genero, nota, preco);
		
		this.episodiosTemporadas = episodiosTemporadas;
		this.numeroTemporadas = numeroTemporadas;
		this.temporadasDisponibilidade = new int[numeroTemporadas];
		for(int i=0; i<numeroTemporadas; i++)
		{
			this.temporadasDisponibilidade[i] = disponibilidadeTemporada;
		}
	}
	
	public int getEpisodiosTemporadas()
	{
		return episodiosTemporadas;
	}

	public void setEpisodiosTemporadas(int episodiosTemporadas)
	{
		this.episodiosTemporadas = episodiosTemporadas;
	}

	public int getNumeroTemporadas()
	{
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(int numerosTemporadas)
	{
		this.numeroTemporadas = numerosTemporadas;
	}
	
	public int getTemporadasDisponibilidadeLocal(int temporada) //*
	{
		return temporadasDisponibilidade[temporada];
	}
	public void setTemporadasDisponibilidadeLocal(int temporada, int quantidade)//*
	{
		this.temporadasDisponibilidade[temporada] = quantidade;
	}

	public void estocar(int temporada, int quantidade)
	{
		this.temporadasDisponibilidade[temporada] = this.temporadasDisponibilidade[temporada] + quantidade;
	}
	
	public String toString(String nome)
	{
		String informacoes = "";
		informacoes = informacoes + "Titulo do filme: " + getNome() + "\nDescricao do filme: " + getDescricao() + "\nGenero do filme: " + getGenero() + "\nNota do filme: " + getNota() + "\nPreco do filme: " + getPreco() + "\nNumero de temporadas: " + getNumeroTemporadas() + "\nQuantidade de Episodios por temporada: " + getEpisodiosTemporadas();
		return informacoes;
	}
	
	public String toStringDisponibilidadeTemporada(String nome)
	{
		String informacoesLocais = "";
		for (int i = 0; i<getNumeroTemporadas(); i++)
		{
			informacoesLocais += "Existem " + getTemporadasDisponibilidadeLocal(i)+ " produtos disponiveis na " + (i+1)+ "a" + " temporada " + "\n";
			if(i==getNumeroTemporadas())
			{
				informacoesLocais += getTemporadasDisponibilidadeLocal(i);
			}
		}
		return informacoesLocais;
	}
	
}
