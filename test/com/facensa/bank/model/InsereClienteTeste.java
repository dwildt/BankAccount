package com.facensa.bank.model;

import junit.framework.TestCase;

public class InsereClienteTeste extends TestCase {
	private ClienteDAO clienteDAO = null;

	protected void setUp() throws Exception {
        super.setUp();
		clienteDAO = new ClienteDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEdicaoCliente() {

		try {
			ClienteDTO clienteDTO = new ClienteDTO("123", "Juliano");
			clienteDAO.inserir(clienteDTO);
			clienteDTO = clienteDAO.buscaCliente("123");
			assertNotNull(clienteDTO);
			clienteDTO.setNome("Beto");
			clienteDAO.inserir(clienteDTO);
			assertEquals(1, clienteDAO.getCount());
		} catch (Exception e) {
			fail();
		}
	}

	public void testInclusaoCliente() {
		ClienteDTO clienteDTO = new ClienteDTO("123", "Juliano");
		try {
			clienteDAO.inserir(clienteDTO);
			assertEquals(1, clienteDAO.getCount());
		} catch (Exception e) {
			fail();
		}
	}
}
