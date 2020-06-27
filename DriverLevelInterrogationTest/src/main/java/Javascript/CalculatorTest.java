package Javascript;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
import static org.hamcrest.CoreMatchers.is;

public class CalculatorTest {

    static WebDriver driver;
    public static String url = "http://www.anaesthetist.com/mnm/javascript/calc.htm";
//Setup driver
    @BeforeClass
    public static void setupTest(){
        System.setProperty("webdriver.chrome.driver" ,"G:/chromedriver.exe") ;
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void calculatorjavascripttest(){
        //1. click on 9
        driver.findElement(By.name("nine")).click();
        //2. click +_
        driver.findElement(By.name("")).click();
        //3.click 4
        driver.findElement(By.name("Four")).click();
        //declare javascript executer and call function calculate()

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("calculate();");
        //Assert that addition is 13
        WebElement result = driver.findElement(By.name("Display"));
        assertThat(result.getAttribute("value"), is("12"));


    }
    @AfterClass
    //Quit the browser
    public static void teardown(){
        driver.quit();
    }
}
