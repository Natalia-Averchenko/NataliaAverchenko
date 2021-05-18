package ru.training.at.hw4.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.DataProviderForTests;

import java.util.List;

public class Exercise1 extends BaseTest {

    @Test(dataProviderClass = DataProviderForTests.class,
            dataProvider = "dataForExercise1Test")
    @Epic(value = "Homework 4")
    @Feature(value = "Exercise 1 Test")
    @Story(value = "Check of log in, header section, "
            + "index page, iFrame, left section")
    public void ex1Test(String siteUrl, String expectedTitle,
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

        // 5. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        stepsExercise1.checkHeaderSection(headerList);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        stepsExercise1.checkImagesOnIndexPage();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        stepsExercise1.checkTextUnderIcons(benefitsList);

        // 8. Assert that there is the iframe with “Frame Button” exist
        stepsExercise1.checkIframeWithFrameButton();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        stepsExercise1.checkFrameButtonInTheIframe();

        // 10. Switch to original window back
        stepsExercise1.switchWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed
        // and they have proper text
        stepsExercise1.checkLeftSection(leftSectionList);

    }
}
