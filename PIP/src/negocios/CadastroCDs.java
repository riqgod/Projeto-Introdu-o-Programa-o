package negocios;
import base.CDMusica;
import dados.*;
import excecoes.CDJEException;
import excecoes.CDNEException;
import excecoes.PQNException;
public class CadastroCDs {
	private RepositorioCDs cds;
	
	public CadastroCDs(RepositorioCDs cds){
		this.cds = cds;
	}
	
	public void cadastrarCD(CDMusica cd) throws CDJEException, PQNException{
		if(cds.getIndiceCD(cd) == -1){
			cds.inserirCD(cd);
		}else{
			CDJEException e;
			e = new CDJEException();
			throw e;
		}
	}
	
	public void removerCD(CDMusica cd) throws CDNEException{
		if(cds.getIndiceCD(cd) != -1){
			cds.removerCD(cd);
		}else{
			CDNEException e;
			e = new CDNEException();
			throw e;
		}
	}
}
