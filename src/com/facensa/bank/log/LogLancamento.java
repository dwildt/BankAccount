package com.facensa.bank.log;

import com.facensa.bank.model.LancamentoDTO;

public interface LogLancamento {
	//Todo método de interface é público e abstrato
	public abstract void novoLancamento(LancamentoDTO lancamentoDTO);
	
}
