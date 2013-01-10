/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 19.12.12
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class FireFighterControllerTest {

    private WebDriver driver;
    private static String baseUrl = "http://localhost:8080";

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    //@Test
    public void createTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Dodaj nowego strażaka")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("_name_id")).click();
        driver.findElement(By.id("_name_id")).clear();
        driver.findElement(By.id("_name_id")).sendKeys("Testowy");
        driver.findElement(By.id("_surname_id")).clear();
        driver.findElement(By.id("_surname_id")).sendKeys("Selenium");
        driver.findElement(By.id("_birthDate_id")).sendKeys("2009-12-04");
        driver.findElement(By.id("_address.street_id")).click();
        driver.findElement(By.id("_address.street_id")).clear();
        driver.findElement(By.id("_address.street_id")).sendKeys("Pogodna 1");
        driver.findElement(By.id("_address.postCode_id")).clear();
        driver.findElement(By.id("_address.postCode_id")).sendKeys("21-200");
        driver.findElement(By.id("_address.city_id")).clear();
        driver.findElement(By.id("_address.city_id")).sendKeys("Parczew");
        driver.findElement(By.id("_pesel_id")).clear();
        driver.findElement(By.id("_pesel_id")).sendKeys("90080908192");
        driver.findElement(By.id("_legitimation_id")).clear();
        driver.findElement(By.id("_legitimation_id")).sendKeys("11/1990");
        driver.findElement(By.id("proceed")).click();
        Thread.sleep(1000);
        assertEquals(false, driver.findElement(By.id("_c_com_Firefighter_name_name_id")).getText().isEmpty());
        assertEquals(true, driver.findElement(By.id("_c_com_Firefighter_secondname_secondName_id")).getText().isEmpty());
        assertEquals(false, driver.findElement(By.id("_c_com_Firefighter_surname_surname_id")).getText().isEmpty());
        assertEquals(false, driver.findElement(By.id("_c_com_Firefighter_birthdate_birthDate_id")).getText().isEmpty());

    }

    @Test
    public void showTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Wszyscy strażacy")).click();
        Thread.sleep(200);
        driver.findElement(By.xpath("(//img[@alt='Pokaż strażak'])[2]")).click();
        Thread.sleep(1000);
        assertEquals(false, driver.findElement(By.id("_c_com_Firefighter_name_name_id")).getText().isEmpty());
        assertEquals(false, driver.findElement(By.id("_c_com_Firefighter_surname_surname_id")).getText().isEmpty());
        assertEquals(false, driver.findElement(By.id("_c_com_Firefighter_birthdate_birthDate_id")).getText().isEmpty());

    }

    @Test
    public void editAndUpdateTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Wszyscy strażacy")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//img[@alt='Modyfikuj strażak'])[7]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("_surname_id")).click();
        driver.findElement(By.id("_secondName_id")).click();
        driver.findElement(By.id("_secondName_id")).clear();
        driver.findElement(By.id("_secondName_id")).sendKeys("Antoni");
        driver.findElement(By.id("proceed")).click();
        Thread.sleep(1000);
        assertEquals(false, driver.findElement(By.id("_c_com_Firefighter_name_name_id")).getText().isEmpty());
        assertEquals(false, driver.findElement(By.id("_c_com_Firefighter_surname_surname_id")).getText().isEmpty());
        assertEquals(false, driver.findElement(By.id("_c_com_Firefighter_birthdate_birthDate_id")).getText().isEmpty());

    }

    /*@Test
    public void deleteTest(){

    } */

    @Test
    public void listTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Wszyscy strażacy")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("5")).click();
        Thread.sleep(1000);

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
