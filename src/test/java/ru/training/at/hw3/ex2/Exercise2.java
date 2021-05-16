package ru.training.at.hw3.ex2;

import org.testng.annotations.Test;
import ru.training.at.hw3.BaseTest;
import ru.training.at.hw3.DataProviderForTests;
import ru.training.at.hw3.pages.ServiceDiffElemPage;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 extends BaseTest {


    @Test(dataProviderClass = DataProviderForTests.class,
            dataProvider = "dataForExercise2Test")
    public void ex2Test(String siteUrl, String expectedTitle,
                        String username, String pass, String firstLastNames, String service,
                        String diffElements, String water, String wind, String selen,
                        List<String> expectedLogContent) {


        initTest(siteUrl, expectedTitle,
                username, pass, firstLastNames);

        // 5. Open through the header menu Service -> Different Elements Page
        mainPage.headerMenu.clickHeaderMenuItem(service);
        ServiceDiffElemPage serviceDiffElemPage =
                mainPage.headerMenu.clickDropDownMenuService(diffElements);

        // 6. Select checkboxes Water, Wind
        serviceDiffElemPage.clickCheckBoxRow1Element(water);
        serviceDiffElemPage.clickCheckBoxRow1Element(wind);

        // 7. Select radio - Selen
        serviceDiffElemPage.clickCheckBoxRow2Element(selen);

        // 8. Select in dropdown - Yellow
        serviceDiffElemPage.selectColor("Yellow");

        // 9. Assert change log
        List<String> textOfLog = serviceDiffElemPage.getLogText();
        textOfLog = textOfLog.stream().map(s -> s.substring(9)).collect(Collectors.toList());
        softAssert.assertEquals(textOfLog, expectedLogContent);

        softAssert.assertAll();

    }
}