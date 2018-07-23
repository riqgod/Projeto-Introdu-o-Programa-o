package dados;
import base.CDMusica;
import excecoes.CDNEException;
import excecoes.PQNException;
public class RepCDsLista implements RepositorioCDs {
	private Node head;
	private int listCount;
	
	public RepCDsLista(){
		head = new Node(null);
		listCount = 0;
	}
	
	public void inserirCD(CDMusica cd) throws PQNException{
		if(cd.getPreco() < 0 || cd.getQtd() < 0){
			PQNException e;
			e = new PQNException();
			throw e;
		}else{
			Node tmp = new Node(cd);
			Node current = head;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(tmp);
			listCount++;
		}	
	}
	
	public String toStringCD(CDMusica cd){
		return "Album: " + cd.getAlbum() + "\nGenero: " + cd.getGenero() + "\nArtista: " + cd.getArtista() + "\nQuantidade: " + cd.getQtd() + "\nPreço: " + cd.getPreco();
	}
	
	public void toStringAllCD(){
		Node current = head.getNext();
		for(int i = 0; i < listCount; i++){
			toStringCD(current.getCd());
			current = current.getNext();
		}
	}
	
	public CDMusica encontrarCD(String Album) throws CDNEException{
		Node current = head.getNext();
		CDMusica result = null;
		for(int i = 0; i < listCount; i++){
			if(current.getCd().getAlbum() == Album){
				result = current.getCd();
			}
			current = current.getNext();
		}
		if(result == null){
			CDNEException e;
			e = new CDNEException();
			throw e;
		}else{
			return result;
		}	
	}
	
	public String procurarCD(String Album) throws CDNEException{
		Node current = head.getNext();
		CDMusica result = null;
		for(int i = 0; i < listCount; i++){
			if(current.getCd().getAlbum() == Album){
				result = current.getCd();
			}
			current = current.getNext();
		}
		if(result == null){
			CDNEException e;
			e = new CDNEException();
			throw e;
		}else{
			return result.getAlbum();
		}	
	}
	
	public void removerCD(CDMusica cd) throws CDNEException{
		Node previous = head;
		Node current = head.getNext();
		CDMusica tmp = encontrarCD(cd.getAlbum());
		for(int i = 0; i < listCount; i++){
			if(current.getCd().equals(tmp)){
				if(current.getNext() == null){
					previous.setNext(null);
					listCount--;
				}else{
					previous.setNext(current.getNext());
					listCount--;
				}
			}
		previous = previous.getNext();
		current = current.getNext();
		}
	}
	
	public void atualizarCD(CDMusica cdAntigo, CDMusica cdNovo) throws CDNEException{
			cdAntigo = encontrarCD(cdAntigo.getAlbum());
			cdAntigo.setAlbum(cdNovo.getAlbum());
			cdAntigo.setGenero(cdNovo.getGenero());
			cdAntigo.setArtista(cdNovo.getArtista());
			cdAntigo.setQtd(cdNovo.getQtd());
			cdAntigo.setPreco(cdNovo.getPreco());
		
	}

	@Override
	public int getIndiceCD(CDMusica cd) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
