/*
 * NewClass.java
 *
 * Created on October 5, 2007, 3:18 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.facensa.bank.fixtures;

import com.facensa.bank.model.ClienteDAO;
import fit.*;

/**
 *
 * @author Daniel
 */
public class ValidaCPFFixture extends PrimitiveFixture{
    
    private String cpf="";

    public void doRows(Parse rows) {
        super.doRows(rows.more);  
    }

    public void doCell(Parse cell, int column) {
        ClienteDAO clienteDAO = new ClienteDAO();
        switch (column) {
            case 0: 
                  cpf = cell.body; 
                  break;
            case 1:                                         
                  check(cell, (clienteDAO.validaCPF(cpf) ? "ok" : "error")); 
                  break;
            default: ignore(cell); break;
        }
    }
}