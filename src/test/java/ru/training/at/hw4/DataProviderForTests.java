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

    protected static String h0;
    protected static String h1;
    protected static String h2;
    protected static String h3;
    protected static List<String> headerList;

    protected static String firstBenefit0;
    protected static String firstBenefit1;
    protected static String firstBenefit2;
    protected static String secondBenefit0;
    protected static String secondBenefit1;
    protected static String thirdBenefit;
    protected static String fourthBenefit0;
    protected static String fourthBenefit1;
    protected static String fourthBenefit2;
    protected static String fourthBenefit3;
    protected static List<String> benefitsList;

    protected static String home;
    protected static String contact;
    protected static String serviceLeftSection;
    protected static String mc;
    protected static String ep;
    protected static List<String> leftSectionList;

    protected static String colorsChanged;
    protected static String metalChanged;
    protected static String windChanged;
    protected static String waterChanged;
    protected static List<String> expectedLogContent;

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

            h0 = prop.getProperty("h0");
            h1 = prop.getProperty("h1");
            h2 = prop.getProperty("h2");
            h3 = prop.getProperty("h3");
            String[] header = {h0, h1, h2, h3};
            headerList = Arrays.asList(header);

            firstBenefit0 = prop.getProperty("firstBenefit0");
            firstBenefit1 = prop.getProperty("firstBenefit1");
            firstBenefit2 = prop.getProperty("firstBenefit2");
            secondBenefit0 = prop.getProperty("secondBenefit0");
            secondBenefit1 = prop.getProperty("secondBenefit1");
            thirdBenefit = prop.getProperty("thirdBenefit");
            fourthBenefit0 = prop.getProperty("fourthBenefit0");
            fourthBenefit1 = prop.getProperty("fourthBenefit1");
            fourthBenefit2 = prop.getProperty("fourthBenefit2");
            fourthBenefit3 = prop.getProperty("fourthBenefit3");
            String[] benefits = {firstBenefit0 + "\n" + firstBenefit1 + "\n" + firstBenefit2,
                secondBenefit0 + "\n" + secondBenefit1,
                thirdBenefit,
                fourthBenefit0 + "\n" + fourthBenefit1 + "\n" + fourthBenefit2
                    + "\n" + fourthBenefit3};
            benefitsList = Arrays.asList(benefits);

            home = prop.getProperty("home");
            contact = prop.getProperty("contact");
            serviceLeftSection = prop.getProperty("serviceLeftSection");
            mc = prop.getProperty("mc");
            ep = prop.getProperty("ep");
            String[] leftSection = {home, contact, serviceLeftSection, mc, ep};
            leftSectionList = Arrays.asList(leftSection);

            colorsChanged = prop.getProperty("colorsChanged");
            metalChanged = prop.getProperty("metalChanged");
            windChanged = prop.getProperty("windChanged");
            waterChanged = prop.getProperty("waterChanged");
            String[] log = {colorsChanged, metalChanged, windChanged, waterChanged};
            expectedLogContent = Arrays.asList(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
