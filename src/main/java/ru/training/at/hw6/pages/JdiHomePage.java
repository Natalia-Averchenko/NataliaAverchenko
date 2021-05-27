package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.LoginForm;

public class JdiHomePage extends WebPage {

    public LoginForm loginForm;

    @FindBy(id = "user-icon")
    public Icon userIcon;
    @FindBy(id = "user-name")
    public Label userName;
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 a")
    public Menu headerMenu;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void checkUserLoggedIn(User user) {
        userName.is().text(user.getFullName());
    }

    public void openMetalsColorsPage() {
        headerMenu.select("METALS & COLORS");
    }
}
