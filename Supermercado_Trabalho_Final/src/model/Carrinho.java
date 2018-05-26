package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import enums.EnumProdutoTipo;

public class Carrinho {

	private ArrayList<Produto> listaProdutoDoCliente;
	private Estoque estoque;

	public Carrinho(Estoque estoque) {
		listaProdutoDoCliente = new ArrayList<>();
		this.estoque = estoque;
	}

	public void adicionarProdutoNoCarrinho() {
		Scanner scInt = new Scanner(System.in);
		Scanner scDouble = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		System.out.println(
				"============    COMPRAS CLIENTE     ==========" 
						+ "\n1 - Adicionar produto pelo nome do produto"
						+ "\n2 - Adicionar produto pelo codigo do produto" 
						+ "\n3 - Ver estoque de produtos");
		int opcaoCliente = scInt.nextInt();

		int qtdeProduto;
		double pesoProduto;
		String nomeProduto;
		int codProduto;
		Produto p = new Produto();

		switch (opcaoCliente) {
		case 1:
			System.out.println("Nome do produto: ");
			nomeProduto = scStr.nextLine();
			if (estoque.isProdutoNoEstoque(nomeProduto)) {
				p = estoque.retornaProduto(nomeProduto);

				if (p.getTipoProduto().equals(EnumProdutoTipo.UNITARIO)) {
					System.out.println("Quantidade: ");
					qtdeProduto = scInt.nextInt();
					p = estoque.retirarProdutoEstoque(nomeProduto, qtdeProduto);

					if (p != null) {
						codProduto = p.getCodProduto();

						if (isProdutoNoCarrinho(nomeProduto)) {
							int index = retornaIndexProdutoNoCarrinho(codProduto);
							this.listaProdutoDoCliente.get(index).adicionaQtdeProduto(p.getQtdeProduto());

						} else {
							this.listaProdutoDoCliente.add(p);
						}
					}
				}

				if (p.getTipoProduto().equals(EnumProdutoTipo.POR_KG)) {
					System.out.println("Peso (kg): ");
					pesoProduto = scDouble.nextDouble();
					p = estoque.retirarProdutoEstoque(nomeProduto, pesoProduto);

					if (p != null) {
						codProduto = p.getCodProduto();

						if (isProdutoNoCarrinho(nomeProduto)) {
							int index = retornaIndexProdutoNoCarrinho(codProduto);
							this.listaProdutoDoCliente.get(index).adicionaQtdeProduto(p.getQtdeProduto());

						} else {
							this.listaProdutoDoCliente.add(p);
						}
					}
				}

			} else {
				System.err.println("NÃO EXISTE O PRODUTO NO ESTOQUE." + " NÃO PODE ADICIONAR PRODUTO");
			}
			break;
		case 2:
			System.out.println("Codigo do produto: ");
			codProduto = scInt.nextInt();
			if (estoque.isProdutoNoEstoque(codProduto)) {
				p = estoque.retornaProduto(codProduto);

				if (p.getTipoProduto().equals(EnumProdutoTipo.UNITARIO)) {
					System.out.println("Quantidade: ");
					qtdeProduto = scInt.nextInt();
					p = estoque.retirarProdutoEstoque(codProduto, qtdeProduto);

					if (p != null) {
						Produto produtoCliente = new Produto(p.getNomeProduto(), p.getCodProduto(), p.getPrecoProduto(),
								0, p.getTipoProduto());
						if (isProdutoNoCarrinho(codProduto)) {
							int index = retornaIndexProdutoNoCarrinho(codProduto);
							this.listaProdutoDoCliente.get(index).adicionaQtdeProduto(qtdeProduto);

						} else {
							this.listaProdutoDoCliente.add(produtoCliente);
							int index = retornaIndexProdutoNoCarrinho(codProduto);
							this.listaProdutoDoCliente.get(index).setQtdeProduto(qtdeProduto);
						}
					}
				}

				if (p.getTipoProduto().equals(EnumProdutoTipo.POR_KG)) {
					System.out.println("Peso (kg): ");
					pesoProduto = scDouble.nextDouble();
					p = estoque.retirarProdutoEstoque(codProduto, pesoProduto);

					if (p != null) {
						Produto produtoCliente = new Produto(p.getNomeProduto(), p.getCodProduto(), p.getPrecoProduto(),
								0, p.getTipoProduto());
						if (isProdutoNoCarrinho(codProduto)) {
							int index = retornaIndexProdutoNoCarrinho(codProduto);
							this.listaProdutoDoCliente.get(index).adicionaQtdeProduto(pesoProduto);

						} else {
							this.listaProdutoDoCliente.add(produtoCliente);
							int index = retornaIndexProdutoNoCarrinho(codProduto);
							this.listaProdutoDoCliente.get(index).setPesoProduto(pesoProduto);
						}
					}
				}

			} else {
				System.err.println("NÃO EXISTE O PRODUTO NO ESTOQUE." + " NÃO PODE ADICIONAR PRODUTO");
			}
			break;
		case 3:
			System.out.println(estoque.mostraDadosProdutos());
			break;
		default:
			System.err.println("OPCAO DE COMPRA DE PRODUTO INEXISTENTE.");
		}
	}

