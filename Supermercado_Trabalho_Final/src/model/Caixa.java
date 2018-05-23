package model;

public class Caixa {
    
	Supermercado mercado;
	Leitor leitor;
    Balanca balanca;
    Funcionario vendedor;

    public Caixa() {
        balanca = new Balanca();
    }

    public Caixa(Funcionario vendedor, Supermercado mercado) {
    	this.mercado = mercado;
        this.vendedor = vendedor;
        this.balanca = new Balanca();
        this.leitor = new Leitor(mercado.getEstoque());
    }
    
    public void atenderCliente(Cliente cliente){
        
    }
    
}
