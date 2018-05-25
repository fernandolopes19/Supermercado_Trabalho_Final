package model;

import java.util.ArrayList;
import java.util.Scanner;

import enums.EnumFormaPagamento;

public class Cliente extends Pessoa {

	private Carrinho carrinho;
	private double quantiaDinheiro;

	public Cliente(String nome) {
		super(nome);
	}
	
	public Cliente(String nome, double quantiaDinheiro) {
		super(nome);
		this.quantiaDinheiro = quantiaDinheiro;
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

	public boolean realizaCompraDinheiro(double valorCompra, double valorPago) {
		if(valorCompra > valorPago) {
			return false;
		} else {
			double troco = valorPago - valorCompra;
			System.out.println("Troco: " + troco);
			return true;
		}
	}
	
	public boolean realizarCompraCartao(double valorCompra) {
		return true;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public double getQuantiaDinheiro() {
		return quantiaDinheiro;
	}

	public void setQuantiaDinheiro(double quantiaDinheiro) {
		this.quantiaDinheiro = quantiaDinheiro;
	}

}
