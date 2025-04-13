package com.letcode.automation.pages;

import com.central.framework.genericutils.DriverWait;
import com.central.framework.genericutils.JavaScriptOperations;
import com.central.framework.genericutils.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonPageObject {



    public static void navigateToCardLink(String cardName){
        By cardLocator=By.xpath(String.format("//div[./header/p[text()=' %s ']]/child::footer/a",cardName));
        DriverWait.waitElementToBeClickable(cardLocator,5);
        int index=cardName.equals("Table_Advance")?2:1;
        WebElement element= WebDriverActions.findElements(cardLocator).get(index);
        JavaScriptOperations.scrollToElement(cardLocator);
        element.click();
    }
}
