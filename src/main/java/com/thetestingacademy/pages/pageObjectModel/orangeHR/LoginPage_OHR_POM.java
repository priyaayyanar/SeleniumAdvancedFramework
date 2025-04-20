package com.thetestingacademy.pages.pageObjectModel.orangeHR;

import com.google.j2objc.annotations.Property;
import com.thetestingacademy.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_OHR_POM extends CommonToAllPages {

    WebDriver driver;
    public LoginPage_OHR_POM(WebDriver driver) {
        this.driver = driver;
    }

//    WebDriver driver;
//
//    // Parameterized constructor
//    public LoginPage_OHR_POM(WebDriver driver) {
//        this.driver = driver;
//    }

    // Page Locators
    private By userName = By.cssSelector("[name='username']");
    private By passWord = By.cssSelector("[name='password']");
    private By submit_btn = By.cssSelector("[type='submit']");

    // Page Actions
    public void loginToOHRPositiveCreds(String user, String pwd){
        driver.get(PropertiesReader.readKey("orangehr_url"));
        visibilityOfElement(userName);
        enterInput(userName, user);
        enterInput(passWord, pwd);
        clickElement(submit_btn);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

}
