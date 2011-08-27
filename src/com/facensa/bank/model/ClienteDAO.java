package com.facensa.bank.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados de clientes
 */     
public class ClienteDAO {

    private ArrayList lista = new ArrayList();

    public void inserir(ClienteDTO clienteDTO) throws Exception {
        ClienteDTO buscaDTO = buscaCliente(clienteDTO.getCpf());
        if (buscaDTO == null) {
            try {
                if(validaCPF(clienteDTO.getCpf()))
                  lista.add(clienteDTO);
            } catch (Exception ex) {
            }

        } else {
            buscaDTO.setNome(clienteDTO.getNome());
        }

    }

    public boolean validaCPF(String cpf) {

        if (cpf.equals("200")) {
           return false;
        } else if (cpf.equals("199")) {
            return false;
        } else if (cpf.equals("188")) {
            return false;
        } else if (cpf.equals("177")) {
            return false;
        } else if (cpf.equals("166")) {
            return false;
        } 
        
        return true;
    }

    public ClienteDTO buscaCliente(String cpf) {
        ClienteDTO clienteDTO = null;
        for (int i = 0; i < lista.size(); i++) {
            clienteDTO = (ClienteDTO) lista.get(i);
            if (clienteDTO.getCpf().equals(cpf)) {
                return clienteDTO;
            }
        }
        return null;
    }

    public int getCount() {
        return lista.size();
    }

    /**
     * getAll
     *
     * @return List
     */
    public List getAll() {
        return lista;
    }

    /**
     * remover
     *
     * @param clienteLocal
     *            ClienteDTO
     */
    public void remover(ClienteDTO cliente) {
       lista.remove(cliente);
    }

    /**
     * Sample functionality to return the maximum credit limit a customer may
     * have being a bank customer. 
     * @param yearsAsCustomer
     * @return maximum credit limit available for customer. 
     */
    public long getMaxCreditLimit(long yearsAsCustomer)
    {
        if( yearsAsCustomer > 3)
            return 1200;
        else if( yearsAsCustomer >= 2 && yearsAsCustomer <= 3)
            return 800;
        else if( yearsAsCustomer == 1 )
            return 300;
        else return 0;
    }
    
}
