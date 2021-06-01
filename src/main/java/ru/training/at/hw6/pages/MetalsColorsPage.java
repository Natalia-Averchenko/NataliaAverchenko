package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import ru.training.at.hw6.entities.MetalsColorsPageData;
import ru.training.at.hw6.forms.MetalsColorsForm;

import java.util.HashMap;
import java.util.Map;

public class MetalsColorsPage extends WebPage {

    @FindBy(id = "user-icon")
    public Icon userIcon;
    @FindBy(css = "div.logout button")
    public Button logout;
    @FindBy(css = "div.info-panel-section ul.panel-body-list.results li")
    public WebList actualResultBox;

    public MetalsColorsForm metalsColorsForm;

    public void fill(MetalsColorsPageData metalsColorsData) {
        metalsColorsForm.fill(metalsColorsData);
    }

    public void submit() {
        metalsColorsForm.submitButton.click();
    }


    public void logout() {
        userIcon.click();
        logout.click();
    }

    public Map<String, String> getResult() {
        Map<String, String> actualResultMap = new HashMap<>();
        for (UIElement line : actualResultBox) {
            String field = line.getText().substring(0, line.getText().indexOf(':'));
            String value = line.getText().substring(line.getText().indexOf(':') + 2);
            actualResultMap.put(field, value);
        }
        return actualResultMap;
    }
}
