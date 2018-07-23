package dados;

import base.Cliente;
import excecoes.CJCException;
import excecoes.CNEException;
import excecoes.RAEException;
import dados.RepositorioClientesInterface;


public class RepositorioClientesArray implements RepositorioClientesInterface{

	private Cliente[] clientes;
	private int indice;
	private Cliente cliente;
	private int tamanho;
	
	public RepositorioClientesArray (int tam){
		
		clientes = new Cliente[tam];
		this.indice = 0;
		this.tamanho = tam;
			
		
	}
	
	
	
	public void inserirCliente(Cliente cliente) throws RAEException, CJCException{
		
		if(!existeCliente(cliente.getCPF())){
		
		if(indice < tamanho){
			clientes[indice] = cliente;
			indice++;
		} else {
			throw new RAEException();
		}
	} else {
		throw new CJCException();
	}
	}
	
	private int getIndice(String CPF){
		
		String cpf;
		boolean achou = false;
		int i = 0;
		while((!achou)& (i < this.indice)) {
			cpf = clientes[i].getCPF();
			if(cpf.equals(CPF)){
				achou = true;
			}else {
				i++;
			}
		}
		
		return i;
		
	}

	public Cliente procurarCliente(String CPF) throws CNEException {
	
		int i = this.getIndice(CPF);
		if( i == this.indice){
			throw new CNEException();
					
		} else {
			return this.clientes[this.getIndice(CPF)];
		}
	}
	
	public boolean existeCliente(String CPF){
		
		int i = this.getIndice(CPF);
		if( i == this.indice) {
			return false;
		}else{
			return true;
		}
		
	}

	public void removerCliente(String CPF) throws CNEException {
		
		int i = this.getIndice(CPF);
		if( i == this.indice){
			throw new CNEException();
		} else {
			this.indice --;
			this.clientes[i] = this.clientes[this.indice];
			this.clientes[this.indice] = null;
		}
				
	}

	@Override
	public void atualizarCliente(String CPF, Cliente clienteAtualizado) throws CNEException {
	
		int i = this.getIndice(CPF);
		if ( i == this.indice){	
			
			throw new CNEException();
			
		} else {
			this.clientes[i] = clienteAtualizado;	
		}
		
	}
}