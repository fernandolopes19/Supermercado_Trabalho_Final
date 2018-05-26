package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

import enums.EnumProdutoTipo;

public class Supermercado {

    private String nomeSupermercado;
    private ArrayList<Funcionario> listaFuncionarios;
    private ArrayList<Leitor> listaLeitores;
    private ArrayList<Caixa> listaCaixas;
    private Estoque estoque;

    public Supermercado(String nomeSupermercado) {
        this.nomeSupermercado = nomeSupermercado;
        this.listaFuncionarios = new ArrayList<>(6);
        this.listaCaixas = new ArrayList<>(3);
        this.listaLeitores = new ArrayList<>();
    }
    
    public void registrarLeitor(Leitor leitor) {
    	this.listaLeitores.add(leitor);
    }
    
    public void registrarCaixa(Caixa caixa) {
    	this.listaCaixas.add(caixa);
    }
    
    public void addFuncionario(Funcionario funcionario) {
    	this.listaFuncionarios.add(funcionario);
    }
    
    public void removerFuncionario(Funcionario funcionario) {
    	this.listaFuncionarios.remove(funcionario);
    }
    
    public void removerFuncionario(int codigo) {
    	Predicate<Funcionario> funcPredicate = f -> f.getIdFuncionario() == codigo;
    	this.listaFuncionarios.removeIf(funcPredicate);
    }
    
    public ArrayList<Funcionario> getFuncionarios() {
    	return this.listaFuncionarios;
    }
    
    public void registrarEstoque(Estoque estoque) {
    	this.estoque = estoque;
    }
    
    public void consultarProdutoLeitor(int codigo) {
    	try {
        	this.listaLeitores.get(0).verificaPrecoProduto(codigo);
    	} catch (Exception e) {
			System.out.println("Não há leitores disponíveis");
		}
    }
    
    public Caixa retornaCaixaDisponivel() {
    	for(Caixa c : this.listaCaixas) {
    		if(c.isDispoivel()) {
    			return c;
    		}
    	}
		return null;
    }
    
	public ArrayList<Caixa> getListaCaixas() {
		return listaCaixas;
	}

	public String getNomeSupermercado() {
		return nomeSupermercado;
	}

	public void setNomeSupermercado(String nomeSupermercado) {
		this.nomeSupermercado = nomeSupermercado;
	}
	
	public Estoque getEstoque() {
		return this.estoque;
	}

}
