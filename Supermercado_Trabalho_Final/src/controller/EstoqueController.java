package controller;

import model.Estoque;
import model.Produto;

public class EstoqueController {
	
	private Estoque est = new Estoque();

	public EstoqueController() {
	}
	
	public Estoque inicializarEstoque() {
		Estoque est = new Estoque();
		
		Produto p1 = new Produto("Refrigerante", 1, 6.5, 10);
		Produto p2 = new Produto("Leite", 2, 2, 21);
		
		est.adicionaProduto(p1);
		est.adicionaProduto(p2);

		this.est = est;
		return est;
	}

	public Estoque getEstoque() {
		return est;
	}
}
