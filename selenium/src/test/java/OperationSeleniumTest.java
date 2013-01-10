/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 10.01.13
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public class OperationSeleniumTest {
    private WebDriver driver;
    private static String baseUrl = "http://localhost:8080";

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
