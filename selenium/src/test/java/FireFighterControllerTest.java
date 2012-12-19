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
    private static String baseUrl="http://localhost:8080";
    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Test
    public void createTest()
    {
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Dodaj nowy straĹĽak")).click();
        driver.findElement(By.id("_name_id")).click();
        driver.findElement(By.id("_name_id")).clear();
        driver.findElement(By.id("_name_id")).sendKeys("Jan");
        driver.findElement(By.id("_secondName_id")).click();
        driver.findElement(By.id("_secondName_id")).clear();
        driver.findElement(By.id("_secondName_id")).sendKeys("");
        driver.findElement(By.id("_surname_id")).clear();
        driver.findElement(By.id("_surname_id")).sendKeys("Testowy");
        driver.findElement(By.id("_birthDate_id")).clear();
        driver.findElement(By.id("_birthDate_id")).sendKeys("2012-12-04");
        driver.findElement(By.id("proceed")).click();
        assertEquals("Jan",driver.findElement(By.id("_c_com_Firefighter_name_name_id")).getText());
        assertEquals("",driver.findElement(By.id("_c_com_Firefighter_secondname_secondName_id")).getText());
        assertEquals("Testowy",driver.findElement(By.id("_c_com_Firefighter_surname_surname_id")).getText());
        assertEquals("2012-12-04",driver.findElement(By.id("_c_com_Firefighter_birthdate_birthDate_id")).getText());

    }

    @Test
    public void showTest(){
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Wszystkie straĹĽacy")).click();
        driver.findElement(By.xpath("(//img[@alt='Pokaďż˝ straĹĽak'])[5]")).click();
        assertEquals("Jan",driver.findElement(By.id("_c_com_Firefighter_name_name_id")).getText());
        assertEquals("",driver.findElement(By.id("_c_com_Firefighter_secondname_secondName_id")).getText());
        assertEquals("Testowy",driver.findElement(By.id("_c_com_Firefighter_surname_surname_id")).getText());
        assertEquals("2012-12-04",driver.findElement(By.id("_c_com_Firefighter_birthdate_birthDate_id")).getText());

    }

    @Test
    public void editAndUpdateTest(){
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Wszystkie straĹĽacy")).click();
        driver.findElement(By.xpath("(//img[@alt='Modyfikuj straĹĽak'])[5]")).click();
        driver.findElement(By.id("_name_id")).click();
        driver.findElement(By.id("_name_id")).clear();
        driver.findElement(By.id("_name_id")).sendKeys("Janek");
        driver.findElement(By.id("_surname_id")).click();
        driver.findElement(By.id("_surname_id")).clear();
        driver.findElement(By.id("_surname_id")).sendKeys("Mateusz");
        driver.findElement(By.id("_surname_id")).sendKeys("Testowka");
        driver.findElement(By.id("_birthDate_id")).click();
        driver.findElement(By.id("_birthDate_id")).clear();
        driver.findElement(By.id("_birthDate_id")).sendKeys("2012-12-10");
        driver.findElement(By.id("proceed")).click();
        assertEquals("Janek",driver.findElement(By.id("_c_com_Firefighter_name_name_id")).getText());
        assertEquals("Mateusz",driver.findElement(By.id("_c_com_Firefighter_secondname_secondName_id")).getText());
        assertEquals("Testowka",driver.findElement(By.id("_c_com_Firefighter_surname_surname_id")).getText());
        assertEquals("2012-12-10",driver.findElement(By.id("_c_com_Firefighter_birthdate_birthDate_id")).getText());

    }

    /*@Test
    public void deleteTest(){

    } */

    @Test
    public void listTest(){
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Wszystkie straĹĽacy")).click();
        driver.findElement(By.linkText("25")).click();
        driver.findElement(By.cssSelector("img[alt=\"NastÄ™pna strona\"]")).click();
        assertEquals(true,driver.getCurrentUrl().contains("page=2&size=25"));
        assertEquals(true,driver.findElement(By.id("_title_pl_com_Firefighter_id")).getAttribute("open"));
        assertEquals("Wszystkie straĹĽacy",driver.findElement(By.id("_title_pl_com_Firefighter_id")).getAttribute("title"));

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
