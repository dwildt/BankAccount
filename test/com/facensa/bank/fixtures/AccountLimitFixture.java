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
public class AccountLimitFixture extends PrimitiveFixture{
    
    private long yearsAsCustomer=0;
    private long limitExpected=0;

    public void doRows(Parse rows) {
        super.doRows(rows.more);  
    }

    public void doCell(Parse cell, int column) {
        ClienteDAO clienteDAO = new ClienteDAO();
        switch (column) {
            case 0: 
                  yearsAsCustomer = Long.parseLong(cell.body); 
                  break;
            case 1: 
                  limitExpected = Long.parseLong(cell.body); 
                  break;
            case 2:     
                  check(cell, (limitExpected <= clienteDAO.getMaxCreditLimit(yearsAsCustomer) ? "ok" : "error")); 
                  break;
            default: ignore(cell); break;
        }
    }
}