package com.thetestingacademy.pages.pageObjectModel.orangeHR;

import com.thetestingacademy.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard_OHR_POM extends CommonToAllPages {

    WebDriver driver;
    // Parameterized Constructor

    public DashBoard_OHR_POM(WebDriver driver) {
        this.driver = driver;
    }

    // Page Locators
    By userNameOnDashBoard = By.xpath("//h6[normalize-space()='PIM']");

    // Page Actions
    public String loggedInUserName(){
        presenceOfElement(userNameOnDashBoard);
        return getElement(userNameOnDashBoard).getText();
    }
}
