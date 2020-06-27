package Synchronization;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class FirstFailedSyncTest {
    static WebDriver driver;
    private static String url = "http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx";

    //Setup driver
    @BeforeClass
    public static void setupTest(){
        System.setProperty("webdriver.chrome.driver" ,"G:/chromedriver.exe") ;
        driver = new ChromeDriver();

        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

@Test
    public void FirstFailedSyncTest(){
        //get the selected date before ajax call
        String selectedDateBeforeAJAXCall = driver.findElement(By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();
        //Print the output
    System.out.println("selectedDateBeforeAJAXCall: "+ selectedDateBeforeAJAXCall + "\n" );
    //Find 3rd January on the calendar
    WebElement thirdJanuary = driver.findElement(By.xpath(".//*[contains(@class, 'rcWeekend')]/a[.='3']"));

    //Click 3rd January
    thirdJanuary.click();

    //Get the selected date text after AJAX call
    String selectedDateTextAfterAjaxCall = driver.findElement(
            By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

    //Print selectedDateTextAfterAjaxCall to the console
    System.out.println("selectedDateTextAfterAjaxCall: " + selectedDateTextAfterAjaxCall +"\n" );

    //Check the Actual and Expected Text
    assertThat(selectedDateTextAfterAjaxCall, is("Sunday, January 03, 2016"));
}

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}


