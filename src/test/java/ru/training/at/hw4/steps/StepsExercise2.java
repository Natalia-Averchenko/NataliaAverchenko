package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.pages.ServiceDiffElemPage;

import java.util.List;
import java.util.stream.Collectors;

public class StepsExercise2 extends CommonSteps {

    protected SoftAssert softAssert;
    protected ServiceDiffElemPage serviceDiffElemPage;

    public StepsExercise2(WebDriver driver) {
        super(driver);
        softAssert = new SoftAssert();
        serviceDiffElemPage = new ServiceDiffElemPage(driver);
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openServiceDiffElemPage(String service, String diffElements) {
        mainPage.headerMenu.clickHeaderMenuItem(service);
        mainPage.headerMenu.clickDropDownMenuService(diffElements);
    }

    @Step("Select checkboxes Water, Wind")
    public void selectCheckboxes(String checkBoxElement) {
        serviceDiffElemPage.clickCheckBoxRow1Element(checkBoxElement);
    }

    @Step("Select radio - Selen")
    public void selectRadioSelen(String selen) {
        serviceDiffElemPage.clickCheckBoxRow2Element(selen);
    }


    @Step("Select in dropdown - Yellow")
    public void selectYellow(String color) {
        serviceDiffElemPage.selectColor(color);
    }


    @Step("Assert log content")
    public void assertLogContent(List<String> expectedLogContent) {
        List<String> textOfLog = serviceDiffElemPage.getLogText();
        textOfLog = textOfLog.stream().map(s -> s.substring(9)).collect(Collectors.toList());
        softAssert.assertEquals(textOfLog, expectedLogContent);
    }

    @Step("Assert all")
    public void assertAll() {
        softAssert.assertAll();
    }

}
