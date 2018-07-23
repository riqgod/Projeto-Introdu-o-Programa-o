package negocios;

import excecoes.FJCException;
import excecoes.FNEException;
import base.Funcionario;
import dados.RepositorioFuncionarios;

public class CadastroFuncionarios {

	private RepositorioFuncionarios funcionarios;

	public CadastroFuncionarios(RepositorioFuncionarios rep) {
		funcionarios = rep;
	}

	public void cadastrarFuncionario(Funcionario funcionario) throws FJCException, FNEException {
		if (funcionarios.existeFuncionario(funcionario.getNomeFuncionario()) == false) {
			funcionarios.inserirFuncionario(funcionario);
		} else {
			throw new FJCException();
		}
	}

	public void removerCadastroFuncionario(Funcionario funcionario) throws FNEException {
		if (funcionarios.existeFuncionario(funcionario.getNomeFuncionario()) == true) {
			funcionarios.removerFuncionario(funcionario);
		} else {
			throw new FNEException();
		}
	}
}
