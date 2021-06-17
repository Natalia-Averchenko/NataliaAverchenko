package ru.training.at.hw9;

import org.testng.annotations.DataProvider;

import java.util.Random;

public class DataProviderTrelloTest {


    public static String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        int length = random.nextInt(10) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }


    @DataProvider
    public Object[][] dataForTableCreatingTest() {
        return new Object[][]{
                {getRandomString()}
        };
    }


    @DataProvider
    public Object[][] dataForListCreatingTest() {
        return new Object[][]{
                {getRandomString()}
        };
    }

}
