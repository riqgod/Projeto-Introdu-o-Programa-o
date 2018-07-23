package dados;

import excecoes.FNEException;
import base.Funcionario;

public class RepositorioFuncionariosLista implements RepositorioFuncionarios {
	private Funcionario funcionario;
	private Funcionario procurado;
	private RepositorioFuncionariosLista proximo;

	public RepositorioFuncionariosLista() {
		funcionario = null;
		proximo = null;
		procurado = null;
	}

	public void inserirFuncionario(Funcionario funcionario) {
		if (this.funcionario == null) {
			this.funcionario = funcionario;
			this.proximo = new RepositorioFuncionariosLista();
		} else {
			this.proximo.inserirFuncionario(funcionario);
		}
	} // OK

	public void removerFuncionario(Funcionario funcionario) throws FNEException {
		if (this.proximo != null) {
			if (this.funcionario.equals(funcionario)) {
				this.funcionario = this.proximo.funcionario;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.removerFuncionario(funcionario);
			}
		} else {
			throw new FNEException();
		}
	} // OK

	public Funcionario procurarFuncionario(String nome) throws FNEException {
		if (this.funcionario != null) {
			if (this.funcionario.equals(funcionario)) {
				procurado = this.funcionario;
			} else {
				procurado = this.proximo.procurarFuncionario(nome);
			}
		} else {
			throw new FNEException();
		}
		return procurado;
	} // OK

	public void atualizarFuncionario(Funcionario funcionarioAntigo, Funcionario funcionarioAtualizado)
			throws FNEException {
		funcionarioAntigo = procurarFuncionario(funcionarioAntigo.getNomeFuncionario());
		funcionarioAntigo.setNomeFuncionario(funcionarioAtualizado.getNomeFuncionario());
		funcionarioAntigo.setCargoFuncionario(funcionarioAtualizado.getCargoFuncionario());
		funcionarioAntigo.setSalarioFuncionario(funcionarioAtualizado.getSalarioFuncionario());
		funcionarioAntigo.setTempoServicoFuncionario(funcionarioAtualizado.getTempoServicoFuncionario());
	}

	public boolean existeFuncionario(String nome) throws FNEException {
		boolean existe = false;
		if (this.funcionario != null) {
			if (this.funcionario.getNomeFuncionario().equalsIgnoreCase(nome)) {
				return existe = true;
			} else if (this.proximo != null) {
				return existe = this.proximo.existeFuncionario(nome);
			} else {
				return existe = false;
			}
		} else {
			return existe = false;
		}
	} // OK

}
