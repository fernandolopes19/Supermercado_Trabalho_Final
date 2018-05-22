package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Carrinho {

    private ArrayList<Produto> listaProdutoDoCliente;
    Estoque estoque;

    public Carrinho(Estoque estoque) {
        listaProdutoDoCliente = new ArrayList<>();
        this.estoque = estoque;
    }

    public void adicionarProdutoNoCarrinho() {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.println("============    COMPRAS CLIENTE     =========="
                + "\n" + "1 - Adicionar produto pelo nome do produto"
                + "\n" + "2 - Adicionar produto pelo código do produto"
                + "\n" + "3 - Ver estoque de produtos");
        int opcaoCliente = scInt.nextInt();

        int qtdeProduto;
        String nomeProduto;
        int codProduto;
        switch (opcaoCliente) {
            case 1:
                System.out.println("Nome do produto: ");
                nomeProduto = scStr.nextLine();
                if (estoque.isProdutoNoEstoque(nomeProduto)) {
                    System.out.println("Quantidade: ");
                    qtdeProduto = scInt.nextInt();

                    Produto p = estoque.retornaProduto(nomeProduto);
                    codProduto = p.getCodProduto();
                    int index = retornaIndexProdutoNoCarrinho(codProduto);

                    if (isProdutoNoCarrinho(nomeProduto)) {
                        listaProdutoDoCliente.get(index).adicionaQtdeProduto(qtdeProduto);
                    } else {
                        listaProdutoDoCliente.get(index).setQtdeProduto(qtdeProduto);
                    }
                } else {
                    System.err.println("NÃO EXISTE O PRODUTO NO ESTOQUE."
                            + " NÃO PODE ADICIONAR PRODUTO");
                }
                break;
            case 2:
                System.out.println("Código do produto: ");
                codProduto = scInt.nextInt();
                if (estoque.isProdutoNoEstoque(codProduto)) {
                    System.out.println("Quantidade: ");
                    qtdeProduto = scInt.nextInt();

                    int index = retornaIndexProdutoNoCarrinho(codProduto);

                    if (isProdutoNoCarrinho(codProduto)) {
                        listaProdutoDoCliente.get(index).adicionaQtdeProduto(qtdeProduto);
                    } else {
                        listaProdutoDoCliente.get(index).setQtdeProduto(qtdeProduto);
                    }
                } else {
                    System.err.println("NÃO EXISTE O PRODUTO NO ESTOQUE."
                            + " NÃO PODE ADICIONAR PRODUTO");
                }
                break;
            case 3:
                System.out.println(estoque.mostraDadosProdutos());
                break;
            default:
                System.err.println("OPÇÃO DE COMPRA DE PRODUTO INEXISTENTE.");
        }

    }

    public void retirarProdutoDoCarrinho() {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.println("============    COMPRAS CLIENTE     =========="
                + "\n" + "1 - Retirar produto pelo nome do produto"
                + "\n" + "2 - Retirar produto pelo código do produto"
                + "\n" + "3 - Ver estoque de produtos");
        int opcaoCliente = scInt.nextInt();

        int qtdeProduto;
        String nomeProduto;
        int codProduto;
        switch (opcaoCliente) {
            case 1:
                System.out.println("Nome do produto: ");
                nomeProduto = scStr.nextLine();
                if (isProdutoNoCarrinho(nomeProduto)) {
                    System.out.println("Quantidade: ");
                    qtdeProduto = scInt.nextInt();

                    Produto p = estoque.retornaProduto(nomeProduto);
                    codProduto = p.getCodProduto();
                    int index = retornaIndexProdutoNoCarrinho(codProduto);

                    if (qtdeProduto >= p.getQtdeProduto()) {
                        listaProdutoDoCliente.remove(p);
                    } else {
                        listaProdutoDoCliente.get(index).removeQtdeProduto(qtdeProduto);
                    }

                } else {
                    System.err.println("PRODUTO ESCOLHIDO NÃO PODE SER RETIRADO"
                            + " PORQUE NÃO EXISTE ESSE PRODUTO NO CARRINHO");
                }
                break;
            case 2:
                System.out.println("Código do produto: ");
                codProduto = scInt.nextInt();
                if (isProdutoNoCarrinho(codProduto)) {
                    System.out.println("Quantidade: ");
                    qtdeProduto = scInt.nextInt();

                    Produto p = estoque.retornaProduto(codProduto);
                    int index = retornaIndexProdutoNoCarrinho(codProduto);

                    if (qtdeProduto >= p.getQtdeProduto()) {
                        listaProdutoDoCliente.remove(p);
                    } else {
                        listaProdutoDoCliente.get(index).removeQtdeProduto(qtdeProduto);
                    }
                }
                break;
            case 3:
                System.out.println(estoque.mostraDadosProdutos());
                break;
            default:
                System.err.println("OPÇÃO DE COMPRA DE PRODUTO INEXISTENTE.");
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

    public ArrayList<Produto> getListaProdutoDoCliente() {
        return listaProdutoDoCliente;
    }

}
