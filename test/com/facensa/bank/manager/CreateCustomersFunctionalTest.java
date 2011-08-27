/*
 * CreateCustomersFunctionalTest.java
 * JUnit based test
 *
 * Created on October 5, 2007, 1:54 AM
 */
package com.facensa.bank.manager;

import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

/**
 *
 * @author Daniel
 */
public class CreateCustomersFunctionalTest extends SeleneseTestCase {

    public CreateCustomersFunctionalTest(String testName) {
        super(testName);
    }

    public void testCreateCustomersFunctional() {
        selenium.open("http://localhost:8084/BankAccount/index.faces");
        selenium.waitForPageToLoad("30000");
        selenium.click("id=_id0:incluir");
        selenium.waitForPageToLoad("30000");
        selenium.type("id=_id0:edCpf", "4321");
        selenium.type("id=_id0:edNome", "abcd");
        selenium.click("id=_id0:gravar");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=Editar");
        selenium.waitForPageToLoad("30000");
        selenium.type("id=_id0:edNome", "abcd mod");
        selenium.click("id=_id0:gravar");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=Remover");
        selenium.waitForPageToLoad("30000");
        
        selenium.click("id=_id0:incluir");
        selenium.waitForPageToLoad("30000");
        selenium.type("id=_id0:edCpf", "4321");
        selenium.type("id=_id0:edNome", "abcd");
        selenium.click("id=_id0:gravar");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=Editar");
        selenium.waitForPageToLoad("30000");
        selenium.type("id=_id0:edNome", "abcd mod");
        selenium.click("id=_id0:gravar");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=Remover");
        selenium.waitForPageToLoad("30000");
       
        selenium.click("id=_id0:incluir");
        selenium.waitForPageToLoad("30000");
        selenium.type("id=_id0:edCpf", "4321");
        selenium.type("id=_id0:edNome", "abcd");
        selenium.click("id=_id0:gravar");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=Editar");
        selenium.waitForPageToLoad("30000");
        selenium.type("id=_id0:edNome", "abcd mod");
        selenium.click("id=_id0:gravar");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=Remover");
        selenium.waitForPageToLoad("30000");

    }
}
