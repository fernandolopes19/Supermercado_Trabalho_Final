package model;

import java.util.ArrayList;
import java.util.Iterator;

import enums.EnumProdutoTipo;

public class Estoque {

	private ArrayList<Produto> listaProduto;

	public Estoque() {
		listaProduto = new ArrayList<>();
	}

	public void adicionaProduto(Produto produto) {
		listaProduto.add(produto);
	}

	public void removeProduto(Produto produto) {
		listaProduto.remove(produto);
	}

	public String mostraDadosProdutos() {
		Iterator<Produto> it = listaProduto.iterator();

		String dadosProdutos = "";
		Produto p;
		while (it.hasNext()) {
			p = (Produto) it.next();
			if (p.getTipoProduto().equals(EnumProdutoTipo.UNITARIO)) {
				dadosProdutos += "\n=============" + "\nNome: " + p.getNomeProduto() + "\t" + "Código:"
						+ p.getCodProduto() + "\t" + "Preço: R$" + p.getPrecoProduto() + "\t" + "Quantidade Estoque: "
						+ p.getQtdeProduto();
			}
			if (p.getTipoProduto().equals(EnumProdutoTipo.POR_KG)) {
				dadosProdutos += "\n=============" + "\nNome: " + p.getNomeProduto() + "\t" + "Código:"
						+ p.getCodProduto() + "\t" + "Preço: R$" + p.getPrecoProduto() + "\t" + "Peso Estoque: "
						+ p.getPesoProduto() + "kg";
			}

		}

		return dadosProdutos;
	}

	public boolean isProdutoNoEstoque(String nomeProduto) {
		Iterator<Produto> it = listaProduto.iterator();

		boolean produtoNoEstoque = false;
		Produto p;
		while (it.hasNext()) {
			p = (Produto) it.next();
			if (p.getNomeProduto().equals(nomeProduto)) {
				produtoNoEstoque = true;
			}
		}

		return produtoNoEstoque;
	}

	public boolean isProdutoNoEstoque(int codProduto) {
		Iterator<Produto> it = listaProduto.iterator();

		boolean produtoNoEstoque = false;
		Produto p;
		while (it.hasNext()) {
			p = (Produto) it.next();
			if (p.getCodProduto() == codProduto) {
				produtoNoEstoque = true;
			}
		}

		return produtoNoEstoque;
	}

	public Produto retornaProduto(String nomeProduto) {
		Iterator<Produto> it = listaProduto.iterator();

		Produto p, produto = null;
		while (it.hasNext()) {
			p = (Produto) it.next();
			if (p.getNomeProduto().equals(nomeProduto)) {
				produto = p;
			}
		}

		return produto;
	}

	public Produto retornaProduto(int codProduto) {
		Iterator<Produto> it = listaProduto.iterator();

		Produto p, produto = null;
		while (it.hasNext()) {
			p = (Produto) it.next();
			if (p.getCodProduto() == codProduto) {
				produto = p;
			}
		}

		return produto;
	}

	/**
	 * Retira o produto do estoque com base no NOME e QUANTIDADE (Unidades) do
	 * produto
	 * 
	 * @param nomeProduto
	 * @param qtdeProduto
	 * @return
	 */
	public Produto retirarProdutoEstoque(String nomeProduto, int qtdeProduto) {
		Produto produto = this.retornaProduto(nomeProduto);
		Produto produtoCliente = null;
		if(produto != null) {
			int indexProduto = this.getListaProduto().indexOf(produto);
			if(produto.getTipoProduto() == EnumProdutoTipo.UNITARIO) {
				if(produto.getQtdeProduto() < qtdeProduto) {
					qtdeProduto = produto.getQtdeProduto();
					this.getListaProduto().get(indexProduto).removeQtdeProduto(produto.getQtdeProduto());
				} else {
					this.getListaProduto().get(indexProduto).removeQtdeProduto(qtdeProduto);
				}
			} 
			produtoCliente = new Produto(produto.getNomeProduto(), produto.getCodProduto(), produto.getPrecoProduto(), qtdeProduto, produto.getTipoProduto());
		}

		return produtoCliente;
	}

	/**
	 * Retira o produto do estoque com base no NOME e PESO (Kg) do produto
	 * 
	 * @param nomeProduto
	 * @param pesoProduto
	 * @return
	 */
	public Produto retirarProdutoEstoque(String nomeProduto, double pesoProduto) {
		Produto produto = this.retornaProduto(nomeProduto);
		Produto produtoCliente = null;
		
		if(produto != null) {
			int indexProduto = this.getListaProduto().indexOf(produto);
			if(produto.getTipoProduto() == EnumProdutoTipo.POR_KG) {
				if(produto.getPesoProduto() < pesoProduto) {
					pesoProduto = produto.getPesoProduto();
					this.getListaProduto().get(indexProduto).removeQtdeProduto(produto.getPesoProduto());
				} else {
					this.getListaProduto().get(indexProduto).removeQtdeProduto(pesoProduto);
				}
			}
			produtoCliente = new Produto(produto.getNomeProduto(), produto.getCodProduto(), produto.getPrecoProduto(), pesoProduto, produto.getTipoProduto());
		}

		return produtoCliente;
	}

