package com.thetestingacademy.tests.VWO_TestCases.testCase_PF;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageFactory.LoginPage_PF;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin_PF extends CommonToAllTest {

    @Test
    public void testLoginNegativeVWO_PF(){

        WebDriver driver  = DriverManager.getDriver();
        driver.get(PropertiesReader.readKey("url"));

        LoginPage_PF loginPage_pf = new LoginPage_PF(driver);
        String error_msg = loginPage_pf.loginToVWOInvalidCreds();

        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

    }

}
