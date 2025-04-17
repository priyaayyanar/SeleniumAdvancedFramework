package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManager;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }

    public void tearDown(){
        DriverManager.down();
    }
}
