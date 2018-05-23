package model;

public class Gerente extends Funcionario {
	private String area;

	public Gerente(String nome, int idFuncionario, String area) {
		super(nome, idFuncionario);
		this.setArea(area);
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
}
