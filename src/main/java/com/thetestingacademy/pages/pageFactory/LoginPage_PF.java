package com.thetestingacademy.pages.pageFactory;

import com.thetestingacademy.base.CommonToAllPages;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.driver;

public class LoginPage_PF extends CommonToAllPages {

    // Parameterized Constructor

    public LoginPage_PF(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Page Locators
    @FindBy(id="login-username")
    private WebElement username;

    @FindBy(id="login-password")
    private WebElement password;

    @FindBy(id="js-login-btn")
    private WebElement signButton;

    @FindBy(id="js-notification-box-msg")
    private WebElement error_message;

    // Page Actions
    public String loginToVWOInvalidCreds(){
        enterInput(username, PropertiesReader.readKey("invalid_username"));
        enterInput(password, PropertiesReader.readKey("invalid_password"));
        clickElement(signButton);

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By)error_message));
        wait.until(ExpectedConditions.visibilityOf(error_message));
        return error_message.getText();
    }

}
