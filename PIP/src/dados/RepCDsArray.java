package dados;
import base.CDMusica;
import excecoes.CDNEException;
import excecoes.PQNException;
import negocios.*;
//Escrito por Italo Soares (irs)
//Miniprojeto - IP - CC - 2016.1
//Classe Repositório Array CDMusica
/*Consiste das interfaces básicas requeridas: Adicionar, remover, procurar, etc...*/
public class RepCDsArray implements RepositorioCDs {
	private CDMusica[] cds;
	private int indice;
	
	public RepCDsArray(int tamanho){
		this.cds = new CDMusica[tamanho];
		this.indice = 0;
	}
	
	public void inserirCD(CDMusica cd) throws PQNException{
		if(cd.getPreco() < 0 || cd.getQtd() < 0){
			PQNException e;
			e = new PQNException();
			throw e;
		}else{
			this.cds[indice] = cd;
			indice++;
		}
	}
	
	
	public String procurarCD(String nome) throws CDNEException{
		return cds[getIndiceCD(nome)].getAlbum();
	}
	
	public int getIndiceCD(String nome) throws CDNEException{
		int i, resultado=-1;
		for(i = 0; i < indice; i++){
			if(cds[i].getAlbum() == nome){	
				resultado = i;	
			}
		}
		if(resultado == -1){
			CDNEException e;
			e = new CDNEException();
			throw e;
		}else{
			return resultado;
		}
	}
	
	
	public void removerCD(CDMusica cd){
		int i = this.getIndiceCD(cd);
		this.cds[i] = this.cds[indice-1];
		this.cds[indice-1] = null;
	} 
	
	public int getIndiceCD(CDMusica cd){
		int i, resultado=-1;
		for(i = 0; i < indice; i++){
			if(cds[i] == cd){	
				resultado = i;	
			}
		}
			return resultado;
	}
	
	public String toStringCD(CDMusica cd){
		return "Album: " + cd.getAlbum() + "\nGenero: " + cd.getGenero() + "\nArtista: " + cd.getArtista() + "\nQuantidade: " + cd.getQtd() + "\nPreço: " + cd.getPreco();
	}
	
	public void atualizarCD(CDMusica cdAntigo, CDMusica cdNovo) throws PQNException{
		int indice = getIndiceCD(cdAntigo);
		cds[indice].setAlbum(cdNovo.getAlbum());
		cds[indice].setGenero(cdNovo.getGenero());
		cds[indice].setArtista(cdNovo.getArtista());
		cds[indice].setQtd(cdNovo.getQtd());
		cds[indice].setPreco(cdNovo.getPreco());
	}
	
	
	
}