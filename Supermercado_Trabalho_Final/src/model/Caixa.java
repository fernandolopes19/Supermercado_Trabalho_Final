package model;

public class Caixa {
    
    Balanca balanca;
    Vendedor vendedor;

    public Caixa() {
        balanca = new Balanca();
    }

    public Caixa(Vendedor vendedor) {
        this.vendedor = vendedor;
        balanca = new Balanca();
    }
    
    public void atenderCliente(Cliente cliente){
        
    }
    
}
