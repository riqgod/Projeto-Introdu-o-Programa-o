package dados;

import base.Cliente;
import excecoes.CJCException;
import excecoes.CNEException;
import excecoes.RAEException;

public interface RepositorioClientesInterface {

	
	void inserirCliente(Cliente cliente) throws RAEException, CJCException;
	Cliente procurarCliente(String CPF) throws CNEException;
	boolean existeCliente(String CPF);
	void removerCliente(String CPF) throws CNEException;
	void atualizarCliente(String CPF, Cliente clienteAtualizado)throws CNEException;
	
	
		
	
	
}
