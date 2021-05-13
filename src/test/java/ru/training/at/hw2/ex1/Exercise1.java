package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw2.CommonEx1Ex2;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class Exercise1 extends CommonEx1Ex2 {

    @Test
    public void webDriverStart() {

        initTest();

        // 5. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        List<WebElement> headerElements = driver
                .findElements(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li"));
        List<String> textHeaderElements = headerElements.stream()
                .map(WebElement::getText).collect(Collectors.toList());
        assertEquals(textHeaderElements, headerList);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver
                .findElements(By.cssSelector("div.row.clerafix.benefits span.icons-benefit"));
        for (int i = 0; i < 4; i++) {
            assertTrue(benefitIcons.get(i).isDisplayed());
        }

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String firstBenefit = "To include good practices\n"
                + "and ideas from successful\n" + "EPAM project";
        String secondBenefit = "To be flexible and\n" + "customizable";
        String thirdBenefit = "To be multiplatform";
        String fourthBenefit = "Already have good base\n" + "(about 20 internal and\n"
                + "some external projects),\n" + "wish to get more…";
        String[] benefits = {firstBenefit, secondBenefit, thirdBenefit, fourthBenefit};
        List<WebElement> benefitDesc = driver
                .findElements(By.cssSelector("div.row.clerafix.benefits span.benefit-txt"));
        for (int i = 0; i < 4; i++) {
            assertEquals(benefitDesc.get(i).getText(), benefits[i]);
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        int counter = 0;
        for (int i = 0; i < frames.size(); i++) {
            driver.switchTo().frame(i);
            if (driver.findElements(By.id("frame-button")).size() != 0) {
                counter++;
            }
            driver.switchTo().defaultContent();
        }
        assertNotEquals(counter, 0);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        assertNotNull(frameButton);

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed
        // and they have proper text
        WebElement leftSectionBar =
                driver.findElement(By.cssSelector(".sidebar-menu.left"));

        List<WebElement> searchElementHome =
                leftSectionBar.findElements(By.xpath("//span[text()='Home']"));
        assertFalse(searchElementHome.isEmpty());

        List<WebElement> searchElementContact =
                leftSectionBar.findElements(By.xpath("//span[text()='Contact form']"));
        assertFalse(searchElementContact.isEmpty());

        List<WebElement> searchElementService =
                leftSectionBar.findElements(By.xpath("//span[text()='Service']"));
        assertFalse(searchElementService.isEmpty());

        List<WebElement> searchElementMetals =
                leftSectionBar.findElements(By.xpath("//span[text()='Metals & Colors']"));
        assertFalse(searchElementMetals.isEmpty());

        List<WebElement> searchElementElementsPacks =
                leftSectionBar.findElements(By.xpath("//span[text()='Elements packs']"));
        assertFalse(searchElementElementsPacks.isEmpty());

    }
}
