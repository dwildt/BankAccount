package com.facensa.bank.model;

import junit.framework.TestCase;

import com.facensa.bank.exception.ContaExistenteException;
import com.facensa.bank.exception.SaldoInicialNegativoException;

public class InsereContaTeste extends TestCase {

	private ClienteDAO clienteDAO = null;
	private ContaDAO contaDAO;

	protected void setUp() throws Exception {
		super.setUp();
		clienteDAO = new ClienteDAO();
		clienteDAO.inserir(new ClienteDTO("112","Zé"));
		contaDAO = new ContaDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPreRequisitos() {
		assertEquals(1, clienteDAO.getCount());
	}

	public void testInclusaoConta() {
		try {
			ContaDTO contaDTO = new ContaDTO(9999,new ClienteDTO("112","Z�"),12);
			contaDAO.insereConta(contaDTO);
			assertEquals(1, contaDAO.getCount());
		} catch (ContaExistenteException e) {
			fail("Erro desconhecido!");
		} catch (SaldoInicialNegativoException e) {
			fail("Erro desconhecido!");
		}
	}

	public void testContaInexistente() {
		try {
			ContaDTO contaDTO = new ContaDTO(9999,new ClienteDTO("112","Zé"),12);
			contaDAO.insereConta(contaDTO);
			assertEquals(1, contaDAO.getCount());
			contaDAO.insereConta(contaDTO);
			fail("Não poderia inserir essa conta! Chora!");
		} catch (ContaExistenteException e) {

		} catch (SaldoInicialNegativoException e) {
		}
	}

	public void testContaSaldoNegativo(){
		try {
			ContaDTO contaDTO = new ContaDTO(9998,new ClienteDTO("112","Zé"),-12);
			contaDAO.insereConta(contaDTO);
			fail("Nao poderia inserir conta com valor negativo");
		} catch (ContaExistenteException e) {

		} catch (SaldoInicialNegativoException e) {

		}
	}

	public void testContaSaldoZero(){
		try {
			ContaDTO contaDTO = new ContaDTO(9998,new ClienteDTO("112","Zé"),0);
			contaDAO.insereConta(contaDTO);
			fail("Nao poderia inserir conta com valor zero");
		} catch (ContaExistenteException e) {

		} catch (SaldoInicialNegativoException e) {

		}
	}
}
