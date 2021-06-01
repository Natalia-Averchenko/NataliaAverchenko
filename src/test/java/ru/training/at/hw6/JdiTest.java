package ru.training.at.hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.training.at.hw6.entities.MetalsColorsPageData;
import ru.training.at.hw6.entities.User;

public class JdiTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }


    @Test(dataProviderClass = DataProviderForMetalsColorsPageTest.class,
            dataProvider = "dataForMetalsColorsTest")
    public void testMetalsColorsPage(MetalsColorsPageData metalsColorsData) {
        JdiSite.open();
        JdiSite.login(User.ROMAN);
        JdiSite.jdiHomePage.checkUserLoggedIn(User.ROMAN);
        JdiSite.jdiHomePage.openMetalsColorsPage();
        JdiSite.metalsColorsPage.checkOpened();
        JdiSite.metalsColorsPage.fill(metalsColorsData);
        JdiSite.metalsColorsPage.submit();
        Assert.assertEquals(metalsColorsData.getMapFromJsonData(),
                JdiSite.metalsColorsPage.getResult());
        JdiSite.metalsColorsPage.logout();
    }

}
