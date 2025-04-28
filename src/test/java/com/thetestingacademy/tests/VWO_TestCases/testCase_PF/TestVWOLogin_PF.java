package com.thetestingacademy.tests.VWO_TestCases.testCase_PF;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.pages.pageFactory.LoginPage_PF;
import com.thetestingacademy.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_PF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);

    @Test
    public void testLoginNegativeVWO_PF(){

        logger.info("Starting the TestCases PageFactory");

        WebDriver driver  = DriverManager.getDriver();
        driver.get(PropertiesReader.readKey("url"));

        LoginPage_PF loginPage_pf = new LoginPage_PF(driver);
        String error_msg = loginPage_pf.loginToVWOInvalidCreds();

        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

        logger.info("End of the TestCases PageFactory");
    }

}
