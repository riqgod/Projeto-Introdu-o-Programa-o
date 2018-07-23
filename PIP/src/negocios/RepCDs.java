package negocios;

import base.CDMusica;
import dados.RepCDsArray;
import dados.RepCDsLista;
import dados.RepositorioCDs;
import excecoes.CDNEException;
import excecoes.PQNException;
import excecoes.TRIException;

public class RepCDs {
	public static final String tipoArray = "ARRAY";
	public static final String tipoLista = "LISTA";
	
	private RepositorioCDs rep;
	
	public RepCDs(String tipoRepositorio) throws TRIException{
		if(tipoRepositorio.equals(tipoArray)){
			this.rep = new RepCDsArray(3);
		}else if(tipoRepositorio.equals(tipoLista)){
			this.rep = new RepCDsLista();
		}else{
			TRIException e;
			e = new TRIException();
			throw e;
		}
	}
	
	public void inserirCD(CDMusica cd) throws PQNException{
		if(cd.getPreco() < 0 || cd.getQtd() < 0){
			PQNException e;
			e = new PQNException();
			throw e;
		}else{
			rep.inserirCD(cd);
		}
	}
	
	public void removerCD(CDMusica cd) throws CDNEException{
		rep.removerCD(cd);
	}
	
	public CDMusica procurarCD(CDMusica cd) throws CDNEException{
		rep.procurarCD(cd.getAlbum());
		return cd;
	}
	
	public void atualizar(CDMusica cdAntigo, CDMusica cdNovo) throws CDNEException, PQNException{
		rep.atualizarCD(cdAntigo, cdNovo);
	}
}
