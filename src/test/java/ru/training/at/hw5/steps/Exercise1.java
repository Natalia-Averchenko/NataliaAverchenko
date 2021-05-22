package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.MainPage;
import ru.training.at.hw5.pages.ServiceDiffElemPage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class Exercise1 {

    @Given("I Open test site by URL {string}")
    public void openSite(String siteUrl) {
        new MainPage(TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER))
                .openMainPage(siteUrl);
    }

    @When("I perform login with username {string} and password {string}")
    public void performLogin(String username, String pass) {
        new MainPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).login(username, pass);
    }

    @Then("User is logged. Name is displayed and equals to expected result {string}")
    public void checkDisplayedName(String expectedName) {
        String actualName = new MainPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).getUserName();
        assertThat(actualName).isEqualTo(expectedName);
    }

    @When("I click on {string} in the header menu on main page")
    public void clickOnButtonOnMainPage(String headerElem) {
        new MainPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).headerMenu.clickHeaderMenuItem(headerElem);
    }

    @When("I click on {string} in drop-down list")
    public void clickOnDropDownListElement(String dropDownElem) {
        new MainPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))
                .headerMenu.clickDropDownMenuService(dropDownElem);
    }

    @Then("Page with url {string} is opened")
    public void checkOpenedPageUrl(String expectedUrl) {
        String actualUrl = new ServiceDiffElemPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).getCurrentUrl();
        assertThat(actualUrl).isEqualTo(expectedUrl);
    }

    @When("I click on {string},{string} checkboxes")
    public void clickOnCheckBoxes(String str1, String str2) {
        new ServiceDiffElemPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).clickCheckBoxRow1Element(str1);
        new ServiceDiffElemPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).clickCheckBoxRow1Element(str2);
    }

    @When("I click on {string} radio")
    public void clickOnRadioItem(String str) {
        new ServiceDiffElemPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).clickCheckBoxRow2Element(str);
    }

    @When("I select {string} from drop-down list")
    public void selectColor(String color) {
        new ServiceDiffElemPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).selectColor(color);
    }

    @Then("Change log contains strings {string},{string}, {string}, {string}")
    public void checkChangeLogContent(String str0, String str1, String str2, String str3) {
        String[] changeLog = {str0, str1, str2, str3};
        List<String> changeLogList = Arrays.asList(changeLog);
        List<String> actualChangeLog = new ServiceDiffElemPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).getLogText();
        assertEquals(actualChangeLog, changeLogList);
    }
}
