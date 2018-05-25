package model;

import controller.EstoqueController;
import controller.SupermercadoController;

public class Gerente extends Funcionario {
	private String area;
	private SupermercadoController supermercadoControl;
	private EstoqueController estoqueControl;

	public Gerente (String nome, int idFuncionario, String area) {
		super(nome, idFuncionario);
		this.setArea(area);
	}
	
	public Gerente (String nome, int idFuncionario, String area, SupermercadoController supermercadoControl, EstoqueController estoqueControl) {
		super(nome, idFuncionario);
		this.setArea(area);
		this.supermercadoControl = supermercadoControl;
		this.estoqueControl = estoqueControl;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public SupermercadoController getSupermercadoControl() {
		return supermercadoControl;
	}

	public void setSupermercadoControl(SupermercadoController supermercadoControl) {
		this.supermercadoControl = supermercadoControl;
	}

	public EstoqueController getEstoqueControl() {
		return estoqueControl;
	}

	public void setEstoqueControl(EstoqueController estoqueControl) {
		this.estoqueControl = estoqueControl;
	}
	
	public void gerarRelatorioFinalDoDia() {
		this.estoqueControl.gerarRelatorioFinalDia();
	}
}
