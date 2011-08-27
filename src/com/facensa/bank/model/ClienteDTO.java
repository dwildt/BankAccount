package com.facensa.bank.model;

public class ClienteDTO {

	private String cpf;
	private String nome;
        private int yearsAsCustomer;

        public ClienteDTO() {
                this.cpf = "";
                this.nome = "";
        }

	public ClienteDTO(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public int getYearsAsCustomer() {
        return yearsAsCustomer;
    }

    public void setYearsAsCustomer(int yearsAsCustomer) {
        this.yearsAsCustomer = yearsAsCustomer;
    }

    
}
