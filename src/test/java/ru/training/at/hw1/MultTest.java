package ru.training.at.hw1;

import org.testng.annotations.Test;
import ru.training.at.hw1.provider.DataProviderMultTest;

import static org.testng.Assert.assertEquals;
import static ru.training.at.hw1.Initial.calculator;

public class MultTest {

    @Test(dataProviderClass = DataProviderMultTest.class,
            dataProvider = "dataForMultLongTest")
    public void multTestLong(long x, long y, long result) {
        long actual = calculator.mult(x, y);
        assertEquals(actual, result, 0.001);
    }

}
