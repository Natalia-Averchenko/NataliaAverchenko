package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw3.DriverManager;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceDiffElemPage extends DriverManager {

    @FindBy(css = "div.main-content label.label-checkbox")
    protected List<WebElement> checkBoxRow1;
    @FindBy(css = "div.main-content label.label-radio")
    protected List<WebElement> checkboxRow2;
    @FindBy(css = "div.colors select.uui-form-element option")
    protected List<WebElement> colorList;
    @FindBy(css = "div.info-panel-section ul.panel-body-list.logs li")
    protected List<WebElement> log;


    public ServiceDiffElemPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckBoxRow1Element(String boxItem) {
        for (WebElement checkBoxItem : checkBoxRow1) {
            if (boxItem.equals(checkBoxItem.getText())) {
                checkBoxItem.click();
                break;
            }
        }
    }

    public void clickCheckBoxRow2Element(String boxItem) {
        for (WebElement checkBoxItem : checkboxRow2) {
            if (boxItem.equals(checkBoxItem.getText())) {
                checkBoxItem.click();
                break;
            }
        }
    }

    public void selectColor(String color) {
        for (WebElement colorItem : colorList) {
            if (color.equals(colorItem.getText())) {
                colorItem.click();
                break;
            }
        }
    }

    public List<String> getLogText() {
        List<String> logText = log.stream()
                .map(WebElement::getText).collect(Collectors.toList());
        return logText;
    }

}
