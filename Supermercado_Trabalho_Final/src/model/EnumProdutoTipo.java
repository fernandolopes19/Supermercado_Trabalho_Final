package model;

public enum EnumProdutoTipo {
    UNITARIO(1), POR_KG(2);

    private int opcaoProdutoTipo;

    private EnumProdutoTipo(int opcaoProdutoTipo) {
        this.opcaoProdutoTipo = opcaoProdutoTipo;
    }

    public int getOpcaoProdutoTipo() {
        return opcaoProdutoTipo;
    }

}
