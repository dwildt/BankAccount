package com.facensa.bank.model;

import java.util.Date;

public class LancamentoDTO {

	private int conta;
	private double valor;
	private Date data;

	public LancamentoDTO() {
		super();
	}

	public LancamentoDTO(int conta, double valor, Date data) {
		this.conta = conta;
		this.valor = valor;
		this.data = data;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
