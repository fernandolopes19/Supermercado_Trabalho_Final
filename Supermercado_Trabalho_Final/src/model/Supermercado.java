package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

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
    
    public void registrarEstoque(Estoque estoque) {
    	this.estoque = estoque;
    }

    public void encomendaProdutoNovo() {
        Scanner scStr = new Scanner(System.in);
        Scanner scDouble = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);

        System.out.println("Nome do produto: ");
        String nomeProduto = scStr.nextLine();

        if (!estoque.isProdutoNoEstoque(nomeProduto)) {
            // codProduto será 1 a mais do último
            int listaTamanho = estoque.getListaProduto().size();
            int codProduto = estoque.getListaProduto().get(listaTamanho).getCodProduto() + 1;

            System.out.println("Preço do Produto: ");
            double precoProduto = scDouble.nextDouble();

            System.out.println("Quantidade do Produto Adquirido: ");
            int qtdeProduto = scInt.nextInt();

            Produto produto = new Produto(nomeProduto, codProduto, precoProduto, qtdeProduto);
            estoque.adicionaProduto(produto);
        }
        
        scStr.close();
        scDouble.close();
        scInt.close();
    }

    public void encomendaProdutoJaExistente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do produto: ");
        String nomeProduto = sc.nextLine();
        if (this.estoque.isProdutoNoEstoque(nomeProduto)) {
            Produto produto = this.estoque.retornaProduto(nomeProduto);

            System.out.println("Quantidade do Produto Adquirido: ");
            int qtdeProduto = sc.nextInt();

            int indexProduto = this.estoque.getListaProduto().indexOf(produto);
            this.estoque.getListaProduto().get(indexProduto).adicionaQtdeProduto(qtdeProduto);
        }
        sc.close();
    }
    
    public Produto retirarProdutoEstoque(String nomeProduto, int qtdeProduto) {
    	Produto produto = this.estoque.retornaProduto(nomeProduto);

    	int indexProduto = this.estoque.getListaProduto().indexOf(produto);
    	this.estoque.getListaProduto().get(indexProduto).removeQtdeProduto(qtdeProduto);
    	
    	return produto;
    }
    
    public Produto retirarProdutoEstoque(int codigo, int qtdeProduto) {
    	Produto produto = this.estoque.retornaProduto(codigo);

    	int indexProduto = this.estoque.getListaProduto().indexOf(produto);
    	this.estoque.getListaProduto().get(indexProduto).removeQtdeProduto(qtdeProduto);
    	
    	return produto;
    }
    
    public boolean retornarProdutoEstoque(String nomeProduto, int qtdeProduto) {  
         if (this.estoque.isProdutoNoEstoque(nomeProduto)) {        	 
             Produto produto = this.estoque.retornaProduto(nomeProduto);

             int indexProduto = this.estoque.getListaProduto().indexOf(produto);
             this.estoque.getListaProduto().get(indexProduto).adicionaQtdeProduto(qtdeProduto);
             
             return true;
         }
         
         return false;
    }
    
    public boolean retornarProdutoEstoque(int codigo, int qtdeProduto) {
    	if (this.estoque.isProdutoNoEstoque(codigo)) {
        	
    		Produto produto = this.estoque.retornaProduto(codigo);
            
    		int indexProduto = this.estoque.getListaProduto().indexOf(produto);
    		this.estoque.getListaProduto().get(indexProduto).adicionaQtdeProduto(qtdeProduto);
    
    		return true;
    	}
    	
    	return false;
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
