package negocios;

import base.Funcionario;
import dados.RepositorioFuncionariosArray;
import dados.RepositorioFuncionariosLista;
import excecoes.FJCException;
import excecoes.FNEException;
import excecoes.TRIException;
import dados.RepositorioFuncionarios;

public class RepFuncionarios {
	public static final String tipoArray = "ARRAY";
	public static final String tipoLista = "LISTA";
	
	private RepositorioFuncionarios rep;
	
	public RepFuncionarios(String tipoRepositorio) throws TRIException{
		if(tipoRepositorio.equals(tipoArray)){
			this.rep = (RepositorioFuncionarios) new RepositorioFuncionariosArray(3);
		}else if(tipoRepositorio.equals(tipoLista)){
			this.rep = (RepositorioFuncionarios) new RepositorioFuncionariosLista();
		}else{
			throw new TRIException();
		}
	}
	
	public void inserirFuncionario(Funcionario funcionario) throws FJCException, FNEException{
		if (rep.existeFuncionario(funcionario.getNomeFuncionario())) {
			throw new FJCException();
		} else {
			rep.inserirFuncionario(funcionario);
		}
	}
	
	public void removerFuncionario(Funcionario funcionario) throws FNEException{
		rep.removerFuncionario(funcionario);
	}
	
	public Funcionario procurarFuncionario(String nome) throws FNEException {
		return rep.procurarFuncionario(nome);
	}
	
	public void atualizarFuncionario(Funcionario funcionarioAntigo, Funcionario funcionarioAtualizado) throws FNEException{
		rep.atualizarFuncionario(funcionarioAntigo, funcionarioAtualizado);
	}
}
