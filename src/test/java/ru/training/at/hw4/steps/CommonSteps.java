package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.pages.MainPage;

import static org.testng.Assert.assertEquals;

public class CommonSteps {

    protected MainPage mainPage;

    public CommonSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    @Step("Open test site by URL. Assert that site URL equals to expected")
    public void openPage(String siteUrl) {
        String currentUrl = mainPage.openMainPage(siteUrl);
        assertEquals(currentUrl, siteUrl);
    }

    @Step("Assert Browser title")
    public void checkTitle(String expectedTitle) {
        assertEquals(mainPage.getTitle(), expectedTitle);
    }

    @Step("Perform login")
    public void login(String username, String pass) {
        mainPage.login(username, pass);
    }

    @Step("Assert Username is loggined. Name is displayed and equals to expected result")
    public void checkUserName(String firstLastNames) {
        assertEquals(mainPage.getUserName(), firstLastNames);
    }
}
