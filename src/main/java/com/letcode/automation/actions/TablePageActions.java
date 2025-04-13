package com.letcode.automation.actions;

import com.central.framework.genericutils.WebDriverActions;
import com.letcode.automation.pages.TablePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class TablePageActions {
    TablePage tablePage=new TablePage();
    int calculatedTotalFromShoppingListTable;

    public void fetchShoppingListTable(){
        Map<String,Integer> shoppingListTable=new HashMap<>();
        WebDriverActions.findElements(tablePage.getShoppingListTableRow()).forEach(row->{
            List<WebElement> columns=row.findElements(By.xpath("./td"));
            shoppingListTable.put(columns.get(0).getText(),Integer.parseInt(columns.get(1).getText()));
        });
        calculatedTotalFromShoppingListTable=shoppingListTable.values().stream().mapToInt(i -> i).sum();
    }

    public int fetchShoppingListTableTotal(){
        return Integer.parseInt(WebDriverActions.findElement(tablePage.getShoppingListTableFooterRow()).getText());
    }

    public boolean checkPresentOrAbsentCheckBox(String firstOrLastName){
        By presentOrAbsentCheckBoxLocator=tablePage.presentOrAbsentCheckBox(firstOrLastName);
        WebDriverActions.findElement(presentOrAbsentCheckBoxLocator).click();
        return WebDriverActions.findElement(presentOrAbsentCheckBoxLocator).isSelected();
    }


}
