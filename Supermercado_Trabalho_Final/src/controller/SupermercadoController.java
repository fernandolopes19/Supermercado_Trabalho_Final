package controller;

import java.util.ArrayList;

import model.Caixa;
import model.Estoque;
import model.Funcionario;
import model.Gerente;
import model.Leitor;
import model.Supermercado;

public class SupermercadoController {
	private ArrayList<Supermercado> supermercados = new ArrayList<Supermercado>();
	
	public SupermercadoController() {
	}

	public Supermercado inicializarSupermercado(String nome, Estoque estoque) {
				
		Supermercado mercado = new Supermercado(nome);
		mercado.registrarEstoque(estoque);
		
		Funcionario f1 = new Funcionario("Funcionario 01", 1);
		Funcionario f2 = new Funcionario("Funcionario 02", 2);
		Funcionario f3 = new Funcionario("Funcionario 03", 3);
		Funcionario f4 = new Funcionario("Funcionario 04", 4);
		Funcionario f5 = new Funcionario("Funcionario 05", 5);
		Gerente g1 = new Gerente("Gerente", 6, "Comercial");
		
		mercado.addFuncionario(f1);
		mercado.addFuncionario(f2);
		mercado.addFuncionario(f3);
		mercado.addFuncionario(f4);
		mercado.addFuncionario(f5);
		mercado.addFuncionario(g1);
		
		//Caixa c1 = new Caixa(f1, mercado);
		//Caixa c2 = new Caixa(f2, mercado);
		//Caixa c3 = new Caixa(f3, mercado);

		mercado.registrarCaixa(new Caixa(f1, mercado));
		mercado.registrarCaixa(new Caixa(f2, mercado));
		mercado.registrarCaixa(new Caixa(f3, mercado));

		return mercado;
	}
}
