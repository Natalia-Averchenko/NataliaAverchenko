package ru.training.at.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Exercise1 {

    protected WebDriver driver;
    final String siteUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    final String expectedTitle = "Home Page";
    final String username = "Roman";
    final String pass = "Jdi1234";
    final String firstLastNames = "ROMAN IOVLEV";
    final String[] header = new String[]{"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        // 12. Close Browser
        driver.quit();
    }

    @Test
    public void webDriverStart() {

        // 1. Open test site by URL
        driver.get(siteUrl);
        //assertEquals(driver.getCurrentUrl(), siteUrl);

        // 2. Assert Browser title ( Browser title equals "Home Page")
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle);

        // 3. Perform login
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id("user-icon")))
                .click();
        //driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined. Name is displayed and equals to expected result
        String actualFirstLastName = driver.findElement(By.id("user-name")).getText();
        assertEquals(actualFirstLastName, firstLastNames);

        // 5. Assert that there are 4 items on the header section are displayed
        // and they have proper texts

        //List<WebElement> headerElements
        // = driver.findElements(By.cssSelector("header .uui-header .uui-navigation > li"));

        List<WebElement> headerElements = driver
                .findElements(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li"));
        for (int i = 0; i < 4; i++) {
            assertEquals(headerElements.get(i).getText(), header[i]);
        }

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver
                .findElements(By.cssSelector("div.row.clerafix.benefits span.icons-benefit"));
        for (int i = 0; i < 4; i++) {
            assertTrue(benefitIcons.get(i).isDisplayed());
        }

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String firstBenefit = "To include good practices\n"
                + "and ideas from successful\n" + "EPAM project";
        String secondBenefit = "To be flexible and\n" + "customizable";
        String thirdBenefit = "To be multiplatform";
        String fourthBenefit = "Already have good base\n" + "(about 20 internal and\n"
                + "some external projects),\n" + "wish to get more…";
        String[] benefits = {firstBenefit, secondBenefit, thirdBenefit, fourthBenefit};
        List<WebElement> benefitDesc = driver
                .findElements(By.cssSelector("div.row.clerafix.benefits span.benefit-txt"));
        for (int i = 0; i < 4; i++) {
            assertEquals(benefitDesc.get(i).getText(), benefits[i]);
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        int counter = 0;
        for (int i = 0; i < frames.size(); i++) {
            driver.switchTo().frame(i);
            if (driver.findElements(By.id("frame-button")).size() != 0) {
                counter++;
            }
            driver.switchTo().defaultContent();
        }
        assertNotEquals(counter, 0);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        assertNotNull(frameButton);

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed
        // and they have proper text
        WebElement leftSectionBar =
                driver.findElement(By.cssSelector(".sidebar-menu.left"));

        List<WebElement> searchElementHome =
                leftSectionBar.findElements(By.xpath("//span[text()='Home']"));
        assertEquals(searchElementHome.size(), 1);

        List<WebElement> searchElementContact =
                leftSectionBar.findElements(By.xpath("//span[text()='Contact form']"));
        assertEquals(searchElementContact.size(), 1);

        List<WebElement> searchElementService =
                leftSectionBar.findElements(By.xpath("//span[text()='Service']"));
        assertEquals(searchElementService.size(), 1);

        List<WebElement> searchElementMetals =
                leftSectionBar.findElements(By.xpath("//span[text()='Metals & Colors']"));
        assertEquals(searchElementMetals.size(), 1);

        List<WebElement> searchElementElementsPacks =
                leftSectionBar.findElements(By.xpath("//span[text()='Elements packs']"));
        assertEquals(searchElementElementsPacks.size(), 1);

    }
}
