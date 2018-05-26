package controller;

import java.util.ArrayList;

import model.Caixa;
import model.Estoque;
import model.Funcionario;
import model.Gerente;
import model.Leitor;
import model.Supermercado;
import model.Venda;
import model.Vendedor;

public class SupermercadoController {
	private Supermercado supermercado;
	
	public SupermercadoController() {
		
	}

	public Supermercado inicializarSupermercado(String nomeSupermercado, Estoque estoque) {
				
		Supermercado mercado = new Supermercado(nomeSupermercado);
		mercado.registrarEstoque(estoque);
		
		Vendedor v1 = new Vendedor("Vendedor 01", 1);
		Vendedor v2 = new Vendedor("Vendedor 02", 2);
		Vendedor v3 = new Vendedor("Vendedor 03", 3);
		Vendedor v4 = new Vendedor("Vendedor 04", 4);
		Vendedor v5 = new Vendedor("Vendedor 05", 5);
		Gerente g1 = new Gerente("Gerente", 6, "Comercial");
		
		mercado.addFuncionario(v1);
		mercado.addFuncionario(v2);
		mercado.addFuncionario(v3);
		mercado.addFuncionario(v4);
		mercado.addFuncionario(v5);
		mercado.addFuncionario(g1);
		
		//Caixa c1 = new Caixa(f1, mercado);
		//Caixa c2 = new Caixa(f2, mercado);
		//Caixa c3 = new Caixa(f3, mercado);

		mercado.registrarCaixa(new Caixa(v1, mercado, 1));
		mercado.registrarCaixa(new Caixa(v2, mercado, 2));
		mercado.registrarCaixa(new Caixa(v3, mercado, 3));

		this.supermercado = mercado;
		return mercado;
	}
	
	public void gerarRelatorioCaixas() {
		System.out.println("\nRelatorio dos caixas");

		ArrayList<Caixa> caixas = this.supermercado.getListaCaixas();
		double totalVendas = 0;

		for(Caixa c : caixas) {
			System.out.println("===============");
			System.out.println("Caixa: " + c.getId());
			ArrayList<Venda> vendas = c.getVendas();
			for(Venda v : vendas) {
				System.out.println("\nValor da venda: R$" + v.getValor());
				System.out.println("Forma de pagamento: " + v.getFormaPagamento());
				System.out.println("Responsavel: " + v.getResponsavel().getNome());
				
				totalVendas += v.getValor();
			}
		}
		System.out.println("\nTotal de vendas: R$" + totalVendas);
	}
}
