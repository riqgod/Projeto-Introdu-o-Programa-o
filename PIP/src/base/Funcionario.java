package base;

public class Funcionario {
	private int tempoServico; // em meses
	private double salario; // em reais
	private String cargo;
	private String nome;

	public Funcionario(String nome, String cargo) {
		tempoServico = 0;
		salario = 880;
		this.cargo = cargo;
		this.nome = nome;
	}

	public int getTempoServicoFuncionario() {
		return tempoServico;
	}

	public void setTempoServicoFuncionario(int tempoServico) {
		this.tempoServico = tempoServico;
	}

	public double getSalarioFuncionario() {
		return salario;
	}

	public void setSalarioFuncionario(double salario) {
		this.salario = salario;
	}

	public String getCargoFuncionario() {
		return cargo;
	}

	public void setCargoFuncionario(String cargo) {
		this.cargo = cargo;
	}

	public String getNomeFuncionario() {
		return nome;
	}

	public void setNomeFuncionario(String nome) {
		this.nome = nome;
	}

	public boolean equals(Funcionario funcionario) {
		String nomeFuncionario = funcionario.getNomeFuncionario();
		String cargoFuncionario = funcionario.getCargoFuncionario();
		if (this.nome == nomeFuncionario) {
			if (this.cargo == cargoFuncionario) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
