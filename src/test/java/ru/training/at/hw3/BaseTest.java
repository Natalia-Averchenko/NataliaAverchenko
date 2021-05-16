package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.MainPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected MainPage mainPage;

    @BeforeTest
    public void setup() {
        driver = Driver.createDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
        mainPage = new MainPage(driver);
    }

    @AfterTest
    public void tearDown() {
        // 10/12 Close Browser
        driver.quit();
    }

    public void initTest(String siteUrl, String expectedTitle,
                         String username, String pass, String firstLastNames) {

        // 1. Open test site by URL
        assertEquals(mainPage.openMainPage(siteUrl), siteUrl);

        // 2. Assert Browser title ( Browser title equals "Home Page")
        assertEquals(mainPage.getTitle(), expectedTitle);

        // 3. Perform login
        mainPage.login(username, pass);

        // 4. Assert Username is loggined. Name is displayed and equals to expected result
        assertEquals(mainPage.getUserName(), firstLastNames);
    }

}
