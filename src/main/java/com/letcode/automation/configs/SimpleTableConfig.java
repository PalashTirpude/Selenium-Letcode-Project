package com.letcode.automation.configs;

import com.letcode.automation.actions.TablePageActions;
import com.letcode.automation.pages.CommonPageObject;
import org.springframework.context.annotation.Bean;

public class SimpleTableConfig {

    TablePageActions tablePageActions=new TablePageActions();

    @Bean
    public int fetchShoppingListTableCalculatedTotalPrice(){
        CommonPageObject.navigateToCardLink("Table");
        tablePageActions.fetchShoppingListTable();
        return tablePageActions.getCalculatedTotalFromShoppingListTable();
    }

    @Bean
    public int fetchShoppingListTableTotalPrice(){
        return tablePageActions.fetchShoppingListTableTotal();
    }

    @Bean
    public boolean selectPresentAbsentCheckBoxForRaj(){
        return tablePageActions.checkPresentOrAbsentCheckBox("Raj");
    }
}
