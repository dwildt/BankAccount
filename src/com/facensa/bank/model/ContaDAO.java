package com.facensa.bank.model;

import java.util.ArrayList;
import java.util.List;

import com.facensa.bank.exception.ContaExistenteException;
import com.facensa.bank.exception.SaldoInicialNegativoException;

public class ContaDAO {

	private ArrayList lista = new ArrayList();

	public void insereConta(ContaDTO contaDTO) throws ContaExistenteException,
			SaldoInicialNegativoException {
		ContaDTO buscaDTO = buscaConta(contaDTO.getConta());
		if (buscaDTO != null) {
			throw new ContaExistenteException("Conta já existente!");
		} else {
			if (contaDTO.getSaldo() <= 0) {
				throw new SaldoInicialNegativoException(
						"Saldo inserido é negativo!");
			} else
				lista.add(contaDTO);
			// TODO Validar se cliente existe.
		}

	}

	public ContaDTO buscaConta(int conta) {
		ContaDTO contaDTO = null;
		for (int i = 0; i < lista.size(); i++) {
			contaDTO = (ContaDTO) lista.get(i);
			if (contaDTO.getConta() == conta) {
				return contaDTO;
			}
		}
		return null;
	}

	public int getCount() {
		return lista.size();
	}

	public List buscaListaConta(String cpf) {
		List listaConta = new ArrayList();
		ContaDTO contaDTO = null;
		for (int i = 0; i < lista.size(); i++) {
			contaDTO = (ContaDTO) lista.get(i);
			if (contaDTO.getClienteDTO().getCpf().equals(cpf)) {
				listaConta.add(contaDTO);
			}
		}
		return listaConta;
	}
}
