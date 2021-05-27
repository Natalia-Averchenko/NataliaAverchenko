package ru.training.at.hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceUserTablePage extends BasePage {

    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private List<WebElement> numberList;

    @FindBy(css = "table tbody tr td select")
    private List<WebElement> dropdownList;

    @FindBy(css = "table tbody tr td a")
    private List<WebElement> usernamesList;

    @FindBy(css = "table tbody tr td div span")
    private List<WebElement> descriptionList;

    @FindBy(css = "table tbody tr td div input")
    private List<WebElement> checkboxesList;

    @FindBy(css = "table tbody tr td select option")
    private List<WebElement> droplistOfTypesForRoman;

    @FindBy(css = "div.info-panel-section ul.panel-body-list.logs li")
    private List<WebElement> log;

    @FindBy(css = "table tbody tr")
    private List<WebElement> rowWithUserData;

    public ServiceUserTablePage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<String> getNumberList() {
        List<String> numbers = numberList.stream()
                .map(WebElement::getText).collect(Collectors.toList());
        return numbers;
    }

    public int getSizeDropdownList() {
        return dropdownList.size();
    }

    public int getSizeUsernamesList() {
        return usernamesList.size();
    }

    public List<String> getUsernamesList() {
        List<String> users = usernamesList.stream()
                .map(WebElement::getText).collect(Collectors.toList());
        return users;
    }

    public int getSizeDescriptionList() {
        return descriptionList.size();
    }

    public List<String> getDescriptionList() {
        List<String> descriptions = descriptionList.stream()
                .map(WebElement::getText).map(s -> s.replace("\n", " "))
                .collect(Collectors.toList());
        return descriptions;
    }

    public int getSizeCheckboxesList() {
        return checkboxesList.size();
    }

    public List<String> getDroplistOfTypesForRoman() {
        List<String> listOfTypes = droplistOfTypesForRoman.stream()
                .map(WebElement::getText).collect(Collectors.toList());
        return listOfTypes;
    }

    public int getQtyOfItemsInLog() {
        return log.size();
    }

    public String getLogContent() {
        return log.get(0).getText().substring(9);
    }

    public void clickOnVipButtonForUser(String user) {
        for (WebElement w : rowWithUserData) {
            if (user.equals(w.findElement(By.cssSelector("td a")).getText())) {
                w.findElement(By.cssSelector("td div input")).click();
                break;
            }
        }

    }
}


