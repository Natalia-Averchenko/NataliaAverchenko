package ru.training.at.hw9;

import org.testng.annotations.DataProvider;

public class DataProviderTrelloTest {

    @DataProvider
    public Object[][] dataForTableCreatingTest() {
        return new Object[][]{
                {"FirstTable"}
        };
    }


    @DataProvider
    public Object[][] dataForListCreatingTest() {
        return new Object[][]{
                {"FirstList"}
        };
    }

}
