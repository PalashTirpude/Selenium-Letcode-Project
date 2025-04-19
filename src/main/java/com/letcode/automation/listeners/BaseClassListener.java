package com.letcode.automation.listeners;

import com.central.framework.selenium.DriverInitializer;
import com.central.framework.selenium.LoadProperties;
import lombok.extern.slf4j.Slf4j;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class BaseClassListener implements ISuiteListener {
    public static Map<String,String> testParameters;
    private Properties driverProperties;
    @Override
    public void onStart(ISuite suite) {
        testParameters=new HashMap<>();
        driverProperties= LoadProperties.fromFile("src/test/resources/driver-config.properties");
        XmlSuite xmlSuite=suite.getXmlSuite();
        testParameters.put("browser",xmlSuite.getParameter("browser"));
        testParameters.put("testName",xmlSuite.getParameter("testName"));
        DriverInitializer.initializeWebDriver(testParameters.get("browser"),"src/test/resources/driver-config.properties");
        DriverInitializer.getWebDriver().get(driverProperties.getProperty("driver.letcode.url"));

    }

    @Override
    public void onFinish(ISuite suite) {
        DriverInitializer.quitWebDriver();
        try {
            Runtime.getRuntime().exec(driverProperties.getProperty("driver.%s.driver.kill".formatted(testParameters.get("browser").toLowerCase())));
            Runtime.getRuntime().exec(driverProperties.getProperty("driver.%s.browser.kill".formatted(testParameters.get("browser").toLowerCase())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
