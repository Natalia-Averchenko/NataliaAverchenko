package ru.training.at.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class Exercise2 {

    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    final String siteUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    final String username = "Roman";
    final String pass = "Jdi1234";
    final String firstLastNames = "ROMAN IOVLEV";


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        // 10. Close Browser
        driver.quit();
    }

    @Test
    public void webDriverStart() throws InterruptedException {

        // 1. Open test site by URL
        driver.get(siteUrl);
        softAssert.assertEquals(driver.getCurrentUrl(), siteUrl);

        // 2. Assert Browser title ( Browser title equals "Home Page")
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page";
        softAssert.assertEquals(actualTitle, expectedTitle);

        // 3. Perform login
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id("user-icon")))
                .click();
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined. Name is displayed and equals to expected result
        String actualFirstLastName = driver.findElement(By.id("user-name")).getText();
        softAssert.assertEquals(actualFirstLastName, firstLastNames);

        // 5. Open through the header menu Service -> Different Elements Page
        WebElement header = driver
                .findElement(By.cssSelector("header div.uui-header.dark-gray"));
        WebElement navBar = header
                .findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8"));
        navBar.findElement(By.cssSelector("a.dropdown-toggle")).click();
        navBar.findElement(By.cssSelector("ul.dropdown-menu"));
        navBar.findElement(By.xpath("//*[text()='Different elements']")).click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/different-elements.html");

        // 6. Select checkboxes Water, Wind
        List<WebElement> checkboxLabels = driver
                .findElements(By.cssSelector("div label.label-checkbox"));
        checkboxLabels.get(0).click();
        checkboxLabels.get(2).click();
        //softAssert.assertTrue(checkbox.get(0).isSelected());
        //softAssert.assertTrue(checkbox.get(0).isSelected());

        // 7. Select radio - Selen
        List<WebElement> checkboxRadio = driver.findElements(By.cssSelector("input[type=radio]"));
        checkboxRadio.get(3).click();

        // 8. Select in dropdown - Yellow
        // WebElement color = driver.findElement(By.cssSelector("select.uui-form-element"));
        new Select(driver.findElement(By.cssSelector("select.uui-form-element")))
                .selectByVisibleText("Yellow");

        // 9. Assert that
        WebElement log = driver.findElement(By.cssSelector("ul.panel-body-list.logs"));
        List<WebElement> listLog = log.findElements(By.tagName("li"));
        softAssert.assertTrue(listLog.get(0).getText().contains("value changed to Yellow"));
        softAssert.assertTrue(listLog.get(1).getText().contains("value changed to Selen"));
        softAssert.assertTrue(listLog.get(2).getText().contains("condition changed to true"));
        softAssert.assertTrue(listLog.get(3).getText().contains("condition changed to true"));

        softAssert.assertAll();

    }
}
