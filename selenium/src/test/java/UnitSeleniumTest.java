/*
 * Copyright (c) 2013. Tomasz Szuba, Paulina Schab, Michał Tkaczyk. All rights reserved.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 10.01.13
 * Time: 21:19
 * To change this template use File | Settings | File Templates.
 */
public class UnitSeleniumTest {
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

    @Test
    public void addCourseTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Dodaj nowe szkolenie")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("_course_id")).click();
        driver.findElement(By.id("_course_id")).clear();
        driver.findElement(By.id("_course_id")).sendKeys("szkolenie");
        driver.findElement(By.id("proceed")).click();

    }

    @Test
    public void addAwardTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Dodaj nową nagrodę")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("_award_id")).click();
        driver.findElement(By.id("_award_id")).clear();
        driver.findElement(By.id("_award_id")).sendKeys("nagroda");
        driver.findElement(By.id("proceed")).click();

    }

    @Test
    public void addRankTest() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Dodaj nowy stopień")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("_rank_id")).click();
        driver.findElement(By.id("_rank_id")).clear();
        driver.findElement(By.id("_rank_id")).sendKeys("stopien");
        driver.findElement(By.id("proceed")).click();

    }

}
