package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import enums.EnumProdutoTipo;
import model.Estoque;
import model.Produto;

public class EstoqueController {
	
	private Estoque estoque;
	private ArrayList<Produto> relatorioInicio;
	private ArrayList<Produto> relatorioFim;
	

	public EstoqueController() {
		estoque = new Estoque();
	}
	
	public Estoque inicializarEstoque() {
		Estoque est = new Estoque();
		
		Produto p1 = new Produto("Refrigerante", 1, 6.5, 10, EnumProdutoTipo.UNITARIO);
		Produto p2 = new Produto("Leite", 2, 2, 21, EnumProdutoTipo.UNITARIO);
		Produto p3 = new Produto("Carne", 3, 16.9, 10, EnumProdutoTipo.POR_KG);
		
		est.adicionaProduto(p1);
		est.adicionaProduto(p2);
		est.adicionaProduto(p3);

		this.estoque = est;
		this.gerarRelatorioInicioDia();
		return est;
	}

	public Estoque getEstoque() {
		return estoque;
	}
	
	private void gerarRelatorioInicioDia() {
		this.relatorioInicio = new ArrayList<Produto>();
		for(Produto p : this.estoque.getListaProduto()) {
			Produto newProduto = new Produto(p.getNomeProduto(), p.getCodProduto(), p.getPrecoProduto(), p.getQtdeProduto(), p.getTipoProduto());
			this.relatorioInicio.add(newProduto);
		}
	}
	
	public void gerarRelatorioFinalDia() {
		this.relatorioFim = new ArrayList<Produto>();
		for(Produto p : this.estoque.getListaProduto()) {
			Produto newProduto = new Produto(p.getNomeProduto(), p.getCodProduto(), p.getPrecoProduto(), p.getQtdeProduto(), p.getTipoProduto());
			this.relatorioFim.add(newProduto);
		}
	}
	
	public void exibirRelatorio() {
		System.out.println("\n\nRelatorio inicio do dia: ");
		for(Produto p : this.relatorioInicio) {
			System.out.println("Produto: " + p.getNomeProduto() + " / Quantidade: " + p.getQtdeProduto());
		}
		System.out.println("=============");
		System.out.println("Relatorio final do dia: ");
		if(this.relatorioFim == null) {
			this.gerarRelatorioFinalDia();
		}
		for(Produto p : this.relatorioFim) {
			System.out.println("Produto: " + p.getNomeProduto() + " / Quantidade: " + p.getQtdeProduto());
		}
	}
	

    public void encomendaProdutoNovo() {
        Scanner scStr = new Scanner(System.in);
        Scanner scDouble = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);

        System.out.println("Nome do produto: ");
        String nomeProduto = scStr.nextLine();

        if (!estoque.isProdutoNoEstoque(nomeProduto)) {
            // codProduto será 1 a mais do último
            int codProduto = estoque.getListaProduto().size() + 1;

            System.out.println("Preço do Produto: ");
            double precoProduto = scDouble.nextDouble();

            System.out.println("Quantidade do Produto Adquirido: ");
            int qtdeProduto = scInt.nextInt();
            
            EnumProdutoTipo enumTipo = EnumProdutoTipo.UNITARIO;
            System.out.println("Tipo (KG ou UN)");
            String tipo = scStr.nextLine();
            if(tipo.toUpperCase().equals("KG")) {
            	enumTipo = EnumProdutoTipo.POR_KG;
            }
            if(tipo.toUpperCase().equals("UN")) {
            	enumTipo = EnumProdutoTipo.UNITARIO;
            }

            Produto produto = new Produto(nomeProduto, codProduto, precoProduto, qtdeProduto, enumTipo);
            estoque.adicionaProduto(produto);
        }
       
    }

    public void encomendaProdutoJaExistente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do produto: ");
        String nomeProduto = sc.nextLine();
        if (this.estoque.isProdutoNoEstoque(nomeProduto)) {
            System.out.println("Quantidade do Produto Adquirido: ");
            int qtdeProduto = sc.nextInt();

            this.estoque.retornarProdutoProEstoque(nomeProduto, qtdeProduto);
        }
        sc.close();
    }
}