	public void retirarProdutoDoCarrinho() {
		Scanner scInt = new Scanner(System.in);
		Scanner scDouble = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		System.out.println(
				"============    COMPRAS CLIENTE     ==========" + "\n" + "1 - Retirar produto pelo nome do produto"
						+ "\n" + "2 - Retirar produto pelo código do produto" + "\n" + "3 - Ver estoque de produtos");
		int opcaoCliente = scInt.nextInt();

		int qtdeProduto;
		double pesoProduto;
		String nomeProduto;
		int codProduto;

		Produto p = new Produto();
		switch (opcaoCliente) {
		case 1:
			System.out.println("Nome do produto: ");
			nomeProduto = scStr.nextLine();

			if (this.isProdutoNoCarrinho(nomeProduto)) {
				int index = this.retornaIndexProdutoNoCarrinho(nomeProduto);
				p = this.listaProdutoDoCliente.get(index);
				codProduto = p.getCodProduto();

				if (p.getTipoProduto().equals(EnumProdutoTipo.UNITARIO)) {
					System.out.println("Quantidade: ");
					qtdeProduto = scInt.nextInt();

					this.estoque.retornarProdutoProEstoque(nomeProduto, qtdeProduto);
					if (qtdeProduto >= p.getQtdeProduto()) {
						this.listaProdutoDoCliente.remove(p);
					} else {
						this.listaProdutoDoCliente.get(index).removeQtdeProduto(qtdeProduto);
					}
				}

				if (p.getTipoProduto().equals(EnumProdutoTipo.POR_KG)) {
					System.out.println("Peso (kg): ");
					pesoProduto = scDouble.nextDouble();

					this.estoque.retornarProdutoProEstoque(nomeProduto, pesoProduto);
					if (pesoProduto >= p.getPesoProduto()) {
						this.listaProdutoDoCliente.remove(p);
					} else {
						this.listaProdutoDoCliente.get(index).removeQtdeProduto(pesoProduto);
					}
				}

			} else {
				System.err.println(
						"PRODUTO ESCOLHIDO NÃO PODE SER RETIRADO" + " PORQUE NÃO EXISTE ESSE PRODUTO NO CARRINHO");
			}
			break;
		case 2:
			System.out.println("Codigo do produto: ");
			codProduto = scInt.nextInt();

			if (isProdutoNoCarrinho(codProduto)) {
				int index = retornaIndexProdutoNoCarrinho(codProduto);
				p = this.listaProdutoDoCliente.get(index);

				if (p.getTipoProduto().equals(EnumProdutoTipo.UNITARIO)) {
					System.out.println("Quantidade: ");
					qtdeProduto = scInt.nextInt();

					this.estoque.retornarProdutoProEstoque(codProduto, qtdeProduto);

					if (qtdeProduto >= p.getQtdeProduto()) {
						this.listaProdutoDoCliente.remove(p);
					} else {
						this.listaProdutoDoCliente.get(index).removeQtdeProduto(qtdeProduto);
					}
				}

				if (p.getTipoProduto().equals(EnumProdutoTipo.POR_KG)) {
					System.out.println("Peso: ");
					pesoProduto = scDouble.nextDouble();

					this.estoque.retornarProdutoProEstoque(codProduto, pesoProduto);

					if (pesoProduto >= p.getPesoProduto()) {
						this.listaProdutoDoCliente.remove(p);
					} else {
						this.listaProdutoDoCliente.get(index).removeQtdeProduto(pesoProduto);
					}
				}

			}
			break;
		case 3:
			System.out.println(this.estoque.mostraDadosProdutos());
			break;
		default:
			System.err.println("OPCAO DE COMPRA DE PRODUTO INEXISTENTE.");
		}

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
			if (p.getTipoProduto().equals(EnumProdutoTipo.UNITARIO)) {
				System.out.println("Produto: " + p.getNomeProduto() + "\t" + "Quantidade: " + p.getQtdeProduto());
			}
			if (p.getTipoProduto().equals(EnumProdutoTipo.POR_KG)) {
				System.out.println("Produto: " + p.getNomeProduto() + "\t" + "Peso: " + p.getPesoProduto() + "kg");
			}

		}
	}

}
