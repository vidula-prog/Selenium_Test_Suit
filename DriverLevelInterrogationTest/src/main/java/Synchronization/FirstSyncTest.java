package Synchronization;
import org.hamcrest.CoreMatchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FirstSyncTest {
    static WebDriver driver;
    private static String url = ("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
//Setup driver
    @BeforeClass
    public static  void setupTest(){
        System.setProperty("webdriver.chrome.driver" ,"G:/chromedriver.exe") ;
        driver = new ChromeDriver();
driver.navigate().to(url);
driver.manage().window().maximize();

    }
@Test
public void FirstSyncTest(){
//declare webdriver wait
    WebDriverWait wait = new WebDriverWait(driver,10);

    //Wait until presence of container
    wait.until(ExpectedConditions.presenceOfElementLocated
            (By.cssSelector(".demo-container.size-narrow")));

    //Get the selected date text before AJAX call
    String selectedDateTextBeforeAjaxCall = driver.findElement
            (By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();
//Print selectedDateTextBeforeAjaxCall to the console
    System.out.println("selectedDateTextBeforeAjaxCall: " + selectedDateTextBeforeAjaxCall +"\n" );

    //Find 3rd January on the calendar
    WebElement thirdOfJanuary = driver.findElement(By.xpath(".//*[contains(@class, 'rcWeekend')]/a[.='3']"));

    //Click 3rd January
    thirdOfJanuary.click();

    //Wait until invisibility of loader
    new WebDriverWait(driver,10).until(
            ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".raDiv")));

    //Wait until visibility of selected date text
    //Actually it is not necessary, I added this control to see an example of visibilityOfElementLocated usage.
    new WebDriverWait(driver,10).until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_ContentPlaceholder1_Label1")));

    //Find Selected Dates Text
    String selectedDateTextAfterAjaxCall = driver.findElement(
            By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

    //Print selectedDateTextAfterAjaxCall to the console
    System.out.println("selectedDateTextAfterAjaxCall: " + selectedDateTextAfterAjaxCall +"\n" );

    //Check the Actual and Expected Text
    assertThat(selectedDateTextAfterAjaxCall, CoreMatchers.is("Sunday, January 03, 2016"));
}

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }


}
