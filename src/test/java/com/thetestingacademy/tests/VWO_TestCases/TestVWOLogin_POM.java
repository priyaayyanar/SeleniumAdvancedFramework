package com.thetestingacademy.tests.VWO_TestCases;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.vwo.DashBoardPage_POM;
import com.thetestingacademy.pages.pageObjectModel.vwo.LoginPage_POM;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_POM extends CommonToAllTest {

    @Owner("Priya Ayyanar")
    @Description("Verify that invalid creds give error msg")
    @Test
    public void test_VWOLogin_Negative(){

        // Manage Drive part
//        WebDriver driver = DriverManager.getDriver();
//        String URL = "https://app.vwo.com";

        LoginPage_POM loginPage_pom = new LoginPage_POM(DriverManager.getDriver());
        String err_msg = loginPage_pom.LoginToVWO_InvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        // Manage Assertion Part
        assertThat(err_msg).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(err_msg, PropertiesReader.readKey("error_message"));

       // driver.quit();
    }

    @Owner("Priya Ayyanar")
    @Description("Verify that valid creds navigate to Dashboard")
    @Test
    public void test_VWOLogin_Positive(){

        LoginPage_POM loginPage_pom = new LoginPage_POM(DriverManager.getDriver());
        loginPage_pom.loginToVWO_ValidCrdns(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        //Call DashBoard Page
        DashBoardPage_POM dashBoardPagePom = new DashBoardPage_POM(DriverManager.getDriver());
        String loggedInUserName = dashBoardPagePom.loggedInUserName();

        // Manage Assertion Part
        assertThat(loggedInUserName).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(loggedInUserName, PropertiesReader.readKey("expected_username"));

        // driver.quit();
    }

}
