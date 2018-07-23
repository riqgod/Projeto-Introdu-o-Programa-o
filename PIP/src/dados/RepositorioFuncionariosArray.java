package dados;

import excecoes.FNEException;
import excecoes.JNEException;
import base.Funcionario;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {
	private Funcionario[] funcionarios;
	private int indiceProcurado;
	private int indice;

	public RepositorioFuncionariosArray(int tam) {
		indice = 0;
		funcionarios = new Funcionario[tam];
		indiceProcurado = -1;
	}

	public void inserirFuncionario(Funcionario funcionario) {
		if (indice < funcionarios.length) {
			funcionarios[indice] = funcionario;
			indice++;
		}
	}
	
	private int getIndiceFuncionarios(String nome)
	{
		String n;
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i< this.indice))
		{
			n = funcionarios[i].getNomeFuncionario();
			if(n.equals(nome))
			{
				achou = true;
			}
			else
			{
				i++;
			}
		}
		return i;
	}

	public void removerFuncionario(Funcionario funcionario) throws FNEException {
		int i = this.getIndiceFuncionarios(funcionario.getNomeFuncionario());
		if (i == this.indice) {
			throw new FNEException();
		} else {
			this.indice = this.indice - 1;
			this.funcionarios[i] = this.funcionarios[this.indice];
			this.funcionarios[this.indice] = null;
		}
	}

	public Funcionario procurarFuncionario(String nome) throws FNEException {
		int aux = 0;
		for (int i=0; i<indice; i++)
		{
			aux++;
			if(this.funcionarios[i] != null)
			{
				if(this.funcionarios[i].getNomeFuncionario().equalsIgnoreCase(nome))
				{
					return this.funcionarios[i];
				}
			}
			else
			{
				throw new FNEException();
			}
		}
		return this.funcionarios[aux];
	}

	public boolean existeFuncionario(String nome) throws FNEException {
		int i = this.getIndiceFuncionarios(nome);
		return (i != this.indice);
	}

	public void atualizarFuncionario(Funcionario funcionarioAntigo, Funcionario funcionarioAtualizado) throws FNEException {
		funcionarioAntigo = procurarFuncionario(funcionarioAntigo.getNomeFuncionario());
		funcionarioAntigo.setNomeFuncionario(funcionarioAtualizado.getNomeFuncionario());
		funcionarioAntigo.setCargoFuncionario(funcionarioAtualizado.getCargoFuncionario());
		funcionarioAntigo.setSalarioFuncionario(funcionarioAtualizado.getSalarioFuncionario());
		funcionarioAntigo.setTempoServicoFuncionario(funcionarioAtualizado.getTempoServicoFuncionario());
	}

}
