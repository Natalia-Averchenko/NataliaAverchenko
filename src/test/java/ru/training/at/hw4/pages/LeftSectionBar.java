package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class LeftSectionBar extends BasePage {

    @FindBy(css = "ul.sidebar-menu.left>li>a>span")
    private List<WebElement> leftSectionBar;

    public LeftSectionBar(WebDriver driver) {
        super(driver);
    }

    public List<String> getItemsTextLeftBar() {
        List<String> itemsTextLeftBar = leftSectionBar.stream()
                .map(WebElement::getText).collect(Collectors.toList());
        return itemsTextLeftBar;
    }
}
