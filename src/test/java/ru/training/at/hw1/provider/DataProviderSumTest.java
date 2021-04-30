package ru.training.at.hw1.provider;

import org.testng.annotations.DataProvider;

public class DataProviderSumTest {

    @DataProvider
    public Object[][] dataForSumLongTest() {
        return new Object[][]{
                {15, 5, 20},
                {-2000, 1500, -500}
        };
    }

}
