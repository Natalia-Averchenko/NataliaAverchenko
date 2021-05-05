package ru.training.at.hw1.provider;

import org.testng.annotations.DataProvider;

public class DataProviderSubTest {

    @DataProvider
    public Object[][] dataForSubDoubleTest() {
        return new Object[][]{
                {3.14, 2.71, 0.43},
                {6, 1.32, 4.68}
        };
    }

}
