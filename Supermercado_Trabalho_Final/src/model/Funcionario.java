package model;

public class Funcionario extends Pessoa {

    private int idFuncionario;

    public Funcionario(String nome, int idFuncionario) {
    	super(nome);
    	this.idFuncionario = idFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int id) {
        this.idFuncionario = id;
    }

}
