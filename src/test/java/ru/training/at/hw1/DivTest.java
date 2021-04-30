package ru.training.at.hw1;

import org.testng.annotations.Test;
import ru.training.at.hw1.provider.DataProviderDivTest;

import static org.testng.Assert.assertEquals;
import static ru.training.at.hw1.Initial.calculator;

public class DivTest {

    @Test(dataProviderClass = DataProviderDivTest.class,
            dataProvider = "dataForDivDoubleTest")
    public void divTestDouble(double x, double y, double result) {
        double actual = calculator.div(x, y);
        assertEquals(actual, result, 0.001);
    }
}
