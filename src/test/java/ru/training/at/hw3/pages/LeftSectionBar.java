package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw3.DriverManager;

import java.util.List;
import java.util.stream.Collectors;

public class LeftSectionBar extends DriverManager {

    @FindBy(xpath = " //ul[@class='sidebar-menu left']/li/a")
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
