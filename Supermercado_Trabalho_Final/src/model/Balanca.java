package model;

public class Balanca {

    public double calculaValorProdutoAPagar(Produto p, double peso) {
        return peso * p.getQtdeProduto();
    }
}
