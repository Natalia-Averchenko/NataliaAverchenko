package ru.training.at.hw6;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import ru.training.at.hw6.entities.MetalsColorsPageData;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DataProviderForMetalsColorsPageTest {

    @DataProvider
    public Object[][] dataForMetalsColorsTest() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, MetalsColorsPageData> data = null;
        try {
            data = mapper.readValue(
                    new File("src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json"),
                    new TypeReference<Map<String, MetalsColorsPageData>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] dataForTest = new Object[data.size()][1];;
        int i = 0;
        for (Map.Entry<String, MetalsColorsPageData> entry : data.entrySet()) {
            dataForTest[i][0] = entry.getValue();
            i++;
        }
        return dataForTest;
    }

}
