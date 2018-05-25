package model;

import enums.EnumProdutoTipo;

public class Produto {

    private String nomeProduto;
    private int codProduto;
    private double precoProduto;
    private int qtdeProduto;
    private EnumProdutoTipo tipoProduto;

    public Produto() {
    	
    }
    
    public Produto(String nomeProduto, int codProduto, double precoProduto, int qtdeProdutoEstoque, EnumProdutoTipo tipo) {
        this.nomeProduto = nomeProduto;
        this.codProduto = codProduto;
        this.precoProduto = precoProduto;
        this.qtdeProduto = qtdeProdutoEstoque;
        this.tipoProduto = tipo;
    }

    public void adicionaQtdeProduto(int qtdeProdutoAdicionada) {
        this.qtdeProduto += qtdeProdutoAdicionada;
    }

    public void removeQtdeProduto(int qtdeProdutoAdicionada) {
        this.qtdeProduto -= qtdeProdutoAdicionada;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(int qtdeProdutoEstoque) {
        this.qtdeProduto = qtdeProdutoEstoque;
    }

    public EnumProdutoTipo getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(EnumProdutoTipo tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}
