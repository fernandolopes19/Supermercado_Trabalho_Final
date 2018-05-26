package model;

import java.util.ArrayList;
import java.util.Scanner;

import enums.EnumFormaPagamento;
import enums.EnumProdutoTipo;

public class Caixa {

	private int id;
	private Supermercado mercado;
	private Leitor leitor;
	private Balanca balanca;
	private Vendedor vendedor;
	private boolean isDispoivel;
	private ArrayList<Venda> vendas;

	public Caixa(int id) {
		this.balanca = new Balanca();
		this.isDispoivel = true;
		this.id = id;
		this.vendas = new ArrayList<Venda>();
	}

	public Caixa(Vendedor vendedor, Supermercado mercado, int id) {
		this.mercado = mercado;
		this.vendedor = vendedor;
		this.balanca = new Balanca();
		this.leitor = new Leitor(mercado.getEstoque());
		this.isDispoivel = true;
		this.id = id;
		this.vendas = new ArrayList<Venda>();
	}

	public void atenderCliente(Cliente cliente) {
		this.isDispoivel = false;
		double totalCompra = 0;
		boolean pagamentoFeito = false;
		Venda venda;
		ArrayList<Produto> produtosCliente = cliente.getCarrinho().getListaProdutoDoCliente();

		Scanner scInt = new Scanner(System.in);
		Scanner scDouble = new Scanner(System.in);
		for (Produto p : produtosCliente) {
			if (p.getTipoProduto() == EnumProdutoTipo.UNITARIO) {

				totalCompra += this.leitor.retornaPrecoProduto(p) * p.getQtdeProduto();
			}
			if (p.getTipoProduto() == EnumProdutoTipo.POR_KG) {
				totalCompra += this.balanca.calculaValorProdutoAPagar(p, p.getPesoProduto());
			}
		}
		System.out.println("\nTotal da compra: R$" + totalCompra);
		System.out.println("Forma de pagamento: \n1 - Dinheiro \n2 - Cartao");
		int opcao = scInt.nextInt();

		
		switch (opcao) {
		case 1:
			System.out.println("Insira o valor pago: ");
			double valorPago = scDouble.nextDouble();
			pagamentoFeito = cliente.realizaCompraDinheiro(totalCompra, valorPago);
			if (pagamentoFeito) {
				System.out.println("\nObrigado por comprar em nosso supermercado!");
				venda = new Venda(totalCompra, this.vendedor, EnumFormaPagamento.DINHEIRO);
				this.vendas.add(venda);

			} else {
				System.err.println("\nO cliente não possui dinheiro para realizar a compra.");
			}
			break;
		case 2:
			pagamentoFeito = cliente.realizarCompraCartao(totalCompra);
			if (pagamentoFeito) {
				System.out.println("\nObrigado por comprar em nosso supermercado!");
				venda = new Venda(totalCompra, this.vendedor, EnumFormaPagamento.DINHEIRO);
				this.vendas.add(venda);

			} else {
				System.err.println("\nO pagamento não foi aprovado.");
			}
			break;
		default:
			System.err.println("Opcao invalida.");
			break;
		}

		this.isDispoivel = true;
	}

	public boolean isDispoivel() {
		return isDispoivel;
	}

	public void setDispoivel(boolean isDispoivel) {
		this.isDispoivel = isDispoivel;
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
