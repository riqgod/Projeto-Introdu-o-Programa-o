package dados;

import excecoes.FNEException;
import base.Funcionario;

public interface RepositorioFuncionarios {

	public void inserirFuncionario(Funcionario funcionario);

	public void removerFuncionario(Funcionario funcionario) throws FNEException;

	public Funcionario procurarFuncionario(String nome) throws FNEException;

	public void atualizarFuncionario(Funcionario Antigo, Funcionario Atualizado) throws FNEException;

	public boolean existeFuncionario(String nome) throws FNEException;
}
