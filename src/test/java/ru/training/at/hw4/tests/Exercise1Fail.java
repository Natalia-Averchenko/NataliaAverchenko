package ru.training.at.hw4.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.DataProviderForTests;

import java.util.List;


public class Exercise1Fail extends BaseTest {

    @Test(dataProviderClass = DataProviderForTests.class,
            dataProvider = "dataForExercise1TestFail")
    @Epic(value = "Homework 4")
    @Feature(value = "Exercise 1 Test")
    @Story(value = "Test with incorrect displayed name")
    public void ex1TestFail(String siteUrl, String expectedTitle,
                            String username, String pass, String firstLastNames,
                            List<String> headerList, List<String> benefitsList,
                            List<String> leftSectionList) {

        // 1. Open test site by URL
        commonSteps.openPage(siteUrl);

        // 2. Assert Browser title ( Browser title equals "Home Page")
        commonSteps.checkTitle(expectedTitle);

        // 3. Perform login
        commonSteps.login(username, pass);

        // 4. Assert Username is loggined. Name is displayed and equals to expected result
        commonSteps.checkUserName(firstLastNames);

    }
}
