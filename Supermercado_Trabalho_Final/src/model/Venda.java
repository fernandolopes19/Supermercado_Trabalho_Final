package model;

import enums.EnumFormaPagamento;

public class Venda {
	private double valor;
	private Vendedor responsavel;
	private EnumFormaPagamento formaPagamento;
	
	public Venda(double valor, Vendedor responsavel, EnumFormaPagamento formaPagamento) {
		this.valor = valor;
		this.responsavel = responsavel;
		this.formaPagamento = formaPagamento;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Vendedor getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Vendedor responsavel) {
		this.responsavel = responsavel;
	}

	public EnumFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
	
}
