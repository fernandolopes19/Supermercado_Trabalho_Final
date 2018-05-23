package model;

public class Leitor {

	private Estoque estoque;
	
    public Leitor(Estoque est) {
    	this.estoque = est;
    }
    
    public void atualizaEstoqueDoLeitor(Estoque estoque){
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
                    + "\t" + "Cdigo: " + produto.getCodProduto()
                    + "\t" + "Preço: " + produto.getPrecoProduto());
        } else {
            System.err.println("PRODUTO INEXISTENTE.");
        }
    }

}
