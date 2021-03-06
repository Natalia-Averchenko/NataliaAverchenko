package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderMenu extends BasePage {

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> headerElements;
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 ul.dropdown-menu>li")
    private List<WebElement> serviceMenu;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public List<String> getTextHeaderElements() {
        List<String> textHeaderElements = headerElements.stream()
                .map(WebElement::getText).collect(Collectors.toList());
        return textHeaderElements;
    }

    public void clickHeaderMenuItem(String menuItem) {
        for (WebElement menuHeaderItem : headerElements) {
            if (menuItem.equals(menuHeaderItem.getText())) {
                menuHeaderItem.click();
                break;
            }
        }
    }

    public ServiceDiffElemPage clickDropDownMenuService(String serviceItem) {
        for (WebElement serviceMenuItem : serviceMenu) {
            if (serviceItem.equals(serviceMenuItem.getText())) {
                serviceMenuItem.click();
                break;
            }
        }
        return new ServiceDiffElemPage(driver);
    }

}
