package model;

import java.util.ArrayList;
import java.util.Scanner;

import enums.EnumFormaPagamento;

public class Cliente extends Pessoa {

	private EnumFormaPagamento formaPagamento;
	private ArrayList<Produto> listaProdutos;
	private Carrinho carrinho;

	public Cliente(String nome) {
		super(nome);
		listaProdutos = new ArrayList<>();
	}

	public void consultaProdutoNoLeitor(Leitor leitor) {
		Scanner scInt = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		System.out.println("Consultar produto pelo Nome ou Código: " + "\n1 - Nome" + "\n2 - Código");
		int opcao = scInt.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Nome do produto: ");
			String nomeProduto = scStr.nextLine();
			leitor.verificaPrecoProduto(nomeProduto);
			break;
		case 2:
			System.out.println("Código do produto: ");
			int codProduto = scInt.nextInt();
			leitor.verificaPrecoProduto(codProduto);
			break;
		default:
			System.err.println("OPCAO DE CONSULTA DE PRODUTO INEXISTENTE");
		}
		scInt.close();
		scStr.close();
	}

	// TERMINAR
	public void realizaCompra(Supermercado mercado) {
	}

	public ArrayList<Produto> terminaCompra() {
		return listaProdutos;
	}

	public EnumFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

}
