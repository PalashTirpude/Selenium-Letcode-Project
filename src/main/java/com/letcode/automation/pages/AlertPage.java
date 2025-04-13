package com.letcode.automation.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class AlertPage {
   private final By simpleAlertButtonLocator=By.xpath("//button[text()='Simple Alert']");
   private final By confirmAlertLocator=By.xpath("//button[text()='Prompt Alert']");
   private final By promptAlertLocator=By.xpath("//button[text()='Simple Alert']");
   private final By yourNameMessageLocator=By.xpath("//div/p[contains(text(),'Your name is: ')]");
   private final By modernAlertLocator=By.xpath("//button[text()='Modern Alert']");
}
