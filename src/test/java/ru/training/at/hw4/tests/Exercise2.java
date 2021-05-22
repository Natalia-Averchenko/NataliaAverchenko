package ru.training.at.hw4.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.DataProviderForTests;

import java.util.List;

public class Exercise2 extends BaseTest {

    @Test(dataProviderClass = DataProviderForTests.class,
            dataProvider = "dataForExercise2Test")
    @Epic(value = "Homework 4")
    @Feature(value = "Exercise 2 Test")
    @Story("Check of log in, opening serviceDiffElemPage, "
            + "select of boxes and log content")
    public void ex2Test(String siteUrl, String expectedTitle,
                        String username, String pass, String firstLastNames, String service,
                        String diffElements, String water, String wind, String selen,
                        List<String> expectedLogContent) {

        // 1. Open test site by URL
        commonSteps.openPage(siteUrl);

        // 2. Assert Browser title ( Browser title equals "Home Page")
        commonSteps.checkTitle(expectedTitle);

        // 3. Perform login
        commonSteps.login(username, pass);

        // 4. Assert Username is loggined. Name is displayed and equals to expected result
        commonSteps.checkUserName(firstLastNames);

        // 5. Open through the header menu Service -> Different Elements Page
        stepsExercise2.openServiceDiffElemPage(service, diffElements);

        // 6. Select checkboxes Water, Wind
        stepsExercise2.selectCheckboxes(water);
        stepsExercise2.selectCheckboxes(wind);

        // 7. Select radio - Selen
        stepsExercise2.selectRadioSelen(selen);

        // 8. Select in dropdown - Yellow
        stepsExercise2.selectYellow("Yellow");

        // 9. Assert that
        stepsExercise2.assertLogContent(expectedLogContent);

        stepsExercise2.assertAll();
    }
}