	/**
	 * Retira o produto do estoque com base no CÓDIGO e QUANTIDADE (Unidade) do
	 * produto
	 * 
	 * @param codigo
	 * @param qtdeProduto
	 * @return
	 */
	public Produto retirarProdutoEstoque(int codigo, int qtdeProduto) {
		Produto produto = this.retornaProduto(codigo);
		Produto produtoCliente = null;

		if(produto != null) {
			int indexProduto = this.getListaProduto().indexOf(produto);
			if(produto.getTipoProduto() == EnumProdutoTipo.UNITARIO) {
				if(produto.getQtdeProduto() < qtdeProduto) {
					qtdeProduto = produto.getQtdeProduto();
					this.getListaProduto().get(indexProduto).removeQtdeProduto(produto.getQtdeProduto());
				} else {
					this.getListaProduto().get(indexProduto).removeQtdeProduto(qtdeProduto);
				}
			}
			produtoCliente = new Produto(produto.getNomeProduto(), produto.getCodProduto(), produto.getPrecoProduto(), qtdeProduto, produto.getTipoProduto());
		}

		return produtoCliente;
	}

	/**
	 * Retira o produto do estoque com base no CÓDIGO e PESO (kg) do produto
	 * 
	 * @param codigo
	 * @param pesoProduto
	 * @return
	 */
	public Produto retirarProdutoEstoque(int codigo, double pesoProduto) {
		Produto produto = this.retornaProduto(codigo);
		Produto produtoCliente = null;

		if(produto != null) {
			int indexProduto = this.getListaProduto().indexOf(produto);
			if(produto.getTipoProduto() == EnumProdutoTipo.POR_KG) {
				if(produto.getPesoProduto() < pesoProduto) {
					pesoProduto = produto.getPesoProduto();
					this.getListaProduto().get(indexProduto).removeQtdeProduto(produto.getPesoProduto());
				} else {
					this.getListaProduto().get(indexProduto).removeQtdeProduto(pesoProduto);
				}
			}
			produtoCliente = new Produto(produto.getNomeProduto(), produto.getCodProduto(), produto.getPrecoProduto(), pesoProduto, produto.getTipoProduto());
		}

		return produto;
	}

	/**
	 * Retorna o produto para o estoque com base no NOME e QUANTIDADE (Unidades)
	 * do produto
	 * 
	 * @param nomeProduto
	 * @param qtdeProduto
	 * @return
	 */
	public boolean retornarProdutoProEstoque(String nomeProduto, int qtdeProduto) {
		if (this.isProdutoNoEstoque(nomeProduto)) {
			Produto produto = this.retornaProduto(nomeProduto);

			int indexProduto = this.getListaProduto().indexOf(produto);
			this.getListaProduto().get(indexProduto).adicionaQtdeProduto(qtdeProduto);

			return true;
		}

		return false;
	}

	/**
	 * Retorna o produto para o estoque com base no NOME e PESO (Kg) do produto
	 * 
	 * @param nomeProduto
	 * @param pesoProduto
	 * @return
	 */
	public boolean retornarProdutoProEstoque(String nomeProduto, double pesoProduto) {
		if (this.isProdutoNoEstoque(nomeProduto)) {
			Produto produto = this.retornaProduto(nomeProduto);

			int indexProduto = this.getListaProduto().indexOf(produto);
			this.getListaProduto().get(indexProduto).adicionaQtdeProduto(pesoProduto);

			return true;
		}

		return false;
	}

	/**
	 * Retorna o produto para o estoque com base no CÓDIGO e QUANTIDADE
	 * (Unidades) do produto
	 * 
	 * @param codigo
	 * @param qtdeProduto
	 * @return
	 */
	public boolean retornarProdutoProEstoque(int codigo, int qtdeProduto) {
		if (this.isProdutoNoEstoque(codigo)) {

			Produto produto = this.retornaProduto(codigo);

			int indexProduto = this.getListaProduto().indexOf(produto);
			this.getListaProduto().get(indexProduto).adicionaQtdeProduto(qtdeProduto);

			return true;
		}

		return false;
	}

	/**
	 * Retorna o produto para o estoque com base no CÓDIGO e PESO (Kg) do
	 * produto
	 * 
	 * @param codigo
	 * @param pesoProduto
	 * @return
	 */
	public boolean retornarProdutoProEstoque(int codigo, double pesoProduto) {
		if (this.isProdutoNoEstoque(codigo)) {

			Produto produto = this.retornaProduto(codigo);

			int indexProduto = this.getListaProduto().indexOf(produto);
			this.getListaProduto().get(indexProduto).adicionaQtdeProduto(pesoProduto);

			return true;
		}

		return false;
	}

	public ArrayList<Produto> getListaProduto() {
		return listaProduto;
	}

}
