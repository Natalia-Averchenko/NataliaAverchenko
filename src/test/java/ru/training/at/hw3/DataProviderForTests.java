package ru.training.at.hw3;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class DataProviderForTests {

    protected final String siteUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String expectedTitle = "Home Page";
    protected final String username = "Roman";
    protected final String pass = "Jdi1234";
    protected final String firstLastNames = "ROMAN IOVLEV";

    protected final String service = "SERVICE";
    protected final String diffElements = "DIFFERENT ELEMENTS";
    protected final String water = "Water";
    protected final String wind = "Wind";
    protected final String selen = "Selen";

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
    public Object[][] dataForExercise2Test() {
        return new Object[][]{
            {siteUrl, expectedTitle, username, pass, firstLastNames, service,
                diffElements, water, wind, selen, expectedLogContent}
        };
    }
}
