package com.thetestingacademy.tests.OrangeHR_TestCases;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.orangeHR.DashBoard_OHR_POM;
import com.thetestingacademy.pages.pageObjectModel.orangeHR.LoginPage_OHR_POM;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOrangeHRLogin_POM extends CommonToAllTest {

    @Owner("Priya Ayyanar")
    @Description("Verify that the Login with Valid Credentails")
    @Test
    public void test_LoginPositive(){
        LoginPage_OHR_POM loginPage_ohr_pom = new LoginPage_OHR_POM(DriverManager.getDriver());

        loginPage_ohr_pom.loginToOHRPositiveCreds(PropertiesReader.readKey("ohr_username"),PropertiesReader.readKey("ohr_password"));

        DashBoard_OHR_POM dashBoard_ohr_pom = new DashBoard_OHR_POM(DriverManager.getDriver());
        String loggedInUserName = dashBoard_ohr_pom.loggedInUserName();

        // Manage Assertion Part
        assertThat(loggedInUserName).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(loggedInUserName, PropertiesReader.readKey("ohr_expected_username"));

    }
}
