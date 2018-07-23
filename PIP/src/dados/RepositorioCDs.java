package dados;

import base.CDMusica;
import excecoes.CDNEException;
import excecoes.PQNException;
import negocios.*;
public interface RepositorioCDs {
	public void inserirCD(CDMusica cd) throws PQNException;
	public String procurarCD(String Album) throws CDNEException;
	public void removerCD(CDMusica cd) throws CDNEException;
	public void atualizarCD(CDMusica cdAntigo, CDMusica cdNovo) throws CDNEException, PQNException;
	public int getIndiceCD(CDMusica cd);
}
