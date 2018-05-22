package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado {

    private String nomeSupermercado;
    private ArrayList<Pessoa> listaFuncionarios;
    private ArrayList<Leitor> listaLeitores;
    private ArrayList<Caixa> listaCaixas;
    private Estoque estoque;

    public Supermercado(String nomeSupermercado) {
        this.nomeSupermercado = nomeSupermercado;
        this.listaFuncionarios = new ArrayList<>(6);
        this.listaCaixas = new ArrayList<>(3);
        this.listaLeitores = new ArrayList<>();
    }

    public void encomendaProdutoNovo() {
        Scanner scStr = new Scanner(System.in);
        Scanner scDouble = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);

        System.out.println("Nome do produto: ");
        String nomeProduto = scStr.nextLine();

        if (!estoque.isProdutoNoEstoque(nomeProduto)) {
            // codProduto será 1 a mais do último
            int listaTamanho = estoque.getListaProduto().size();
            int codProduto = estoque.getListaProduto().get(listaTamanho).getCodProduto() + 1;

            System.out.println("Preço do Produto: ");
            double precoProduto = scDouble.nextDouble();

            System.out.println("Quantidade do Produto Adquirido: ");
            int qtdeProduto = scInt.nextInt();

            Produto produto = new Produto(nomeProduto, codProduto, precoProduto, qtdeProduto);
            estoque.adicionaProduto(produto);
        }
    }

    public void encomendaProdutoJaExistente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do produto: ");
        String nomeProduto = sc.nextLine();
        if (estoque.isProdutoNoEstoque(nomeProduto)) {
            Produto produto = estoque.retornaProduto(nomeProduto);

            System.out.println("Quantidade do Produto Adquirido: ");
            int qtdeProduto = sc.nextInt();

            int indexProduto = estoque.getListaProduto().indexOf(produto);
            estoque.getListaProduto().get(indexProduto).adicionaQtdeProduto(qtdeProduto);
        }
    }

}
