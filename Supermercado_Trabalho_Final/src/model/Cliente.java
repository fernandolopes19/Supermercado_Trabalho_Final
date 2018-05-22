package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Pessoa {

    private EnumFormaPagamento formaPagamento;

    public void consultaProdutoNoLeitor(Leitor leitor) {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.println("Consultar produto pelo Nome ou Código: "
                + "\n1 - Nome"
                + "\n2 - Códiigo");
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
                System.err.println("OPÇÃO DE CONSULTA DE PRODUTO INEXISTENTE");
        }
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

}
