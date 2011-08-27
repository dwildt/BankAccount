package com.facensa.bank.log;

import com.facensa.bank.model.LancamentoDTO;

public class LogLancamentoConsole implements LogLancamento {

	public LogLancamentoConsole() {
		super();
	}

	public void novoLancamento(LancamentoDTO lancamentoDTO) {
		System.out.println(lancamentoDTO.getConta());
		System.out.println(lancamentoDTO.getValor());
		System.out.println("*******************************");
	}



}
