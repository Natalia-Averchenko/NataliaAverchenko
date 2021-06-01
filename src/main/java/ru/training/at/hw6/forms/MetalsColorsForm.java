package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.entities.MetalsColorsPageData;

public class MetalsColorsForm extends Form<MetalsColorsPageData> {

    @FindBy(name = "custom_radio_odd")
    public RadioButtons radioOdd;

    @FindBy(name = "custom_radio_even")
    public RadioButtons radioEven;

    @UI("#elements-checklist input[type=checkbox]")
    public Checklist elements;
    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colors;

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;


    @JDropdown(root = "#vegetables",
            value = "#salad-dropdown>button.dropdown-toggle",
            list = "li",
            expand = ".caret")
    public Dropdown vegetables;


    @FindBy(id = "submit-button")
    public static Button submitButton;

    @Override
    public void fill(MetalsColorsPageData metalsColorsData) {
        radioOdd.select(metalsColorsData.getRadioOdd());
        radioEven.select(metalsColorsData.getRadioEven());
        elements.select(metalsColorsData.getElements());
        colors.select(metalsColorsData.getColor());
        metals.select(metalsColorsData.getMetals());
        vegetables.select("Vegetables");
        vegetables.select(metalsColorsData.getVegetables());
    }

}
