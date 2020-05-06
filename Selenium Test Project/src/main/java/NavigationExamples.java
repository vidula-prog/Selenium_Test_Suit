import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class NavigationExamples {
    private WebDriver driver;
    final private String URL1 = "https://www.swtestacademy.com/";
    final private String URL2 = "http://www.amazon.com";

@BeforeClass
    public void SetupTest(){
        System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    }

    @Test
    public void T01_getURLExample() {
        //Go to www.yahoo.com
        WebDriver driver = new ChromeDriver();
        driver.get(URL1);


        //Check title is correct
        Assert.assertEquals(driver.getTitle(), "Software Test Academy");
    }
    @Test
    public void T02_navigateToRLExample(){
        //Navigate to amezon url
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(URL2);
        //Check title is correct
        Assert.assertEquals(driver.getTitle(),"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    }
    @Test
    //Back - Forward - Refresh Example
    public void T03_backForwardRefreshExample(){
        //Go to www.yahoo.com
        driver.navigate().to(URL1);
        //Check title is correct
        Assert.assertEquals(driver.getTitle(), "Software Test Academy");

        //Go to www.amazon.com
        driver.navigate().to(URL2);
        //Check title is correct
        Assert.assertEquals(driver.getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

        //***Navigate Back***
        driver.navigate().back();
        //Check title is correct
        Assert.assertEquals(driver.getTitle(), "Software Test Academy");

        //***Navigate Forward***
        driver.navigate().forward();
        //Check title is correct
        Assert.assertEquals(driver.getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

        //***Refresh The Page***
        driver.navigate().refresh();
        Assert.assertEquals(driver.getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    }

    @AfterClass
    public void quitDriver(){
        driver.quit();
    }

}
