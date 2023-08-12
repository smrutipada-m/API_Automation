package com.xyz.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.lang.reflect.Method;


public class InitializeTest {

    @BeforeMethod
    public void setUp(Method method){
        System.out.println("Starting Test: " + method.getName());

    }

    @AfterMethod
    public void tearDown(Method method){
        System.out.println("Ending Test: " + method.getName());
    }

}
