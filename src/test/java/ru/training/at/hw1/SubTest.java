package ru.training.at.hw1;

import org.testng.annotations.Test;
import ru.training.at.hw1.provider.DataProviderSubTest;

import static org.testng.Assert.assertEquals;


public class SubTest extends Initial {

    @Test(dataProviderClass = DataProviderSubTest.class,
            dataProvider = "dataForSubDoubleTest")
    public void subTestDouble(double x, double y, double result) {
        double actual = calculator.sub(x, y);
        assertEquals(actual, result, 0.0001);
    }

}
