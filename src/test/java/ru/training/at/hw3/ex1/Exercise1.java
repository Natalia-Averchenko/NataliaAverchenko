package ru.training.at.hw3.ex1;

import org.testng.annotations.Test;
import ru.training.at.hw3.BaseTest;

import static org.testng.Assert.*;

public class Exercise1 extends BaseTest {

    @Test
    public void ex1Test() {
        initTest();

        // 5. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        assertEquals(mainPage.headerMenu.getTextHeaderElements(), headerList);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        for (Boolean iconsVisibility : mainPage.benefitIconsVisibility()) {
            assertTrue(iconsVisibility);
        }
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String firstBenefit = "To include good practices\n"
                + "and ideas from successful\n" + "EPAM project";
        String secondBenefit = "To be flexible and\n" + "customizable";
        String thirdBenefit = "To be multiplatform";
        String fourthBenefit = "Already have good base\n" + "(about 20 internal and\n"
                + "some external projects),\n" + "wish to get more…";
        String[] benefits = {firstBenefit, secondBenefit, thirdBenefit, fourthBenefit};
        int i = 0;
        for (String textOfBenefit : mainPage.getBenefitDesc()) {
            assertEquals(textOfBenefit, benefits[i]);
            i++;
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        assertNotEquals(mainPage.getQtyIframesWithFrameButton(), 0);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertTrue(mainPage.frameButtonCheck());

        // 10. Switch to original window back
        mainPage.switchToOriginalWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed
        // and they have proper text
        assertEquals(mainPage.leftSectionBar.getItemsTextLeftBar(), leftSectionList);

    }
}
