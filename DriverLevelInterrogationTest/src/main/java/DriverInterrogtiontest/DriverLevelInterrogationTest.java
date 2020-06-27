package DriverInterrogtiontest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverLevelInterrogationTest {
    static WebDriver driver;
final private String URL ="http://www.teknosa.com/";

@BeforeClass
public static void SteupTest() {
 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
    driver = new ChromeDriver();    }

   @BeforeClass
    public  void navigateToWebpage(){
    driver.navigate().to(URL);
    }
@Test
public void T01_getTitle(){
    //.getTitle example
    assertThat(driver.getTitle(), is("Teknosa"));
}
@Test
public  void T02_getCurrentURL(){
    //.getCurrentURL example

    assertThat(driver.getCurrentUrl(),is("http://www.teknosa.com/"));
}
@Test //.getPageSource example
public void T03_getPagesource(){
    //get the page source and store it in string
    String pageSource = driver.getPageSource();
    //Check the page source contains
    assertTrue(pageSource.contains("Teknosa"));
}
    @Test
    public void T04_findById() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find first name text box by By.id method
        WebElement firstNameTextBox = driver.findElement(By.id("first-name"));

        //Assert that text box is empty
        assertThat(firstNameTextBox.getText(), is(""));
    }
    @Test
    public void T05_findByName(){
    //naviagte to Lindin.com
        driver.navigate().to("https://www.linkedin.com/");
        //find element by name method
        WebElement firstNameTextBox = driver.findElement(By.name("firstName"));
        //Assert that text box is empty
        assertThat(firstNameTextBox.getText(),is(""));

    }
    @Test
    public void T06_findByLinkText(){

    //Navigate to linkedin.com
        driver.navigate().to("https://www.linkedin.com/");
        //findelement by link text
        WebElement firstNameTextBox = driver.findElement(By.linkText("Forgot password?"));
        //assert that text box is as given
        assertThat(firstNameTextBox.getText(),is("\"Forgot password?\""));
    }


    @Test
    public void T07_findpartialLinkText() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find first name text box by By.partialLinkText method
        WebElement forgetPassLink = driver.findElement(By.partialLinkText("password?"));

        //Assert that text box is as expected
        assertThat(forgetPassLink.getText(), is("Forgot password?"));
    }
    @Test
    public void T08_findbyClassName(){
    //naviagte to linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //find the element by class name method
        List<WebElement> textInputclasses = driver.findElements(By.className("cell-body-textinput"));

        int textInputClassCount = textInputclasses.size();

        //assert that count of class names used
        assertThat(textInputClassCount,is(4));
    }

    //Find By.tagName Example
    @Test
    public void T09_findtagName() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find first name text box by By.tagName method
        List<WebElement> h3Tags  = driver.findElements(By.tagName("h3"));

        int h3TagCount = h3Tags.size();

        //Assert that text box is empty
        assertThat(h3TagCount, is(6));
    }
    @Test
    public void T10_chainingwithByChain(){
    //Naviaget to Linkedin
        driver.navigate().to("https://www.linkedin.com/");
        WebElement element;
        element = driver.findElement(
                new ByChained(
                        By.className("Link"),By.linkText("About")));
assertThat(element.getAttribute("href"),is("https://www.linkedin.com/about-us?trk=uno-reg-guest-home-about") );



    }
@Test

public void T11_chainingbyFindelement(){
    //navigat eto linkedin
    driver.navigate().to("https://www.linkedin.com/");
    WebElement chainingfindelement = driver.findElement(By.className("link")).findElement(By.linkText("About"));
    assertThat(chainingfindelement.getAttribute("href"),is(""));
}

@Test
public void T12_FindelementByXpath(){
    driver.navigate().to("https://www.linkedin.com/");
    WebElement ElementByXpath = driver.findElement(By.xpath("//class[@]"));
    assertThat(ElementByXpath.getText(), is("Sign In"));
    String Bcolor = driver.findElement(By.xpath("//class[@]")).getCssValue("background-color");
    
    //Actions action = new Actions(driver);
    //WebElement menu = driver.findElement(By.id("test"));
    //action.moveToElement(menu).moveToElement(driver.findElement(By.xpath(""))).click();

}

    @Test
    public void T10_NosuchElement(){
    //navigate to linkdin.com
        driver.navigate().to("https://www.linkedin.com/");
        //use try catch
                try{
            //Wrong locate element
            WebElement noSuchElementExists =driver.findElement(By.id("BLABLAH"));
        }
                catch (NoSuchElementException e){
                    // import org.openqa.selenium.NoSuchElementException;
                }
    }
@AfterClass // quit the browser
public static void quitdriver(){

    driver.quit();
}

}
