package com.facensa.bank.model;

import java.util.List;

import junit.framework.TestCase;
 
public class ConsultaSaldoContaTeste extends TestCase {
	private ClienteDAO clienteDAO = null;

	private ContaDAO contaDAO = null;

	protected void setUp() throws Exception {
		super.setUp();
		clienteDAO = new ClienteDAO();
		ClienteDTO clienteDTO = new ClienteDTO("112", "Zé");
		clienteDAO.inserir(clienteDTO);
		contaDAO = new ContaDAO();
		ContaDTO contaDTO = new ContaDTO(9999, clienteDTO, 12);
		contaDAO.insereConta(contaDTO);
		contaDTO = new ContaDTO(6666, clienteDTO, 100);
		contaDAO.insereConta(contaDTO);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBuscaListaConta() {
		List lista = contaDAO.buscaListaConta("112");
		assertEquals(2, lista.size());
	}

}
