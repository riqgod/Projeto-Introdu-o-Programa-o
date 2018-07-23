package dados;

import base.Cliente;
import excecoes.CJCException;
import excecoes.CNEException;
import dados.RepositorioClientesInterface;


public class RepositorioClientesLista implements RepositorioClientesInterface{
	
	

	private Cliente cliente;
	private RepositorioClientesLista proximo;
	
	public RepositorioClientesLista(){
		
		this.cliente = null;
		this.proximo = null;
		
	}
	

	public void inserirCliente(Cliente cliente) throws CJCException {
		
	if(!existeCliente(cliente.getCPF())){
	
	
		if (this.cliente == null) {
			
			this.cliente = cliente;
			this.proximo = new RepositorioClientesLista();
			
		} else {
			
			this.proximo.inserirCliente(cliente);
		}

	}else{
		throw new CJCException();
	}
	}
	
	

	public Cliente procurarCliente(String CPF) throws CNEException {

		Cliente resposta = null; 

		if (this.cliente != null) {

			if (this.cliente.getCPF()==CPF) {
			
				return resposta = this.cliente;
				

			} else if(this.proximo!=null) {
				
				return this.proximo.procurarCliente(CPF);
				
			} else {
				throw new CNEException();
			}

		} else {
			throw new CNEException();
		}
		
		
		
	}
	
	public boolean existeCliente(String CPF){
		
		boolean existe = false;
		

		if (this.cliente != null) {

			if (this.cliente.getCPF()== CPF) {
			
				return existe = true;
				

			} else if(this.proximo!=null) {
				
				return existe = this.proximo.existeCliente(CPF);
				
			} else {
		return		existe = false;
			}

		} else {
		return	existe = false;
		}
		
		
		
	}
	

	public void removerCliente(String CPF) throws CNEException {

		if (this.cliente != null) {

			if (this.cliente.getCPF() == CPF) {

				if (this.proximo == null) {

					this.cliente = null;

				} else if (this.proximo.proximo == null) {

					this.cliente = this.proximo.cliente;
					this.proximo = null;

				} else {

					this.cliente = this.proximo.cliente;
					this.proximo = this.proximo.proximo;

				}

			} else {
				this.proximo.removerCliente(CPF);
			}
		} else {
			throw new CNEException();
		}

	}

	public void atualizarCliente(String CPF, Cliente clienteAtualizado) throws CNEException {
		
		Cliente antigo = procurarCliente(CPF);
		
		antigo.setNome(clienteAtualizado.getNome());
		antigo.setCPF(clienteAtualizado.getCPF());
		antigo.setTelefone(clienteAtualizado.getTelefone());
		antigo.setValorAtrasado(clienteAtualizado.getValorAtrasado());
		for(int i=0;i<10;i++ ){
			antigo.setProdutosLocados(i,clienteAtualizado.getProdutosLocados(i));
		}
		antigo.setProdutosLocadosQuantidade(clienteAtualizado.getProdutosLocadosQuantidade());

	}

}
