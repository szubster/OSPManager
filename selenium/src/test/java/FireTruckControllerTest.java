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
    private static String baseUrl="http://localhost:8080";
    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Test
    public void createTruckTest() {
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Dodaj nowy wĂłz straĹĽacki")).click();
        driver.findElement(By.id("_number_id")).click();
        driver.findElement(By.id("_number_id")).clear();
        driver.findElement(By.id("_number_id")).sendKeys("1234");
        driver.findElement(By.id("_licensePlate_id")).clear();
        driver.findElement(By.id("_licensePlate_id")).sendKeys("LPA10");
        driver.findElement(By.id("proceed")).click();
        assertEquals("1234",driver.findElement(By.id("_s_com_Firetruck_Number_number_id")).getText());
        assertEquals("LPA10",driver.findElement(By.id("_c_com_Firetruck_licensePlate_licensePlate_id")).getText());
    }

    @Test
    public void showTest(){
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Wszystkie wozy straĹĽackie")).click();
        driver.findElement(By.xpath("(//img[@alt='Pokaďż˝ wĂłz straĹĽacki'])[2]")).click();
        assertEquals("1234",driver.findElement(By.id("_s_com_Firetruck_Number_number_id")).getText());
        assertEquals("LPA10",driver.findElement(By.id("_c_com_Firetruck_licensePlate_licensePlate_id")).getText());
    }

    @Test
    public void editAndUpdateTest(){
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Wszystkie wozy straĹĽackie")).click();
        driver.findElement(By.xpath("(//img[@alt='Modyfikuj wĂłz straĹĽacki'])[3]")).click();
        driver.findElement(By.id("_number_id")).click();
        driver.findElement(By.id("_number_id")).clear();
        driver.findElement(By.id("_number_id")).sendKeys("12345");
        driver.findElement(By.id("_licensePlate_id")).click();
        driver.findElement(By.id("_licensePlate_id")).clear();
        driver.findElement(By.id("_licensePlate_id")).sendKeys("LPA101");
        driver.findElement(By.id("proceed")).click();
        assertEquals("12345",driver.findElement(By.id("_s_com_Firetruck_Number_number_id")).getText());
        assertEquals("LPA101",driver.findElement(By.id("_c_com_Firetruck_licensePlate_licensePlate_id")).getText());
    }

    /* @Test
 public void deleteTest(){
     driver.get(baseUrl + "/");
     driver.findElement(By.linkText("Wszystkie wozy straĹĽackie")).click();
     driver.findElement(By.xpath("(//input[@value='Usuďż˝ wĂłz straĹĽacki'])[3]")).click();
// ERROR: Caught exception [ERROR: Unsupported command [getConfirmation]]

 }   */

    @Test
    public void listTest(){
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Wszystkie wozy straĹĽackie")).click();
        driver.findElement(By.linkText("15")).click();
        driver.findElement(By.cssSelector("img[alt=\"NastÄ™pna strona\"]")).click();
        assertEquals(true,driver.getCurrentUrl().contains("page=2&size=15"));
        assertEquals(true,driver.findElement(By.id("_title_pl_com_Firetruck_id")).getAttribute("open"));
        assertEquals("Wszystkie wozy straĹĽackie",driver.findElement(By.id("_title_pl_com_Firetruck_id")).getAttribute("title"));
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
