package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Carrinho {

	private ArrayList<Produto> listaProdutoDoCliente;
	private Estoque estoque;

	public Carrinho(Estoque estoque) {
		listaProdutoDoCliente = new ArrayList<>();
		this.estoque = estoque;
	}

	public void adicionarProdutoNoCarrinho() {
		Scanner scInt = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		System.out.println(
				"============    COMPRAS CLIENTE     ==========" 
						+ "\n" + "1 - Adicionar produto pelo nome do produto"
						+ "\n" + "2 - Adicionar produto pelo codigo do produto" 
						+ "\n" + "3 - Ver estoque de produtos");
		int opcaoCliente = scInt.nextInt();

		int qtdeProduto;
		String nomeProduto;
		int codProduto;
		Produto p = new Produto();
		
		switch (opcaoCliente) {
		case 1:
			System.out.println("Nome do produto: ");
			nomeProduto = scStr.nextLine();
			if (estoque.isProdutoNoEstoque(nomeProduto)) {
				System.out.println("Quantidade: ");
				qtdeProduto = scInt.nextInt();
				p = estoque.retirarProdutoEstoque(nomeProduto, qtdeProduto);
				if (p != null) {
					Produto produtoCliente = new Produto(p.getNomeProduto(), p.getCodProduto(), p.getPrecoProduto(), 0, p.getTipoProduto());
					codProduto = p.getCodProduto();

					if (isProdutoNoCarrinho(nomeProduto)) {
						int index = retornaIndexProdutoNoCarrinho(codProduto);
						this.listaProdutoDoCliente.get(index).adicionaQtdeProduto(qtdeProduto);
						
					} else {
						this.listaProdutoDoCliente.add(produtoCliente);
						int index = retornaIndexProdutoNoCarrinho(codProduto);
						this.listaProdutoDoCliente.get(index).setQtdeProduto(qtdeProduto);
					}
				}

			} else {
				System.err.println("N�O EXISTE O PRODUTO NO ESTOQUE." + " N�O PODE ADICIONAR PRODUTO");
			}
			break;
		case 2:
			System.out.println("Codigo do produto: ");
			codProduto = scInt.nextInt();
			if (estoque.isProdutoNoEstoque(codProduto)) {
				System.out.println("Quantidade: ");
				qtdeProduto = scInt.nextInt();
				p = estoque.retirarProdutoEstoque(codProduto, qtdeProduto);

				if (p != null) {
					Produto produtoCliente = new Produto(p.getNomeProduto(), p.getCodProduto(), p.getPrecoProduto(), 0, p.getTipoProduto());					
					if (isProdutoNoCarrinho(codProduto)) {
						int index = retornaIndexProdutoNoCarrinho(codProduto);
						this.listaProdutoDoCliente.get(index).adicionaQtdeProduto(qtdeProduto);

					} else {
						this.listaProdutoDoCliente.add(produtoCliente);
						int index = retornaIndexProdutoNoCarrinho(codProduto);
						this.listaProdutoDoCliente.get(index).setQtdeProduto(qtdeProduto);
					}
				}
			} else {
				System.err.println("N�O EXISTE O PRODUTO NO ESTOQUE." + " N�O PODE ADICIONAR PRODUTO");
			}
			break;
		case 3:
			System.out.println(estoque.mostraDadosProdutos());
			break;
		default:
			System.err.println("OPCAO DE COMPRA DE PRODUTO INEXISTENTE.");
		}
		//scStr.close();
		//scInt.close();

	}

	public void retirarProdutoDoCarrinho() {
		Scanner scInt = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		System.out.println(
				"============    COMPRAS CLIENTE     ==========" + "\n" + "1 - Retirar produto pelo nome do produto"
						+ "\n" + "2 - Retirar produto pelo código do produto" + "\n" + "3 - Ver estoque de produtos");
		int opcaoCliente = scInt.nextInt();

		int qtdeProduto;
		String nomeProduto;
		int codProduto;

		Produto p = new Produto();
		switch (opcaoCliente) {
		case 1:
			System.out.println("Nome do produto: ");
			nomeProduto = scStr.nextLine();

			if (this.isProdutoNoCarrinho(nomeProduto)) {
				System.out.println("Quantidade: ");
				qtdeProduto = scInt.nextInt();

				this.estoque.retornarProdutoProEstoque(nomeProduto, qtdeProduto);
				int index = this.retornaIndexProdutoNoCarrinho(nomeProduto);
				
				p = this.listaProdutoDoCliente.get(index);
				codProduto = p.getCodProduto();

				if (qtdeProduto >= p.getQtdeProduto()) {
					this.listaProdutoDoCliente.remove(p);
				} else {
					this.listaProdutoDoCliente.get(index).removeQtdeProduto(qtdeProduto);
				}

			} else {
				System.err.println(
						"PRODUTO ESCOLHIDO N�O PODE SER RETIRADO" + " PORQUE N�O EXISTE ESSE PRODUTO NO CARRINHO");
			}
			break;
		case 2:
			System.out.println("Codigo do produto: ");
			codProduto = scInt.nextInt();

			if (isProdutoNoCarrinho(codProduto)) {
				System.out.println("Quantidade: ");
				qtdeProduto = scInt.nextInt();

				this.estoque.retornarProdutoProEstoque(codProduto, qtdeProduto);

				int index = retornaIndexProdutoNoCarrinho(codProduto);
				p = this.listaProdutoDoCliente.get(index);
				
				if (qtdeProduto >= p.getQtdeProduto()) {
					this.listaProdutoDoCliente.remove(p);
				} else {
					this.listaProdutoDoCliente.get(index).removeQtdeProduto(qtdeProduto);
				}
			}
			break;
		case 3:
			System.out.println(this.estoque.mostraDadosProdutos());
			break;
		default:
			System.err.println("OPCAO DE COMPRA DE PRODUTO INEXISTENTE.");
		}

		scInt.close();
		scStr.close();

	}

	public boolean isProdutoNoCarrinho(String nomeProduto) {
		Iterator it = listaProdutoDoCliente.iterator();

		boolean produtoNoCarrinho = false;
		Produto p;
		while (it.hasNext()) {
			p = (Produto) it.next();
			if (p.getNomeProduto().equals(nomeProduto)) {
				produtoNoCarrinho = true;
			}
		}

		return produtoNoCarrinho;
	}

	public boolean isProdutoNoCarrinho(int codProduto) {
		Iterator it = listaProdutoDoCliente.iterator();

		boolean produtoNoCarrinho = false;
		Produto p;
		while (it.hasNext()) {
			p = (Produto) it.next();
			if (p.getCodProduto() == codProduto) {
				produtoNoCarrinho = true;
			}
		}

		return produtoNoCarrinho;
	}

	public int retornaIndexProdutoNoCarrinho(int codProduto) {
		Iterator it = listaProdutoDoCliente.iterator();

		int indexProdutoNoCarrinho = 0;
		Produto p;
		while (it.hasNext()) {
			p = (Produto) it.next();
			if (p.getCodProduto() == codProduto) {
				indexProdutoNoCarrinho = listaProdutoDoCliente.indexOf(p);
			}
		}

		return indexProdutoNoCarrinho;
	}
	
	public int retornaIndexProdutoNoCarrinho(String nome) {
		Iterator it = listaProdutoDoCliente.iterator();

		int indexProdutoNoCarrinho = 0;
		Produto p;
		while (it.hasNext()) {
			p = (Produto) it.next();
			if (p.getNomeProduto().equals(nome)) {
				indexProdutoNoCarrinho = listaProdutoDoCliente.indexOf(p);
			}
		}

		return indexProdutoNoCarrinho;
	}
	

	public ArrayList<Produto> getListaProdutoDoCliente() {
		return listaProdutoDoCliente;
	}

	public void listarProdutos() {
		for (Produto p : this.listaProdutoDoCliente) {
			System.out.println("Produto: " + p.getNomeProduto() + "\t" + "Quantidade: " + p.getQtdeProduto());
		}
	}

}
