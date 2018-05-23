package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Carrinho {

    private ArrayList<Produto> listaProdutoDoCliente;
    private Supermercado mercado;

    public Carrinho(Supermercado mercado) {
        listaProdutoDoCliente = new ArrayList<>();
        this.mercado = mercado;
    }

    public void adicionarProdutoNoCarrinho() {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.println("============    COMPRAS CLIENTE     =========="
                + "\n" + "1 - Adicionar produto pelo nome do produto"
                + "\n" + "2 - Adicionar produto pelo codigo do produto"
                + "\n" + "3 - Ver estoque de produtos");
        int opcaoCliente = scInt.nextInt();

        int qtdeProduto;
        String nomeProduto;
        int codProduto;
        
        Produto p = null;
        switch (opcaoCliente) {
            case 1:
            	System.out.println("Nome do produto: ");
            	nomeProduto = scStr.nextLine();
            	if(mercado.getEstoque().isProdutoNoEstoque(nomeProduto)) {
            		System.out.println("Quantidade: ");
            		qtdeProduto = scInt.nextInt();
            		p = mercado.retirarProdutoEstoque(nomeProduto, qtdeProduto);
            		if(p != null) {
            			this.listaProdutoDoCliente.add(p);
            			
            			codProduto = p.getCodProduto();
            			int index = retornaIndexProdutoNoCarrinho(codProduto);

            			if (isProdutoNoCarrinho(nomeProduto)) {
            				this.listaProdutoDoCliente.get(index).adicionaQtdeProduto(qtdeProduto);
            			} else {
            				this.listaProdutoDoCliente.get(index).setQtdeProduto(qtdeProduto);
            			}
            		}

            	} else {
            		System.err.println("NÃO EXISTE O PRODUTO NO ESTOQUE."
            				+ " NÃO PODE ADICIONAR PRODUTO");
            	}
                break;
            case 2:
                System.out.println("Codigo do produto: ");
                codProduto = scInt.nextInt();
                if(mercado.getEstoque().isProdutoNoEstoque(codProduto)) {
                	System.out.println("Quantidade: ");
            		qtdeProduto = scInt.nextInt();
                    p = mercado.retirarProdutoEstoque(codProduto, qtdeProduto);
                    
                	if (p != null) {
            			this.listaProdutoDoCliente.add(p);

                		int index = retornaIndexProdutoNoCarrinho(codProduto);
                		if (isProdutoNoCarrinho(codProduto)) {
                			this.listaProdutoDoCliente.get(index).adicionaQtdeProduto(qtdeProduto);
                			
                		} else {
                			this.listaProdutoDoCliente.get(index).setQtdeProduto(qtdeProduto);
                		}
                	}
                } else {
                    System.err.println("NÃO EXISTE O PRODUTO NO ESTOQUE."
                            + " NÃO PODE ADICIONAR PRODUTO");
                }
                break;
            case 3:
                System.out.println(mercado.getEstoque().mostraDadosProdutos());
                break;
            default:
                System.err.println("OPCAO DE COMPRA DE PRODUTO INEXISTENTE.");
        }
        scStr.close();
        scInt.close();

    }

    public void retirarProdutoDoCarrinho() {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.println("============    COMPRAS CLIENTE     =========="
                + "\n" + "1 - Retirar produto pelo nome do produto"
                + "\n" + "2 - Retirar produto pelo cÃ³digo do produto"
                + "\n" + "3 - Ver estoque de produtos");
        int opcaoCliente = scInt.nextInt();

        int qtdeProduto;
        String nomeProduto;
        int codProduto;
        
        Produto p = null;
        switch (opcaoCliente) {
            case 1:
                System.out.println("Nome do produto: ");
                nomeProduto = scStr.nextLine();
               
                if (this.isProdutoNoCarrinho(nomeProduto)) {
                    System.out.println("Quantidade: ");
                    qtdeProduto = scInt.nextInt();

                    this.mercado.retornarProdutoEstoque(nomeProduto, qtdeProduto);

                    codProduto = p.getCodProduto();
                    int index = this.retornaIndexProdutoNoCarrinho(codProduto);

                    if (qtdeProduto >= p.getQtdeProduto()) {
                        this.listaProdutoDoCliente.remove(p);
                    } else {
                        this.listaProdutoDoCliente.get(index).removeQtdeProduto(qtdeProduto);
                    }

                } else {
                    System.err.println("PRODUTO ESCOLHIDO NÃO PODE SER RETIRADO"
                            + " PORQUE NÃO EXISTE ESSE PRODUTO NO CARRINHO");
                }
                break;
            case 2:
                System.out.println("Codigo do produto: ");
                codProduto = scInt.nextInt();
                
                if (isProdutoNoCarrinho(codProduto)) {
                    System.out.println("Quantidade: ");
                    qtdeProduto = scInt.nextInt();

                    this.mercado.retornarProdutoEstoque(codProduto, qtdeProduto);
                    
                    int index = retornaIndexProdutoNoCarrinho(codProduto);

                    if (qtdeProduto >= p.getQtdeProduto()) {
                        this.listaProdutoDoCliente.remove(p);
                    } else {
                        this.listaProdutoDoCliente.get(index).removeQtdeProduto(qtdeProduto);
                    }
                }
                break;
            case 3:
                System.out.println(this.mercado.getEstoque().mostraDadosProdutos());
                break;
            default:
                System.err.println("OPCAO DE COMPRA DE PRODUTO INEXISTENTE.");
        }
        
        scInt.close();
        scStr.close();

    }

    public boolean isProdutoNoCarrinho(String nomeProduto) {
        Iterator it = listaProdutoDoCliente.iterator();

        boolean produtoNoCarrinho = false;
        Produto p;
        while (it.hasNext()) {
            p = (Produto) it.next();
            if (p.getNomeProduto().equals(nomeProduto)) {
                produtoNoCarrinho = true;
            }
        }

        return produtoNoCarrinho;
    }

    public boolean isProdutoNoCarrinho(int codProduto) {
        Iterator it = listaProdutoDoCliente.iterator();

        boolean produtoNoCarrinho = false;
        Produto p;
        while (it.hasNext()) {
            p = (Produto) it.next();
            if (p.getCodProduto() == codProduto) {
                produtoNoCarrinho = true;
            }
        }

        return produtoNoCarrinho;
    }

    public int retornaIndexProdutoNoCarrinho(int codProduto) {
        Iterator it = listaProdutoDoCliente.iterator();

        int indexProdutoNoCarrinho = 0;
        Produto p;
        while (it.hasNext()) {
            p = (Produto) it.next();
            if (p.getCodProduto() == codProduto) {
                indexProdutoNoCarrinho = listaProdutoDoCliente.indexOf(p);
            }
        }

        return indexProdutoNoCarrinho;
    }

    public ArrayList<Produto> getListaProdutoDoCliente() {
        return listaProdutoDoCliente;
    }
    
    public void listarProdutos() {
    	for(Produto p : this.listaProdutoDoCliente) {
    		System.out.println(p.getNomeProduto());
    	}
    }

}
