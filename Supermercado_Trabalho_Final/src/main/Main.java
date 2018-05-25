package main;

import java.util.Scanner;

import controller.EstoqueController;
import controller.SupermercadoController;
import model.Caixa;
import model.Carrinho;
import model.Cliente;
import model.Estoque;
import model.Gerente;
import model.Supermercado;

public class Main {
	public static void main(String args[]) {
		EstoqueController stqControl = new EstoqueController();
		Estoque estoque = stqControl.inicializarEstoque();
		SupermercadoController spControl = new SupermercadoController();
		Supermercado mercado = spControl.inicializarSupermercado("Mercado Teste", estoque);
		
		Cliente c1 = new Cliente("Lucas");
		c1.setCarrinho(new Carrinho(mercado.getEstoque()));
		
		Gerente g1 = new Gerente("Gerente 01", 1, "Comercial", spControl, stqControl);
		
		Scanner sc = new Scanner(System.in);
		int opcao;
		// Label do loop, assim podemos interromper dentro do switch
		clientMenu: while(true) {
			System.out.print("\n\n\n");
			System.out.println("Ola, " + c1.getNome() + ". Selecione uma acao:");
			System.out.println("1 - Adicionar produto \n2 - Ver carrinho \n3 - Pagar");
			opcao = sc.nextInt();
			if(opcao == -1) break clientMenu;
			switch (opcao) {
			case 1:
				c1.getCarrinho().adicionarProdutoNoCarrinho();
				break;
			case 2:
				c1.getCarrinho().listarProdutos();
				break;
			case 3:
				Caixa caixaDisponivel = mercado.retornaCaixaDisponivel();
				if(caixaDisponivel != null) {
					caixaDisponivel.atenderCliente(c1);
					break clientMenu;
				} else {
					System.out.println("Nenhum caixa disponível. Por favor, aguarde!");
				}
				break;
			default:
				break;
			}
		}
		
		gerenteMenu: while(true) {
			System.out.print("\n\n\n");
			System.out.println("Ola, " + g1.getNome() + ". Selecione uma acao:");
			System.out.println("1 - Gerar relatorio dos caixas \n2 - Gerar relatorio final do dia (estoque) \n3 - Exibir relatorio do estoque \n4 - Encomendar produto novo");
			if(sc.hasNextInt()) {
				opcao = sc.nextInt();
			}

			if(opcao == -1) break gerenteMenu;
			
			switch (opcao) {
			case 1:
				g1.getSupermercadoControl().gerarRelatorioCaixas();
				break;
			case 2:
				g1.getEstoqueControl().gerarRelatorioFinalDia();
				break;
			case 3:
				g1.getEstoqueControl().exibirRelatorio();
				break;
			case 4:
				g1.getEstoqueControl().encomendaProdutoNovo();
				break;
			default:
				break;
			}
		}				
	}
}
