package model;

public class Funcionario extends Pessoa {

	private int idFuncionario;
	private double salario;

	public Funcionario(String nome, int idFuncionario) {
		super(nome);
		this.idFuncionario = idFuncionario;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int id) {
		this.idFuncionario = id;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
