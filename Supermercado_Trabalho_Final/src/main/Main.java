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

		Scanner scInt = new Scanner(System.in);
		int opcao;
		int opcaoMenu;
		boolean statusMenu = true;
		while (statusMenu) {
			System.out.println("Digite a op�ao:" + "\n1 - CLIENTE" + "\n2 - GERENTE" + "\n0 - SAIR");
			opcaoMenu = scInt.nextInt();
			switch (opcaoMenu) {
			case 1:
				clientMenu: while (true) {
					System.out.print("\n\n");
					System.out.println("Ola, " + c1.getNome() + ". Selecione uma acao:");
					System.out.println("1 - Adicionar produto" 
							+ "\n2 - Ver carrinho" 
							+ "\n3 - Pagar" 
							+ "\n4 - Consultar produto no leitor"
							+ "\n0 - Sair");
					opcao = scInt.nextInt();
					if (opcao == -1)
						break clientMenu;
					switch (opcao) {
					case 1:
						c1.getCarrinho().adicionarProdutoNoCarrinho();
						break;
					case 2:
						c1.getCarrinho().listarProdutos();
						break;
					case 3:
						Caixa caixaDisponivel = mercado.retornaCaixaDisponivel();
						if (caixaDisponivel != null) {
							caixaDisponivel.atenderCliente(c1);
							break clientMenu;
						} else {
							System.out.println("Nenhum caixa dispon�vel. Por favor, aguarde!");
						}
						break;
					case 4: 
						System.out.println("Digite o codigo do produto");
						int codigo = scInt.nextInt();
						mercado.consultarProdutoLeitor(codigo);
						
						break;
					case 0:
						break clientMenu;
					default:
						break;
					}
				}
				break;
			case 2:
				// Label do loop, assim podemos interromper dentro do switch
				gerenteMenu: while (true) {
					System.out.print("\n\n\n");
					System.out.println("Ola, " + g1.getNome() + ". Selecione uma acao:");
					System.out.println("1 - Gerar relatorio dos caixas" 
							+ "\n2 - Gerar relatorio final do dia (estoque)"
							+ "\n3 - Exibir relatorio do estoque" 
							+ "\n4 - Encomendar produto novo" 
							+ "\n5 - Encomendar produto j� existente " 
							+ "\n6 - Realocar caixa"
							+ "\n0 - Sair");
					opcao = scInt.nextInt();
					if (opcao == -1)
						break gerenteMenu;

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
					case 5:
						g1.getEstoqueControl().encomendaProdutoJaExistente();
						break;
					case 6:
						g1.getSupermercadoControl().realocarVendedorCaixa();
						break;
					case 0:
						break gerenteMenu;
					default:
						break;
					}
				}
			break;
			case 0:
				statusMenu = false;
				break;
			default:
				break;
			}
		}

	}
}
