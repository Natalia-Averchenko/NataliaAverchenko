package ru.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.MainPage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected MainPage mainPage;

    protected final String siteUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String expectedTitle = "Home Page";
    protected final String username = "Roman";
    protected final String pass = "Jdi1234";
    protected final String firstLastNames = "ROMAN IOVLEV";
    protected final String[] header = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    protected final List<String> headerList = Arrays.asList(header);
    protected final String mc = "Metals & Colors";
    protected final String ep = "Elements packs";
    protected final String[] leftSection = {"Home", "Contact form", "Service", mc, ep};
    protected final List<String> leftSectionList = Arrays.asList(leftSection);

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
        mainPage = new MainPage(driver);
    }

    @AfterClass
    public void tearDown() {
        // 10/12 Close Browser
        driver.quit();
    }

    public void initTest() {

        // 1. Open test site by URL
        assertEquals(mainPage.openMainPage(siteUrl), siteUrl);

        // 2. Assert Browser title ( Browser title equals "Home Page")
        assertEquals(mainPage.getTitle(), expectedTitle);

        // 3. Perform login
        // 4. Assert Username is loggined. Name is displayed and equals to expected result
        assertEquals(mainPage.login(username, pass), firstLastNames);
    }

}
