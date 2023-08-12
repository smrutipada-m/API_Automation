package com.xyz.tests;

import com.xyz.utils.PropertyFileReader;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.lang.reflect.Method;


public class InitializeTest {
    public static Logger log = LogManager.getLogger();

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = PropertyFileReader.getPropertyValue("birthday_end_point", "apiendpoints.properties");
        log.info("Base URI is: " + RestAssured.baseURI);
    }

    @BeforeMethod
    public void setUp(Method method) {
        log.info("------------------Starting Test: " + method.getName() + " ------------------");


    }

    @AfterMethod
    public void tearDown(Method method) {

        log.info("------------------Ending Test: " + method.getName() + " ------------------");
    }

}
