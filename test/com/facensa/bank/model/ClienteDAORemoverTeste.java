package com.facensa.bank.model;

import junit.framework.*;

public class ClienteDAORemoverTeste extends TestCase {
    private ClienteDAO clienteDAO = null;

    public ClienteDAORemoverTeste(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        clienteDAO = new ClienteDAO();
    }

    protected void tearDown() throws Exception {
        clienteDAO = null;
        super.tearDown();
    }
    
    public void testRemover() {
        ClienteDTO cliente =
             new ClienteDTO("1","teste");
        try {
            clienteDAO.inserir(cliente);
            assertTrue("Deveria ter um cliente",
                        clienteDAO.getCount() == 1);
        } catch (Exception ex) {
        }

        clienteDAO.remover(cliente);
        assertTrue("Deveria estar vazio!",
                    clienteDAO.getCount() == 0);
    }

}
