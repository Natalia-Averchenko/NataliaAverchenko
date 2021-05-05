package ru.training.at.hw1.provider;

import org.testng.annotations.DataProvider;

public class DataProviderDivTest {

    @DataProvider
    public Object[][] dataForDivDoubleTest() {
        return new Object[][]{
                {3.14, 2.71, 1.15867},
                {-168, 0.01, -16800}
        };
    }

}
