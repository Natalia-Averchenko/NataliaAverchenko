package ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;


public class CommonEx1Ex2 {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected final String siteUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String expectedTitle = "Home Page";
    protected final String username = "Roman";
    protected final String pass = "Jdi1234";
    protected final String firstLastNames = "ROMAN IOVLEV";
    protected final String[] header = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    protected final List<String> headerList = Arrays.asList(header);

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void tearDown() {
        // 10/12 Close Browser
        driver.quit();
    }

    public void initTest() {

        // 1. Open test site by URL
        driver.get(siteUrl);
        softAssert.assertEquals(driver.getCurrentUrl(), siteUrl);

        // 2. Assert Browser title ( Browser title equals "Home Page")
        String actualTitle = driver.getTitle();
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
    }

}
