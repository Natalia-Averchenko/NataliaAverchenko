package ru.training.at.hw1;

import org.testng.annotations.Test;
import ru.training.at.hw1.provider.DataProviderSumTest;

import static org.testng.Assert.assertEquals;
import static ru.training.at.hw1.Initial.calculator;

public class SumTest {

    @Test(dataProviderClass = DataProviderSumTest.class,
            dataProvider = "dataForSumLongTest")
    public void sumTestLong(long x, long y, long result) {
        long actual = calculator.sum(x, y);
        assertEquals(actual, result);
    }

}
