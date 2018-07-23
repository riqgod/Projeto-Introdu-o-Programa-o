package negocios;

import base.Cliente;
import dados.RepositorioClientesArray;
import dados.RepositorioClientesInterface;
import dados.RepositorioClientesLista;
import excecoes.CJCException;
import excecoes.CNEException;
import excecoes.RAEException;
import excecoes.TRIException;

public class RepClientes {
	
	public static final String tipoArray = "ARRAY";
	public static final String tipoLista = "LISTA";

	private RepositorioClientesInterface rep;
	
	public RepClientes(String tipoRepositorio) throws TRIException{
		if(tipoRepositorio.equals(tipoArray)){
			this.rep = (RepositorioClientesInterface) new RepositorioClientesArray(3);
		}else if(tipoRepositorio.equals(tipoLista)){
			this.rep = (RepositorioClientesInterface) new RepositorioClientesLista();
		}else{
			TRIException e;
			e = new TRIException();
			throw e;
		}
	}
	
	public void inserirCliente(Cliente cliente) throws RAEException, CJCException{
		rep.inserirCliente(cliente);
	}
	
	public void removerCliente(String CPF) throws CNEException{
		rep.removerCliente(CPF);
	}
	public Cliente procurarCliente(String CPF) throws CNEException{
		return rep.procurarCliente(CPF);
	}
	
	public void atualizarCliente (String CPF, Cliente clienteAtualizado) throws CNEException{
		rep.atualizarCliente(CPF,clienteAtualizado);
	}
	
}
