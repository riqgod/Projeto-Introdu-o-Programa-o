package negocios;

import base.Cliente;
import excecoes.CNEException;
import excecoes.RAEException;
import dados.RepositorioClientesInterface;
import excecoes.CJCException;

public class CadastroCliente {
	
	private RepositorioClientesInterface clientes;
	

	public CadastroCliente(RepositorioClientesInterface repositorio) {
		
		clientes = repositorio;
		
	}
	
	
	public void cadastrarClientes(Cliente cliente) throws CJCException, RAEException{
		
		if(!clientes.existeCliente(cliente.getCPF())){
			clientes.inserirCliente(cliente);
		}else {
			
			throw new CJCException();
		}
		
	}
	
	public void removerCadastroCliente(String CPF) throws CNEException {
		if(!clientes.existeCliente(CPF)){
			clientes.removerCliente(CPF);
		}else {
			throw new CNEException();
		}
	}
	
	
	
	
	
}
