package ru.training.at.hw4;

import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class DataProviderForTests {

    private static final String PATH_TO_PROPERTIES =
            "src/test/resources/siteData.properties";
    protected static String siteUrl;
    protected static String expectedTitle;
    protected static String username;
    protected static String pass;
    protected static String firstLastNames;
    protected static String incorrectFirstLastNames;
    protected static String service;
    protected static String diffElements;
    protected static String water;
    protected static String wind;
    protected static String selen;
    protected static Properties prop;

    public static void setProperties() {
        prop = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            prop.load(fileInputStream);
            siteUrl = prop.getProperty("siteUrl");
            expectedTitle = prop.getProperty("expectedTitle");
            username = prop.getProperty("username");
            pass = prop.getProperty("pass");
            firstLastNames = prop.getProperty("firstLastNames");
            incorrectFirstLastNames = prop.getProperty("incorrectFirstLastNames");
            service = prop.getProperty("service");
            diffElements = prop.getProperty("diffElements");
            water = prop.getProperty("water");
            wind = prop.getProperty("wind");
            selen = prop.getProperty("selen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected final String[] header = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    protected final List<String> headerList = Arrays.asList(header);

    protected final String firstBenefit = "To include good practices\n"
            + "and ideas from successful\n" + "EPAM project";
    protected final String secondBenefit = "To be flexible and\n" + "customizable";
    protected final String thirdBenefit = "To be multiplatform";
    protected final String fourthBenefit = "Already have good base\n" + "(about 20 internal and\n"
            + "some external projects),\n" + "wish to get more…";
    protected final String[] benefits = {firstBenefit, secondBenefit, thirdBenefit, fourthBenefit};
    protected final List<String> benefitsList = Arrays.asList(benefits);

    protected final String mc = "Metals & Colors";
    protected final String ep = "Elements packs";
    protected final String[] leftSection = {"Home", "Contact form", "Service", mc, ep};
    protected final List<String> leftSectionList = Arrays.asList(leftSection);

    protected final String[] log = {"Colors: value changed to Yellow",
        "metal: value changed to Selen",
        "Wind: condition changed to true", "Water: condition changed to true"};
    protected final List<String> expectedLogContent = Arrays.asList(log);


    @DataProvider
    public Object[][] dataForExercise1Test() {
        return new Object[][]{
                {siteUrl, expectedTitle, username, pass, firstLastNames,
                    headerList, benefitsList, leftSectionList}
        };
    }


    @DataProvider
    public Object[][] dataForExercise1TestFail() {
        return new Object[][]{
                {siteUrl, expectedTitle, username, pass, incorrectFirstLastNames,
                    headerList, benefitsList, leftSectionList}
        };
    }

    @DataProvider
    public Object[][] dataForExercise2Test() {
        return new Object[][]{
                {siteUrl, expectedTitle, username, pass, firstLastNames, service,
                    diffElements, water, wind, selen, expectedLogContent}
        };
    }
}
