package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.training.at.hw2.CommonEx1Ex2;

import java.util.List;


public class Exercise2 extends CommonEx1Ex2 {
    @Test
    public void webDriverStart() {
        initTest();

        // 5. Open through the header menu Service -> Different Elements Page
        WebElement header = driver
                .findElement(By.cssSelector("header div.uui-header.dark-gray"));
        WebElement navBar = header
                .findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8"));
        navBar.findElement(By.cssSelector("a.dropdown-toggle")).click();
        navBar.findElement(By.cssSelector("ul.dropdown-menu"));
        navBar.findElement(By.xpath("//*[text()='Different elements']")).click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/different-elements.html");

        // 6. Select checkboxes Water, Wind
        List<WebElement> checkboxLabels = driver
                .findElements(By.cssSelector("div label.label-checkbox"));
        checkboxLabels.get(0).click();
        checkboxLabels.get(2).click();
        //softAssert.assertTrue(checkbox.get(0).isSelected());
        //softAssert.assertTrue(checkbox.get(0).isSelected());

        // 7. Select radio - Selen
        List<WebElement> checkboxRadio = driver.findElements(By.cssSelector("input[type=radio]"));
        checkboxRadio.get(3).click();

        // 8. Select in dropdown - Yellow
        // WebElement color = driver.findElement(By.cssSelector("select.uui-form-element"));
        new Select(driver.findElement(By.cssSelector("select.uui-form-element")))
                .selectByVisibleText("Yellow");

        // 9. Assert that
        WebElement log = driver.findElement(By.cssSelector("ul.panel-body-list.logs"));
        List<WebElement> listLog = log.findElements(By.tagName("li"));
        softAssert.assertTrue(listLog.get(0).getText().contains("value changed to Yellow"));
        softAssert.assertTrue(listLog.get(1).getText().contains("value changed to Selen"));
        softAssert.assertTrue(listLog.get(2).getText().contains("condition changed to true"));
        softAssert.assertTrue(listLog.get(3).getText().contains("condition changed to true"));
        softAssert.assertAll();
    }
}
