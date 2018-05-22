package model;

public class Leitor {

    Estoque estoque;

    public Leitor(Estoque estoque) {
        this.estoque = estoque;
    }

    public void atualizaEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public void verificaPrecoProduto(String nomeProduto) {
        if (estoque.isProdutoNoEstoque(nomeProduto)) {
            Produto produto = estoque.retornaProduto(nomeProduto);
            System.out.println("Nome do produto: " + produto.getNomeProduto()
                    + "\t" + "Código: " + produto.getCodProduto()
                    + "\t" + "Preço: " + produto.getPrecoProduto());
        } else {
            System.err.println("PRODUTO INEXISTENTE.");
        }
    }

    public void verificaPrecoProduto(int codProduto) {
        if (estoque.isProdutoNoEstoque(codProduto)) {
            Produto produto = estoque.retornaProduto(codProduto);
            System.out.println("Nome do produto: " + produto.getNomeProduto()
                    + "\t" + "Código: " + produto.getCodProduto()
                    + "\t" + "Preço: " + produto.getPrecoProduto());
        } else {
            System.err.println("PRODUTO INEXISTENTE.");
        }
    }

}
