package base;
//Escrito por Italo Soares (irs)
//Miniprojeto - IP - CC - 2016.1
//Classe Básica CDMusica
/*Essa classe consiste basicmante dos atributos, construtor, getters e setters. 
Nada de interessante. */
public class CDMusica {
	private String Album;
	private String Genero;
	private String Artista;
	private int qtd;
	private double Preco;
	
	public CDMusica(String Album, String Genero, String Artista, int qtd, double Preco){
		this.Album = Album;
		this.Genero = Genero;
		this.Artista = Artista;
		this.qtd = qtd;
		this.Preco = Preco;
	}
	
	public void setAlbum(String Album){
		this.Album = Album;
	}
	
	public void setGenero(String Genero){
		this.Genero = Genero;
	}
	
	public void setArtista(String Artista){
		this.Artista = Artista;
	}
	
	public void setQtd(int qtd){
		this.qtd = qtd;
	}
	
	public void setPreco(double Preco){
		this.Preco = Preco;
	}
	
	public String getAlbum(){
		return this.Album;
	}
	
	public String getGenero(){
		return this.Genero;
	}
	
	public String getArtista(){
		return this.Artista;
	}
	
	public int getQtd(){
		return this.qtd;
	}
	
	public double getPreco(){
		return this.Preco;
	}
}