import org.openqa.selenium.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

//@FixMethodOrder(MethodSorters.DEFAULT)
public class FlightSearchFunctions {
    static WebDriver driver;
    final private String URL ="https://www.phptravels.net/home";

    @BeforeClass
    public static void SteupTest() {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium Automation Projects\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeClass
    public  void navigateToWebpage(){
        driver.navigate().to(URL);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void automateFlightTab() throws InterruptedException {
        WebElement flights = driver.findElement(By.xpath("//a[contains(text(),'Flights')]"));
        flights.sendKeys("flights");
        flights.click();
    }

    @Test(priority = 2)
    public void automateRoundTripOption() throws InterruptedException {
        WebElement check = driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]"));
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(check));
        check.click();
    }


    @Test(priority = 3)
    public void automateClassOption() {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        WebElement select =  driver.findElement(By.xpath("//div[contains(@class,'chosen-container')]"));
        select.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("chosen-results")));
        WebElement dd = driver.findElement(By.xpath("//li[@data-option-array-index='1']"));
        dd.click();
    }


    @Test(priority = 5)
    public void automateDepartDate() throws InterruptedException, AWTException {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //Select "Depart  date as current date
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("FlightsDateStart")));
        driver.findElement(By.id("FlightsDateStart")).click();
        //Thread.sleep(2000);
        /*wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body.with-waypoint-sticky:nth-child(2) div.datepickers-container:nth-child(8) div.datepicker.-bottom-left-.-from-bottom-:nth-child(8) nav.datepicker--nav div.datepicker--nav-title:nth-child(2) > i:nth-child(1)")));
        //WebElement jul = driver.findElement(By.cssSelector("body.with-waypoint-sticky:nth-child(2) div.datepickers-container:nth-child(8) div.datepicker.-bottom-left-.-from-bottom-:nth-child(8) nav.datepicker--nav div.datepicker--nav-title:nth-child(2) > i:nth-child(1)"));
        //jul.click();
        /*wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("pickupdate")));
        driver.findElement(By.name("pickupdate")).sendKeys("29/06/2020");*/
        /*JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = " return document.getElementsByClassName(\"datepicker--nav-title\").value;";
        String text = (String) js.executeScript(script);*/
        //driver.findElement(By.cssSelector("body.with-waypoint-sticky:nth-child(2) div.datepickers-container:nth-child(8) div.datepicker.-bottom-left-.-from-bottom-:nth-child(8) nav.datepicker--nav div.datepicker--nav-title:nth-child(2) > i:nth-child(1)"));
        //((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"datepicker--nav-title\").value;");
        //new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[8]//nav[1]//div[2]"))).click();
        Robot robot = new Robot();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        //*robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
        Thread.sleep(2000);//*
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        //Robot.mousePress(InputEvent.BUTTON1_MASK);
        //robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_ENTER);


        /*WebElement element1 = driver.findElement(By.cssSelector(".datepicker--nav-title"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);*/

        //driver.findElement(By.xpath("//div[contains(text(),'Jul')]")).click();
        //driver.findElement(By.xpath("//div[8]//div[1]//div[1]//div[2]//div[9]")).click();

        //div[contains(text(),'Jul')]
        //div[8]//div[1]//div[1]//div[2]//div[9]
        //body.with-waypoint-sticky:nth-child(2) div.datepickers-container:nth-child(8) div.datepicker.-bottom-left-.-from-bottom-:nth-child(8) div.datepicker--content div.datepicker--days.datepicker--body.active div.datepicker--cells.datepicker--cells-days > div.datepicker--cell.datepicker--cell-day.-weekend-.-current-:nth-child(29)
    }

    @Test(priority = 6)
    public void automateReturnDate() throws AWTException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //Select "Depart  date as current date
        /*WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("FlightsDateEnd")));*/
        driver.findElement(By.id("FlightsDateEnd"));
        Thread.sleep(2000);
        Robot robot = new Robot();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
        Thread.sleep(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        //Robot.mousePress(InputEvent.BUTTON1_MASK);
        //robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        /*driver.findElement(By.id("FlightsDateEnd")).sendKeys("2020-08-11");
        driver.findElement(By.id("FlightsDateEnd")).click();*/
    }
    /*@Test(priority = 7)
    public void T06_SelectType() {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //Add "Adults" ,"Child" and"InFAT"
        WebElement Adult = driver.findElement(By.cssSelector(".btn.btn-white.bootstrap-touchspin-up "));
        Adult.click();
        WebElement Child = driver.findElement(By.xpath("//div[@id='flights']//div[2]//div[1]//div[2]//div[1]//span[1]//button[1]"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(Child));
        Child.click();
        WebElement InFant = driver.findElement(By.xpath("//body//div[@id='flights']//div//div//div//div//div//div[3]//div[1]//div[2]//div[1]//span[1]//button[1]"));
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(InFant));
        InFant.click();
    }*/


    @Test(priority = 8)
    public void automateSearchButton() {
        WebElement Search = driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-12']//button[@class='btn-primary btn btn-block'][contains(text(),'Search')]"));
        Search.submit();
    }

    /*@Test
    public void automateDestination() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        WebElement From = driver.findElement(By.xpath("//input[@id='location_from_code']"));
        From.click();
        From.sendKeys("{\"code\":\"ABC\",\"location\":\"\"}");
        From.sendKeys(Keys.TAB);
    }

    @Test
    public void automateDepartDate() {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //Select "Depart  date as current date
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("FlightsDateStart")));
        driver.findElement(By.id("FlightsDateStart")).click();
        driver.findElement(By.id("FlightsDateStart")).sendKeys("2020-07-11");
    }

    @Test
    public void automateReturnDate() {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //Select "Depart  date as current date
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("FlightsDateStart")));
        driver.findElement(By.id("FlightsDateStart")).click();
        driver.findElement(By.id("FlightsDateStart")).sendKeys("2020-07-11");
    }

    */

    @AfterClass
    public void QuitBrowser(){
        driver.quit();
    }
}
