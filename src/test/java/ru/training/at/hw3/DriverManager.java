package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverManager {

    protected WebDriver driver;

    protected DriverManager(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
