package ru.training.at.hw3.ex2;

import org.testng.annotations.Test;
import ru.training.at.hw3.BaseTest;
import ru.training.at.hw3.pages.ServiceDiffElemPage;

import java.util.List;

public class Exercise2 extends BaseTest {

    protected final String service = "SERVICE";
    protected final String diffElements = "DIFFERENT ELEMENTS";
    protected final String water = "Water";
    protected final String wind = "Wind";
    protected final String selen = "Selen";

    @Test
    public void ex2Test() throws InterruptedException {
        initTest();

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

        // 9. Assert that
        List<String> textOfLog = serviceDiffElemPage.getLogText();
        softAssert.assertTrue(textOfLog.get(0).contains("value changed to Yellow"));
        softAssert.assertTrue(textOfLog.get(1).contains("value changed to Selen"));
        softAssert.assertTrue(textOfLog.get(2).contains("condition changed to true"));
        softAssert.assertTrue(textOfLog.get(3).contains("condition changed to true"));
        softAssert.assertAll();

    }
}