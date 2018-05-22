package model;

import java.util.ArrayList;
import java.util.Iterator;

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
        Iterator it = listaProduto.iterator();

        String dadosProdutos = "";
        Produto p;
        while (it.hasNext()) {
            p = (Produto) it.next();
            dadosProdutos += "\n============="
                    + "\nNome: " + p.getNomeProduto()
                    + "\t" + "Código:" + p.getCodProduto()
                    + "\t" + "Preço: R$" + p.getPrecoProduto()
                    + "\t" + "Quantidade Estoque: " + p.getQtdeProduto();
        }

        return dadosProdutos;
    }

    public boolean isProdutoNoEstoque(String nomeProduto) {
        Iterator it = listaProduto.iterator();

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
        Iterator it = listaProduto.iterator();

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
        Iterator it = listaProduto.iterator();

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
        Iterator it = listaProduto.iterator();

        Produto p, produto = null;
        while (it.hasNext()) {
            p = (Produto) it.next();
            if (p.getCodProduto() == codProduto) {
                produto = p;
            }
        }

        return produto;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

}
