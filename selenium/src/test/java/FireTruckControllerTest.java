/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 19.12.12
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class FireTruckControllerTest {

    private WebDriver driver;

    private static String baseUrl = "http://localhost:8080";

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Test
    public void createTruckTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Dodaj nowy wóz strażacki")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("_codeName_id")).click();
        driver.findElement(By.id("_codeName_id")).clear();
        driver.findElement(By.id("_codeName_id")).sendKeys("123-54");
        driver.findElement(By.id("_licensePlate_id")).clear();
        driver.findElement(By.id("_licensePlate_id")).sendKeys("LPA000");
        driver.findElement(By.id("_milage_id")).clear();
        driver.findElement(By.id("_milage_id")).sendKeys("1000");
        driver.findElement(By.id("proceed")).click();
        Thread.sleep(1000);
        assertEquals(false, driver.findElement(By.id("_c_com_Firetruck_codeName_codeName_id")).getText().isEmpty());
        assertEquals(false, driver.findElement(By.id("_c_com_Firetruck_licensePlate_licensePlate_id")).getText().isEmpty());
        assertEquals(false, driver.findElement(By.id("_c_com_Firetruck_milage_milage_id")).getText().isEmpty());
    }

    @Test
    public void showTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Wszystkie wozy strażackie")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//img[@alt='Pokaż wóz strażacki'])[2]")).click();
        Thread.sleep(1000);
        assertEquals(false, driver.findElement(By.id("_c_com_Firetruck_codeName_codeName_id")).getText().isEmpty());
        assertEquals(false, driver.findElement(By.id("_c_com_Firetruck_licensePlate_licensePlate_id")).getText().isEmpty());

    }

    @Test
    public void editAndUpdateTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Wszystkie wozy strażackie")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//img[@alt='Modyfikuj wóz strażacki'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("_licensePlate_id")).click();
        driver.findElement(By.id("_licensePlate_id")).clear();
        driver.findElement(By.id("_licensePlate_id")).sendKeys("LPA0001");
        driver.findElement(By.id("_milage_id")).click();
        driver.findElement(By.id("_milage_id")).clear();
        driver.findElement(By.id("_milage_id")).sendKeys("10001");
        driver.findElement(By.id("proceed")).click();
        Thread.sleep(1000);
        assertEquals(false, driver.findElement(By.id("_c_com_Firetruck_codeName_codeName_id")).getText().isEmpty());
        assertEquals(false, driver.findElement(By.id("_c_com_Firetruck_licensePlate_licensePlate_id")).getText().isEmpty());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
