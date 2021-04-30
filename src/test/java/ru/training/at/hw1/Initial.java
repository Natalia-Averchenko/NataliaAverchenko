package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Initial {

    public static Calculator calculator;

    @BeforeSuite
    public void createCalc() {
        calculator = new Calculator();
    }

    @AfterSuite
    public void deleteCalc() {
        calculator = null;
    }

}
