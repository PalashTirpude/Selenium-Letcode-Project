package com.letcode.automation.test;

import com.central.framework.assertutil.CustomAssert;
import com.letcode.automation.actions.AlertPageActions;
import com.letcode.automation.listeners.BaseClassListener;
import com.letcode.automation.listeners.TestListener;
import com.letcode.automation.pages.CommonPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({BaseClassListener.class, TestListener.class})
public class AlertTest {
    AlertPageActions alertPageActions;
    @BeforeClass
    public void setup(){
        alertPageActions=new AlertPageActions();
    }
    @Test(priority = 1)
    public void validateSimpleAlert(){
//        ExtentReportManager.createTest("Validate user able to accept Simple Alert popup");
        CommonPageObject.navigateToCardLink("Alert");

        alertPageActions.clickSimpleAlertButton();
        CustomAssert.assertEqualsHard(alertPageActions.getSimpleAlertMessage(),"Hey! Welcome to LetCode","Check Welcome Message");
//        Assert.assertEquals(alertPageActions.getSimpleAlertMessage(),"Hey! Welcome to LetCode");
        alertPageActions.acceptAlert();
    }

    @Test(priority =2)
    public void validateConfirmAlert(){
//        ExtentReportManager.createTest("Validate user able to dismiss or accept the alert popup");
        alertPageActions.clickOnConfirmAlertButton();
        alertPageActions.dismissAlert();
        alertPageActions.clickOnConfirmAlertButton();
        alertPageActions.acceptAlert();
    }

}
