package com.xyz.tests;

import com.xyz.apiresponses.BirthdayApiResponse;
import com.xyz.utils.BirthdayAPITimeCount;
import com.xyz.utils.DateGenerator;
import com.xyz.utils.Log;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class BirthdateApiTests extends InitializeTest {

    BirthdayApiResponse birthApi = new BirthdayApiResponse();
    /*
    In this scenario we pass the user birthday 2 days less than the current date and validate that the api is
    returning the correct response
     */
    @Test(priority = 1, description = "Get birthday in days where week is less than the current e.g. 2023-07-27")
    public void getBirthdayInWeeks(){
        int count = 2;
        LocalDate generatedDate = DateGenerator.getDate(count, ChronoUnit.WEEKS);
        LocalDate nextDate = DateGenerator.getNextDate(generatedDate);
        String expectedDaysCount = DateGenerator.getDateInWeeks(nextDate);
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"week");
        String value = jsonObj.get("message");
        String actualDaysCount = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        System.out.println("Actual Value: " + actualDaysCount);
        Assert.assertEquals(actualDaysCount,expectedDaysCount, "Week count mismatch");

    }

    @Test(priority = 1, description = "Get birthday in months where month is less than current year e.g. 2023-06-11")
    public void getBirthdayInMonths(){
        int count = 2;
        LocalDate generatedDate = DateGenerator.getDate(count, ChronoUnit.MONTHS);
        LocalDate nextDate = DateGenerator.getNextDate(generatedDate);
        String expectedDaysCount = DateGenerator.getDateInMonths(nextDate);
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"month");
        String value = jsonObj.get("message");
        String actualDaysCount = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        System.out.println("Actual Value: " + actualDaysCount);
        Assert.assertEquals(actualDaysCount,expectedDaysCount, "Months count mismatch");

    }

    @Test(priority = 3, description = "Get birthday in days where date is less than current e.g. 2023-08-10")
    public void getBirthdayInDays(){
        int count = 2;
        LocalDate generatedDate = DateGenerator.getDate(count, ChronoUnit.DAYS);
        LocalDate nextDate = DateGenerator.getNextDate(generatedDate);
        String expectedDaysCount = DateGenerator.getDateInDays(nextDate);
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"day");
        String value = jsonObj.get("message");
        String actualDaysCount = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        System.out.println("Actual Value: " + actualDaysCount);
        Assert.assertEquals(actualDaysCount,expectedDaysCount, "Days count mismatch");

    }

    @Test(priority = 3, description = "Get birthday in hours where date is less than current year e.g. 2023-06-11")
    public void getBirthdayInHours(){
        int count = 2;
        LocalDate generatedDate = DateGenerator.getDate(count, ChronoUnit.DAYS);
        LocalDate nextDate = DateGenerator.getNextDate(generatedDate);
        String expectedDaysCount = DateGenerator.getDateInHours(nextDate);
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"hour");
        String value = jsonObj.get("message");
        String actualDaysCount = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        System.out.println("Actual Value: " + actualDaysCount);
        Assert.assertEquals(actualDaysCount,expectedDaysCount, "Hour count mismatch");

    }


}
