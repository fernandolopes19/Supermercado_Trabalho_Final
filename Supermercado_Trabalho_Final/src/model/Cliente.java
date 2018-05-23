package model;

import java.util.ArrayList;
import java.util.Scanner;

import enums.EnumFormaPagamento;

public class Cliente extends Pessoa {
	
	private Carrinho carrinho;

    public Cliente(String nome) {
		super(nome);
	}

	private EnumFormaPagamento formaPagamento;

    public void consultaProdutoNoLeitor(Leitor leitor) {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.println("Consultar produto pelo Nome ou Código: "
                + "\n1 - Nome"
                + "\n2 - Codigo");
        int opcao = scInt.nextInt();
        switch(opcao){
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
    public ArrayList<Produto> realizaCompra(Estoque estoque){
        ArrayList<Produto> listaCompra = new ArrayList<>();
        return listaCompra;
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
