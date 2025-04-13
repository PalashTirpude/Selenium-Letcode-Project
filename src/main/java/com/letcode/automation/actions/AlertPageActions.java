package com.letcode.automation.actions;

import com.aventstack.extentreports.Status;
import com.central.framework.genericutils.DriverWait;
import com.central.framework.genericutils.WebDriverActions;
import com.central.framework.reportutils.ExtentReportManager;
import com.central.framework.selenium.DriverInitializer;
import com.letcode.automation.pages.AlertPage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
@Slf4j
@Getter
public class AlertPageActions {
    private String simpleAlertMessage;
    AlertPage alertPage=new AlertPage();
    WebDriver driver=DriverInitializer.getWebDriver();

    public void clickSimpleAlertButton(){
        DriverWait.waitElementToBeClickable(alertPage.getSimpleAlertButtonLocator(),5);
        WebDriverActions.findElement(alertPage.getSimpleAlertButtonLocator()).click();
        ExtentReportManager.getTest().log(Status.INFO,"Clicked on Simple Alert button.");
        DriverWait.waitAlertIsPresent(5);
        Alert alert=driver.switchTo().alert();
        simpleAlertMessage=alert.getText();
        ExtentReportManager.getTest().log(Status.INFO,"Fetched Simple Alert message : Hey! Welcome to LetCode");
    }

    public void clickOnConfirmAlertButton(){
        DriverWait.waitElementToBeClickable(alertPage.getConfirmAlertLocator(),5);
        WebDriverActions.findElement(alertPage.getConfirmAlertLocator()).click();
        ExtentReportManager.getTest().log(Status.INFO,"Clicked on Confirm Alert button.");
    }

    public void clickOnPromptAlert(){
        DriverWait.waitElementToBeClickable(alertPage.getPromptAlertLocator(),5);
        WebDriverActions.findElement(alertPage.getPromptAlertLocator()).click();
        ExtentReportManager.getTest().log(Status.INFO,"Clicked on Prompt Alert button.");
    }

    public void inputEnterYourName(String inputName){
        DriverWait.waitAlertIsPresent(5);
        driver.switchTo().alert().sendKeys(inputName);
        ExtentReportManager.getTest().log(Status.INFO,"Inserted Name : %s in alert input field".formatted(inputName));
    }

    public String fetchNotificationInfoForPromptAlert(){
        acceptAlert();
        DriverWait.waitVisibilityOfElementLocated(alertPage.getPromptAlertLocator(),5);
        return WebDriverActions.findElement(alertPage.getYourNameMessageLocator()).getText();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
        ExtentReportManager.getTest().log(Status.INFO,"Alert Accepted");
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
        ExtentReportManager.getTest().log(Status.INFO,"Alert Dismissed");
    }


}
