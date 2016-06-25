package com.facensa.bank.model;

import java.util.Date;

import junit.framework.TestCase;

import com.facensa.bank.exception.ContaInexistenteException;
import com.facensa.bank.log.LogLancamentoConsole;
import com.facensa.bank.log.LogLancamentoCsv;

public class InsereLancamentoTeste extends TestCase {

	private ClienteDAO clienteDAO = null;

	private ContaDAO contaDAO = null;

	private LancamentoDAO lancamentoDAO = null;

	protected void setUp() throws Exception {
		super.setUp();
		clienteDAO = new ClienteDAO();
		ClienteDTO clienteDTO = new ClienteDTO("112", "Zé");
		clienteDAO.inserir(clienteDTO);
		contaDAO = new ContaDAO();
		ContaDTO contaDTO = new ContaDTO(9999, clienteDTO, 12);
		contaDAO.insereConta(contaDTO);
		lancamentoDAO = new LancamentoDAO();
		lancamentoDAO.setContaDAO(contaDAO);
		lancamentoDAO.registraLog(new LogLancamentoConsole());
		lancamentoDAO.registraLog(new LogLancamentoCsv());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPreCondicao()
	{
		assertEquals(1, clienteDAO.getCount());
		assertEquals(1, contaDAO.getCount());
	}

	public void testInsereLancamento() {
		try {
			LancamentoDTO lanctoDTO = new LancamentoDTO(9999, 150.00,
					new Date());
			lancamentoDAO.insere(lanctoDTO);
			assertEquals(1, lancamentoDAO.getCount());
		} catch (ContaInexistenteException e) {
			fail();
			e.printStackTrace();
		}
	}

	public InsereLancamentoTeste() {
		super();
	}

	public InsereLancamentoTeste(String name) {
		super(name);
	}

	public void testContaNaoExistente() {
		try {
			LancamentoDTO lanctoDTO = new LancamentoDTO(1111, 150.00,
					new Date());
			lancamentoDAO.insere(lanctoDTO);
			fail("Erro: Conta Inexistente");
		} catch (ContaInexistenteException e) {

		}

	}

	public void testSaldoContaPosLancamento()
	{
		try {
			LancamentoDTO lanctoDTO = new LancamentoDTO(9999, 3.00,
					new Date());
			lancamentoDAO.insere(lanctoDTO);
			assertEquals(1, lancamentoDAO.getCount());

			ContaDTO conta = contaDAO.buscaConta(9999);
			assertEquals(15.00, conta.getSaldo(),0.0001);

		} catch (ContaInexistenteException e) {
			fail();
			e.printStackTrace();
		}
	}

}
