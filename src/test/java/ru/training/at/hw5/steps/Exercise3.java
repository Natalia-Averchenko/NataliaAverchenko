package ru.training.at.hw5.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.ServiceUserTablePage;

public class Exercise3 {

    @When("I select 'vip' checkbox for {string}")
    public void selectCheckboxForUser(String user) {
        new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).clickOnVipButtonForUser(user);
    }

    @Then("{int} log row has {string} text in log section")
    public void checkLogSection(int qty, String logRow) {
        Assert.assertEquals((new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).getQtyOfItemsInLog()), qty);
        Assert.assertEquals((new ServiceUserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER)).getLogContent()), logRow);
    }
}
