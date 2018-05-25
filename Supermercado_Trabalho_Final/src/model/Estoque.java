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
        Iterator<Produto> it = listaProduto.iterator();

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
                if(p.getQtdeProduto() > 0) {
                	produto = p;
                }
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
            	if(p.getQtdeProduto() > 0) {
                    produto = p;	
            	}
            }
        }

        return produto;
    }
    
    public Produto retirarProdutoEstoque(String nomeProduto, int qtdeProduto) {
    	Produto produto = this.retornaProduto(nomeProduto);

    	int indexProduto = this.getListaProduto().indexOf(produto);
    	this.getListaProduto().get(indexProduto).removeQtdeProduto(qtdeProduto);
    	
    	return produto;
    }
    
    public Produto retirarProdutoEstoque(int codigo, int qtdeProduto) {
    	Produto produto = this.retornaProduto(codigo);

    	int indexProduto = this.getListaProduto().indexOf(produto);
    	this.getListaProduto().get(indexProduto).removeQtdeProduto(qtdeProduto);
    	
    	return produto;
    }
    
    public boolean retornarProdutoProEstoque(String nomeProduto, int qtdeProduto) {  
        if (this.isProdutoNoEstoque(nomeProduto)) {        	 
            Produto produto = this.retornaProduto(nomeProduto);

            int indexProduto = this.getListaProduto().indexOf(produto);
            this.getListaProduto().get(indexProduto).adicionaQtdeProduto(qtdeProduto);
            
            return true;
        }
        
        return false;
   }
   
   public boolean retornarProdutoProEstoque(int codigo, int qtdeProduto) {
   	if (this.isProdutoNoEstoque(codigo)) {
       	
   		Produto produto = this.retornaProduto(codigo);
           
   		int indexProduto = this.getListaProduto().indexOf(produto);
   		this.getListaProduto().get(indexProduto).adicionaQtdeProduto(qtdeProduto);
   
   		return true;
   	}
   	
   	return false;
   }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

}
