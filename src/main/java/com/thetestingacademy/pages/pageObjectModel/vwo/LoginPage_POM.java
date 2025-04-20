package com.thetestingacademy.pages.pageObjectModel.vwo;

import com.thetestingacademy.base.CommonToAllPages;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_POM extends CommonToAllPages {

    WebDriver driver;
    // Default Constructor
    public LoginPage_POM(WebDriver driver){
        this.driver = driver;
    }

    //Page Locators
    private By userName = By.id("login-username");
    private By password = By.id("login-password");
    private By signin_btn = By.id("js-login-btn");
    private  By error_msg = By.id("js-notification-box-msg");

    //Page Actions
    public String LoginToVWO_InvalidCreds(String user, String pwd){

        driver.get(PropertiesReader.readKey("url"));
        enterInput(userName,user);
        enterInput(password,pwd);
        clickElement(signin_btn);

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(error_msg));

        String errorMsgTxt = driver.findElement(error_msg).getText();
        return errorMsgTxt;
    }

    public void loginToVWO_ValidCrdns(String user, String pwd){

        driver.get(PropertiesReader.readKey("url"));
        enterInput(userName,user);
        enterInput(password,pwd);
        clickElement(signin_btn);

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
    }

}
