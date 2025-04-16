package com.thetestingacademy.pages.pageObjectModel;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_POM {

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
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signin_btn).click();

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(error_msg));

        String errorMsgTxt = driver.findElement(error_msg).getText();
        return errorMsgTxt;
    }

    public void loginToVWO_ValidCrdns(String user, String pwd){
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signin_btn).click();

    }

}
