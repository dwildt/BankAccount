/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.facensa.bank.model;

import org.ddsteps.DdTestCase;
import org.ddsteps.data.DataLoader;
import org.ddsteps.data.excel.CachingExcelDataLoader;

/**
 *
 * @author danielwildt
 */
public class AccountLimitTest extends DdTestCase {
    private long yearsAsCustomer=0;
    private long limitExpected=0;
    private String correctRule = "";

    public void testAccountLimit()
    {
        ClienteDAO clienteDAO = new ClienteDAO();
        long maxLimit = clienteDAO.getMaxCreditLimit(yearsAsCustomer);
        assertEquals("Limit not available for customer. Max = " + maxLimit + " Request = " + limitExpected,getCorrectRule(),
                    (limitExpected <= maxLimit ? "ok" : "error"));
    }

    public long getYearsAsCustomer() {
        return yearsAsCustomer;
    }

    public void setYearsAsCustomer(long yearsAsCustomer) {
        this.yearsAsCustomer = yearsAsCustomer;
    }

    public long getLimitExpected() {
        return limitExpected;
    }

    public void setLimitExpected(long limitExpected) {
        this.limitExpected = limitExpected;
    }

    protected DataLoader createDataLoader() {
        return CachingExcelDataLoader.getInstance();
    }

    public String getCorrectRule() {
        return correctRule;
    }

    public void setCorrectRule(String correctRule) {
        this.correctRule = correctRule;
    }
}
