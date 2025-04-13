package com.letcode.automation.test;

import com.central.framework.assertutil.CustomAssert;
import com.letcode.automation.configs.SimpleTableConfig;
import com.letcode.automation.listeners.BaseClassListener;
import com.letcode.automation.listeners.TestListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({BaseClassListener.class, TestListener.class})
public class SimpleTableTest {

    private AnnotationConfigApplicationContext context;

    @BeforeSuite
    public void setup(){
        context=new AnnotationConfigApplicationContext(SimpleTableConfig.class);
    }

    @Test(priority =1, description = "Check summation of prices of items = Total in table footer")
    private void checkTotalPrice(){
        CustomAssert.assertEqualsHard(context.getBean("fetchShoppingListTableCalculatedTotalPrice",Integer.class)
                ,context.getBean("fetchShoppingListTableCalculatedTotalPrice",Integer.class),"Check TotalPrice");
    }

    @Test(priority =2, description = "Check Present/Absent checkBox is clicked for Raj")
    private void checkPresentOrAbsentCheckBoxIsClicked(){
        CustomAssert.assertTrueHard(context.getBean("selectPresentAbsentCheckBoxForRaj", Boolean.class),"Check CheckBox is selected");
    }
}
