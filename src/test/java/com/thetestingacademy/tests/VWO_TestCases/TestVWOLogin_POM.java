package com.thetestingacademy.tests.VWO_TestCases;

import com.thetestingacademy.pages.pageObjectModel.LoginPage_POM;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_POM {

    @Owner("Priya Ayyanar")
    @Description("Verify that invalid creds give error msg")
    @Test
    public void test_VWOLogin_Negative(){

        // Manage Drive part
        WebDriver driver = new ChromeDriver();
        String URL = "https://app.vwo.com";
        driver.get(URL);
        driver.manage().window().maximize();

        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);
        String err_msg = loginPage_pom.LoginToVWO_InvalidCreds("admin@gmail.com","123");

        // Manage Assertion Part
        assertThat(err_msg).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(err_msg, "Your email, password, IP address or location did not match");

        driver.quit();
    }

}
