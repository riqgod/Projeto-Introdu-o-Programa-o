package base;

public abstract class Midia {
	private String nome;
	private String descricao;
	private String genero;
	private double nota;
	private double preco;
	private double taxaAtraso;

	public Midia(String nome, String descricao, String genero, double nota, int preco)
	{
		this.nome = nome;
		this.descricao = descricao;
		this.genero = genero;
		this.nota = nota;
		this.preco = preco;
		this.taxaAtraso = 0.5;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getGenero()
	{
		return genero;
	}

	public void setGenero(String genero)
	{
		this.genero = genero;
	}

	public double getNota()
	{
		return nota;
	}

	public void setNota(double nota)
	{
		this.nota = nota;
	}

	public double getPreco() 
	{
		return preco;
	}

	public void setPreco(double preco)
	{
		this.preco = preco;
	}
	
	public double getTaxaAtraso() 
	{
		return taxaAtraso;
	}
	
	public double multa(int dias)
	{
		double multa = 0;
		multa = getTaxaAtraso() * dias;
		return multa;
	}
	
	public abstract String toString(String nome);
	
}