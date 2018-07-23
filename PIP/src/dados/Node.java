package dados;
import base.CDMusica;
public class Node {
	private Node next;
	private CDMusica cd;
	
	public Node(CDMusica cd){
		this.cd = cd;
		this.next = null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public CDMusica getCd() {
		return cd;
	}

	public void setCd(CDMusica cd) {
		this.cd = cd;
	}
}
