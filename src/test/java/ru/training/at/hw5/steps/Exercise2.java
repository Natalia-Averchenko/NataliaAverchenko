package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.MainPage;
import ru.training.at.hw5.pages.ServiceUserTablePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class Exercise2 {

    @Given("I open JDI GitHub site")
    public void openSite() {
        new MainPage(TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER))
                .openMainPage("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Given("I login as user {string}")
    public void login(String expectedName) {
        new MainPage(TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER))
                .login("Roman", "Jdi1234");
        String actualName = new MainPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).getUserName();
        assertThat(actualName).isEqualTo(expectedName);
    }

    @When("I click on {string} button in Header")
    public void clickHeaderButton(String headerElem) {
        new MainPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).headerMenu.clickHeaderMenuItem(headerElem);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickDropdownButton(String dropDownElem) throws InterruptedException {
        new MainPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))
                .headerMenu.clickDropDownMenuService(dropDownElem);
    }

    @Then("{string} page should be opened")
    public void checkOpenedPage(String expectedTitle) {
        assertThat((new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))).getTitle())
                .isEqualTo(expectedTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberTypeOnUserTablePage(int number) {
        assertThat((new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))).getSizeDropdownList())
                .isEqualTo(number);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkUsernamesQtyOnUserTablePage(int number) {
        assertThat((new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))).getSizeUsernamesList())
                .isEqualTo(number);
    }

    @Then("{int} Description texts under images should be "
            + "displayed on Users Table on User Table Page")
    public void checkDescTextsUnderImagesOnUsersTable(int number) {
        assertThat((new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))).getSizeDescriptionList())
                .isEqualTo(number);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkCheckboxesQtyOnUserTable(int number) {
        assertThat((new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER))).getSizeCheckboxesList())
                .isEqualTo(number);
    }

    @Then("User table should contain following values:")
    public void checkUserTableContent(List<List<String>> expectedUserTableValues) {
        List<String> numbers = new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).getNumberList();
        List<String> users = new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).getUsernamesList();
        List<String> descriptions = new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).getDescriptionList();
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(numbers.get(i), expectedUserTableValues.get(i + 1).get(0));
            Assert.assertEquals(users.get(i), expectedUserTableValues.get(i + 1).get(1));
            Assert.assertEquals(descriptions.get(i), expectedUserTableValues.get(i + 1).get(2));
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkDroplistValuesForRoman(List<String> expectedList) {
        assertTrue(expectedList.containsAll(new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).getDroplistOfTypesForRoman()));
    }
}
