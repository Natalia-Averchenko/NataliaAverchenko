package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.*;

public class StepsExercise1 extends CommonSteps {

    public StepsExercise1(WebDriver driver) {
        super(driver);
    }

    @Step("Assert that there are 4 items on the header section are displayed\n"
            + "    // and they have proper texts")
    public void checkHeaderSection(List<String> headerList) {
        assertEquals(mainPage.headerMenu.getTextHeaderElements(), headerList);
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void checkImagesOnIndexPage() {
        for (Boolean iconsVisibility : mainPage.benefitIconsVisibility()) {
            assertTrue(iconsVisibility);
        }
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void checkTextUnderIcons(List<String> benefitsList) {
        assertEquals(mainPage.getBenefitDesc(), benefitsList);
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void checkIframeWithFrameButton() {
        assertNotEquals(mainPage.getQtyIframesWithFrameButton(), 0);
    }

    @Step("Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void checkFrameButtonInTheIframe() {
        assertTrue(mainPage.frameButtonCheck());
    }

    @Step("Switch to original window back")
    public void switchWindow() {
        mainPage.switchToOriginalWindow();
    }

    @Step("Assert that there are 5 items in the Left Section are displayed\n"
            + "    // and they have proper text")
    public void checkLeftSection(List<String> leftSectionList) {
        assertEquals(mainPage.leftSectionBar.getItemsTextLeftBar(), leftSectionList);
    }

}
