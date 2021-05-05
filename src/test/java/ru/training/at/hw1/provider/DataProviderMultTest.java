package ru.training.at.hw1.provider;

import org.testng.annotations.DataProvider;

public class DataProviderMultTest {

    @DataProvider
    public Object[][] dataForMultLongTest() {
        return new Object[][]{
                {1, 0, 0},
                {178, -10000, -1780000}
        };
    }

}
