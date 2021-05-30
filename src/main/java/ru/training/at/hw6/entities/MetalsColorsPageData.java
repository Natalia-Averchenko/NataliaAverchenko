package ru.training.at.hw6.entities;

import java.util.HashMap;
import java.util.Map;

public class MetalsColorsPageData {

    public MetalsColorsPageData() {
    }

    public MetalsColorsPageData(int[] summary, String[] elements,
                                String color, String metals, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;


    public int getRadioOdd() {
        if (summary[0] == 1) {
            return summary[0];
        } else {
            return summary[0] / 2 + 1;
        }
    }

    public int getRadioEven() {
        return summary[1] / 2;
    }

    public int[] getSummary() {
        return summary;
    }

    public String[] getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    public Map<String, String> getMapFromJsonData() {
        Map<String, String> dataFromJson = new HashMap<>();
        dataFromJson.put("Summary", Integer.toString(this.getSummary()[0] + this.getSummary()[1]));
        dataFromJson.put("Color", this.getColor());
        dataFromJson.put("Metal", this.getMetals());

        String stringOfElements = "";
        for (String s : this.elements) {
            stringOfElements = stringOfElements + s + ", ";
        }
        stringOfElements = stringOfElements.substring(0, stringOfElements.length() - 2);
        dataFromJson.put("Elements", stringOfElements);

        String stringOfVegetables = "";
        for (String s : this.vegetables) {
            stringOfVegetables = stringOfVegetables + s + ", ";
        }
        stringOfVegetables = stringOfVegetables.substring(0, stringOfVegetables.length() - 2);
        dataFromJson.put("Vegetables", stringOfVegetables);

        return dataFromJson;
    }
}
