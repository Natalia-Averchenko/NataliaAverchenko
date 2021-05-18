package ru.training.at.hw4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


public class MainPage extends BasePage {

    public HeaderMenu headerMenu;
    public LeftSectionBar leftSectionBar;

    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement login;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(css = "div.row.clerafix.benefits span.icons-benefit")
    private List<WebElement> benefitIcons;
    @FindBy(css = "div.row.clerafix.benefits span.benefit-txt")
    private List<WebElement> benefitDesc;
    @FindBy(tagName = "iframe")
    private List<WebElement> frames;


    public MainPage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
        leftSectionBar = new LeftSectionBar(driver);
    }

    public String openMainPage(String siteUrl) {
        driver.get(siteUrl);
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void login(String username, String pass) {
        userIcon.click();
        login.sendKeys(username);
        password.sendKeys(pass);
        loginButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }

    public List<Boolean> benefitIconsVisibility() {
        List<Boolean> iconsVisibility = benefitIcons.stream()
                .map(WebElement::isDisplayed).collect(Collectors.toList());
        return iconsVisibility;
    }

    public List<String> getBenefitDesc() {
        List<String> textOfBenefit = benefitDesc.stream()
                .map(WebElement::getText).collect(Collectors.toList());
        return textOfBenefit;
    }

    public int getQtyIframesWithFrameButton() {
        int counter = 0;
        for (int i = 0; i < frames.size(); i++) {
            driver.switchTo().frame(i);
            if (driver.findElements(By.id("frame-button")).size() != 0) {
                counter++;
            }
            driver.switchTo().defaultContent();
        }
        return counter;
    }

    public boolean frameButtonCheck() {
        driver.switchTo().frame("frame");
        try {
            driver.findElement(By.id("frame-button"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

}
