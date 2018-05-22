package model;

public enum EnumFormaPagamento {
    DINHEIRO(1, "DINHEIRO"),
    CARTAO(2, "CARTÃO");

    private int opcao;
    private String formaPagamento;

    private EnumFormaPagamento(int opcao, String formaPagamento) {
        this.opcao = opcao;
        this.formaPagamento = formaPagamento;
    }

    public int getOpcao() {
        return opcao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

}
