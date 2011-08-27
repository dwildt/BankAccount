package com.facensa.bank.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.facensa.bank.model.LancamentoDTO;

public class LogLancamentoCsv implements LogLancamento {

	public LogLancamentoCsv() {
		super();
	}

	public void novoLancamento(LancamentoDTO lancamentoDTO) {
		File file = new File("/Users/dwildt/Code/lancamentos.csv");
		try {
			FileWriter out = new FileWriter(file,true);
			out.write(String.valueOf(lancamentoDTO.getConta()));
			out.write(";");
			out.write(String.valueOf(lancamentoDTO.getValor()));
			out.write(";");
			out.write(lancamentoDTO.getData().toString());
			out.write(";\r\n");
			out.flush();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}



}
