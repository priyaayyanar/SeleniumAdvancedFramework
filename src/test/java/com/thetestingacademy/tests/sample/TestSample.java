package com.thetestingacademy.tests.sample;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSample {

    @Description("Sample Test Case 1")
    @Test
    public void test_Sample_TC1(){
        Assert.assertTrue(true);
    }

    @Description("Sample Test Case 2")
    @Test
    public void test_Sample_TC2(){
        Assert.assertTrue(true);
    }
}
