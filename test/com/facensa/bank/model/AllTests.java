package com.facensa.bank.model;

import com.facensa.bank.manager.CreateCustomersFunctionalTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.facensa.banco.modelo");
		//$JUnit-BEGIN$
		suite.addTestSuite(InsereContaTeste.class);
		suite.addTestSuite(ConsultaSaldoContaTeste.class);
		suite.addTestSuite(InsereClienteTeste.class);
		suite.addTestSuite(InsereLancamentoTeste.class);
		suite.addTestSuite(ClienteDAORemoverTeste.class);
                //suite.addTestSuite(CreateCustomersFunctionalTest.class);
                suite.addTestSuite(AccountLimitTest.class);
		//$JUnit-END$
		return suite;
	}

}
