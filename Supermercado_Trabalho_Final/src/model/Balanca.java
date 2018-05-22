package model;

public class Balanca {

    private double precoProduto;
    private double pesoProduto;

    public double calculaValorProdutoAPagar() {
        return precoProduto * pesoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public void setPesoProduto(double pesoProduto) {
        this.pesoProduto = pesoProduto;
    }

}
