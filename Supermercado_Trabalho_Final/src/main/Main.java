package main;

import controller.EstoqueController;
import controller.SupermercadoController;
import model.Carrinho;
import model.Cliente;
import model.Estoque;
import model.Supermercado;

public class Main {
	public static void main(String args[]) {
		EstoqueController stqControl = new EstoqueController();
		Estoque estoque = stqControl.inicializarEstoque();
		SupermercadoController spControl = new SupermercadoController();
		Supermercado mercado = spControl.inicializarSupermercado("Mercado Teste", estoque);
		
		Cliente c1 = new Cliente("Lucas");
		c1.setCarrinho(new Carrinho(mercado));
		
		c1.getCarrinho().adicionarProdutoNoCarrinho();
		c1.getCarrinho().listarProdutos();
		
		System.out.println("Rodou de boa");
		
	}
}
