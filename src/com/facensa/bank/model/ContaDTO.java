package com.facensa.bank.model;

public class ContaDTO {

	private int conta;
	private ClienteDTO clienteDTO;
	private double saldo;

	public ContaDTO(int conta, ClienteDTO clienteDTO, double saldo) {
		this.conta = conta;
		this.clienteDTO = clienteDTO;
		this.saldo = saldo;
	}

	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	public void setClienteDTO(final ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(final int conta) {
		this.conta = conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
