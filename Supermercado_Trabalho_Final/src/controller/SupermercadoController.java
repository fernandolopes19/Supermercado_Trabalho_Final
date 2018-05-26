package controller;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	public void realocarVendedorCaixa() {
		Vendedor vendedorSelecionado = null;
		Caixa caixaSelecionado = null;
		
		ArrayList<Caixa> caixas = this.supermercado.getListaCaixas();
		ArrayList<Funcionario> funcionarios = this.supermercado.getFuncionarios();

		System.out.println("Digite o codigo do funcionario: ");
		for(Funcionario f : funcionarios) {
			if(f instanceof Vendedor) {
				System.out.println("Codigo: " + f.getIdFuncionario() + " / Nome: " + f.getNome());
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int codigoVendedor;
		selectFunc: while(true) {
			codigoVendedor = sc.nextInt();
			for(int i = 0; i < funcionarios.size(); i++) {
				if(funcionarios.get(i).getIdFuncionario() == codigoVendedor) {
					vendedorSelecionado = (Vendedor) funcionarios.get(i);
					break;
				}
			}
			if(vendedorSelecionado != null) {
				boolean caixaOperado = false;
				for(Caixa c : caixas) {
					if(c.getVendedor().getIdFuncionario() == vendedorSelecionado.getIdFuncionario()) {
						System.out.println("Este vendedor ja esta operando um caixa. Selecione outro: ");
						caixaOperado = true;
						break;
					} else {
						caixaOperado = false;
					}
				}
				if(!caixaOperado) {
					break selectFunc;
				}
			} else {
				System.out.println("Codigo invalido. Digite novamente: ");
			}
		}
		
		System.out.println("Digite o codigo do caixa: ");
		for(Caixa c : caixas) {
			System.out.println("Codigo: " + c.getId());
		}
		
		selectCaixa: while(true) {
			int codigoCaixa = sc.nextInt();
			for(Caixa c : caixas) {
				if(c.getId() == codigoCaixa) {
					caixaSelecionado = c;
				}

				if(c.getVendedor().equals(vendedorSelecionado)) {
					c.setVendedor(null);
				}
			}
			if(caixaSelecionado != null) {
				caixaSelecionado.setVendedor(vendedorSelecionado);
				break selectCaixa;
			} else {
				System.out.println("Codigo invalido. Digite novamente: ");
			}
		}
		
		for(Caixa c : caixas) {
			c.exibirCaixa();
		}
	}
}
