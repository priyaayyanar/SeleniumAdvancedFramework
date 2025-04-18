package com.thetestingacademy.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAllPages {

    public CommonToAllPages() {
        // If we want to call something before every Page Object class, put our code here
        // ex : Open File, Open DataBase Connection
    }

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){
        by.click();
    }

    public void enterInput(By by, String key){
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key){
        by.sendKeys(key);
    }

    public void getText(By by){
        getDriver().findElement(by).getText();
    }

    public WebElement presenceOfElement(By elementLocation){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key){
        return getDriver().findElement(key);
    }
}
