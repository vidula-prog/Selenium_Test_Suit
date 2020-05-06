import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductTest {
    private WebDriver driver = null;

    @BeforeAll
    public void setup() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAM\\Downloads\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://vidula-bembalkar.herokuapp.com/admin/login");
        }

    private void doLogin() {
        WebElement userName = driver.findElement(By.id("admin_user_email"));
        userName.sendKeys("admin@example.com");

        WebElement passWord = driver.findElement(By.id("admin_user_password"));
        passWord.sendKeys("password");

        WebElement Submit = driver.findElement(By.id("admin_user_submit_action"));
        Submit.click();
    }

    @Test
    public void performProductTest() {
        doLogin();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement productMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products")));
        productMenu.click();
        performCreateProductTest();
        performEditProductTest();
        performDeleteProductTest();

    }

    private void performCreateProductTest() {
        WebElement newProduct = driver.findElement(By.xpath("//*[@id=\"titlebar_right\"]/div/span/a"));
        newProduct.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement submitAction = driver.findElement(By.id("product_submit_action"));
        submitAction.click();

        WebElement hardError = driver.findElement(By.className("inline-errors"));
        hardError.isDisplayed();
        System.out.println(hardError.getText());

      //  assertFalse(hardError.getText() != null && hardError.getText().equals("can't be blank"));

        WebElement productTitle = driver.findElement(By.id("product_title"));
        productTitle.sendKeys("testProduct");

        // Get maxlength attribute of Product title
        String maxLengthDefined = productTitle.getAttribute("maxlength");

        if (maxLengthDefined == null) {
            System.out.println("No limit is set.");
        } else {
            if (maxLengthDefined.equals("40")) {
                System.out.println("Max character limit is set as expected.");
            }
        }
        WebElement productSku = driver.findElement(By.id("product_sku"));

        // Type more than 10 characters as max limit is defined as 10 as per requirement
        productSku.sendKeys("skuismorethanten");

        // Get the typed value
        String typedValue = productSku.getAttribute("value");

        // Get the length of typed value
        int size = typedValue.length();

        // Assert with expected
        if (size == 10) {
            System.out.println("Max character functionality is working fine.");
        } else {
            System.out.println("No limit is set.");
        }
        productSku.clear();
        ;
        productSku.sendKeys("skuofprodu");
        WebElement productDescription = driver.findElement(By.id("product_description"));
        productDescription.sendKeys("Description of a product");

        WebElement createProduct = driver.findElement(By.id("product_submit_action"));
        createProduct.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait waitsuccess = new WebDriverWait(driver, 10);
        WebElement flash = waitsuccess.until(ExpectedConditions.visibilityOfElementLocated(By.className(("flash"))));
        String alertText = flash.getText();
        assertEquals("Product was successfully created.", alertText);
        System.out.println("Product was successfully created.");
    }

    private void performEditProductTest() {
        //Editing of a Product
        WebElement editProduct = driver.findElement(By.className("action_item"));
        editProduct.click();

        WebElement editproductDescription = driver.findElement(By.id("product_description"));
        editproductDescription.sendKeys("description edit");
        WebElement updateProduct = driver.findElement(By.id("product_submit_action"));
        updateProduct.click();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait waitUpdate = new WebDriverWait(driver, 10);
        WebElement flashUpdate = waitUpdate.until(ExpectedConditions.visibilityOfElementLocated(By.className(("flash"))));
        String updateAlert = flashUpdate.getText();
        assertEquals("Product was successfully updated.", updateAlert);
        System.out.println("Product was successfully updated.");
    }

    private void performDeleteProductTest() {
        //Deleting of a product
        WebElement deleteProduct = driver.findElement(By.xpath("//*[@id=\"titlebar_right\"]/div/span[2]/a"));
        deleteProduct.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebDriverWait waitDelete = new WebDriverWait(driver, 10);
        WebElement flashDelete = waitDelete.until(ExpectedConditions.visibilityOfElementLocated(By.className(("flash"))));
        String alertTextDelete = flashDelete.getText();
        assertEquals("Product was successfully destroyed.", alertTextDelete);
        System.out.println("Product was successfully destroyed");
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    /*public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter chrome path on your machine: ");
        String path = myObj.nextLine();
        ProductTest productTest = new ProductTest(path);
        productTest.doLogin();
        productTest.performProductTest();
    }*/
}