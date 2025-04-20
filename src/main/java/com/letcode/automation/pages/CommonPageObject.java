package com.letcode.automation.pages;

import com.central.framework.genericutils.DriverWait;
import com.central.framework.genericutils.JavaScriptOperations;
import com.central.framework.genericutils.WebDriverActions;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
@Slf4j
public class CommonPageObject {



    public static void navigateToCardLink(String cardName){
        String xpath=String.format("//div[./header/p[text()=' %s ']]/child::footer/a",cardName);
        By cardLocator=By.xpath(xpath);
        DriverWait.waitElementToBeClickable(cardLocator,5);
//        int index=cardName.equals("Table_Advance")?1:0;
//        WebElement element= WebDriverActions.findElements(cardLocator).get(index);
        JavaScriptOperations.clickElement(cardLocator);
    }
}
