package com.facensa.bank.model;

import java.util.ArrayList;

import com.facensa.bank.exception.ContaInexistenteException;
import com.facensa.bank.log.LogLancamento;

public class LancamentoDAO {

	private ContaDAO contaDAO = null;

	private ArrayList lista = new ArrayList();

	private ArrayList listaNotificacao = new ArrayList();

	public LancamentoDAO() {
		super();
	}

	public void insere(LancamentoDTO lanctoDTO)
			throws ContaInexistenteException {
		ContaDTO buscaDTO = contaDAO.buscaConta(lanctoDTO.getConta());

		if (buscaDTO == null) {
			throw new ContaInexistenteException("Mensagem Inexistente");
		} else {
			buscaDTO.setSaldo(buscaDTO.getSaldo() + lanctoDTO.getValor());
			lista.add(lanctoDTO);
			notificaLancamento(lanctoDTO);
		}

	}

	private void notificaLancamento(LancamentoDTO lanctoDTO) {
		LogLancamento log=null;
		for(int i=0;i<listaNotificacao.size();i++){
			log = (LogLancamento) listaNotificacao.get(i);
			log.novoLancamento(lanctoDTO);
		}
	}

	public int getCount() {
		return lista.size();
	}

	public void setContaDAO(ContaDAO contaDAO) {
		this.contaDAO = contaDAO;
	}

	public void registraLog(LogLancamento log) {
		listaNotificacao.add(log);
	}

}
