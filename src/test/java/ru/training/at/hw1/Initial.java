package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class Initial {

    protected Calculator calculator;

    @BeforeMethod
    public void createCalc() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void deleteCalc() {
        calculator = null;
    }

}
