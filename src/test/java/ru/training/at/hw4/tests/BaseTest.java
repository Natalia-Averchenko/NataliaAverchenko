package ru.training.at.hw4.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.DataProviderForTests;
import ru.training.at.hw4.Driver;
import ru.training.at.hw4.pages.MainPage;
import ru.training.at.hw4.pages.ServiceDiffElemPage;
import ru.training.at.hw4.steps.CommonSteps;
import ru.training.at.hw4.steps.StepsExercise1;
import ru.training.at.hw4.steps.StepsExercise2;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected MainPage mainPage;
    protected ServiceDiffElemPage serviceDiffElemPage;
    protected CommonSteps commonSteps;
    protected StepsExercise1 stepsExercise1;
    protected StepsExercise2 stepsExercise2;

    @BeforeClass
    public void setup(ITestContext context) {

        driver = Driver.createDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
        mainPage = new MainPage(driver);
        serviceDiffElemPage = new ServiceDiffElemPage(driver);
        commonSteps = new CommonSteps(driver);
        stepsExercise1 = new StepsExercise1(driver);
        stepsExercise2 = new StepsExercise2(driver);
        context.setAttribute("driver", driver);
        DataProviderForTests.setProperties();
    }

    @AfterClass
    public void tearDown() {
        // 10/12 Close Browser
        driver.quit();
    }

}
