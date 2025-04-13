package com.letcode.automation.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class TablePage {

    private final By shoppingListTableRow=By.xpath("//table[@id='shopping']/tbody/tr");
    private final By shoppingListTableFooterRow=By.xpath("//table[@id='shopping']/tfoot/td[2]/b");

    public By presentOrAbsentCheckBox(String firstOrLastName){
        return By.xpath("//table[@id='simpletable']/tbody/tr[./td[text()='%s']]/td[4]/input".formatted(firstOrLastName));
    }
//    private final By simpleAlertButtonLocator=By.xpath("aaaaa");
//    private final By simpleAlertButtonLocator=By.xpath("aaaaa");
//    private final By simpleAlertButtonLocator=By.xpath("aaaaa");
//    private final By simpleAlertButtonLocator=By.xpath("aaaaa");
//    private final By simpleAlertButtonLocator=By.xpath("aaaaa");
//    private final By simpleAlertButtonLocator=By.xpath("aaaaa");
//    private final By simpleAlertButtonLocator=By.xpath("aaaaa");
//    private final By simpleAlertButtonLocator=By.xpath("aaaaa");
}
