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
    @Test(priority = 1, description = "TC001-Get birthday in week where input week is less than the current e.g. 2023-07-27")
    public void getBirthdayInWeeksHistoricalTest(){
        int count = 1;
        LocalDate generatedDate = DateGenerator.getDate(count, ChronoUnit.WEEKS);
        LocalDate nextDate = DateGenerator.getNextDate(generatedDate);
        String expectedDaysCount = DateGenerator.getDateInWeeks(nextDate);
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"week");
        String value = jsonObj.get("message");
        String actualDaysCount = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        System.out.println("Actual Value: " + actualDaysCount);
        Assert.assertEquals(actualDaysCount,expectedDaysCount, "Week count mismatch");

    }

    @Test(priority = 2, description = "TC-002-Get birthday in months where input month is less than currente.g. 2023-06-11")
    public void getBirthdayInMonthsHistoricalTest(){
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

    @Test(priority = 3, description = "TC-003-Get birthday in days where input date is less than current e.g. 2023-08-10")
    public void getBirthdayInDaysHistoricalTest(){
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

    @Test(priority = 4, description = "TC-004-Get birthday in hours where input hour is less than current e.g. 2023-06-11")
    public void getBirthdayInHoursHistoricalTest(){
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

    @Test(priority = 5, description = "TC-005-Get birthday in weeks where input week is greater than the current e.g. 2023-07-27")
    public void getBirthdayInWeeksFutureTest(){
        int count = -1;
        LocalDate generatedDate = DateGenerator.getDate(count, ChronoUnit.WEEKS);
        String expectedDaysCount = null;
        if(!DateGenerator.checkGeneratedDate(generatedDate)){
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"week");
        String value = jsonObj.get("message");
        String actualDaysCount = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        System.out.println("Actual Value: " + actualDaysCount);
        Assert.assertEquals(actualDaysCount,expectedDaysCount, "Week count mismatch");

    }

    @Test(priority = 6, description = "TC-006-Get birthday in months where input month is greater than currente.g. 2023-06-11")
    public void getBirthdayInMonthsFutureTest(){
        int count = -2;
        LocalDate generatedDate = DateGenerator.getDate(count, ChronoUnit.MONTHS);
        String expectedDaysCount = null;
        if(!DateGenerator.checkGeneratedDate(generatedDate)){
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"month");
        String value = jsonObj.get("message");
        String actualDaysCount = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        System.out.println("Actual Value: " + actualDaysCount);
        Assert.assertEquals(actualDaysCount,expectedDaysCount, "Months count mismatch");

    }

    @Test(priority = 7, description = "TC-007-Get birthday in days where input date is greater than current e.g. 2023-08-10")
    public void getBirthdayInDaysFutureTest(){
        int count = -2;
        LocalDate generatedDate = DateGenerator.getDate(count, ChronoUnit.DAYS);
        String expectedDaysCount = null;
        if(!DateGenerator.checkGeneratedDate(generatedDate)){
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"day");
        String value = jsonObj.get("message");
        String actualDaysCount = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        System.out.println("Actual Value: " + actualDaysCount);
        Assert.assertEquals(actualDaysCount,expectedDaysCount, "Days count mismatch");

    }

    @Test(priority = 8, description = "TC-008-Get birthday in hours where input hour is greater than current e.g. 2023-06-11")
    public void getBirthdayInHoursFutureTest(){
        int count = -2;
        LocalDate generatedDate = DateGenerator.getDate(count, ChronoUnit.DAYS);
        String expectedDaysCount = null;
        if(!DateGenerator.checkGeneratedDate(generatedDate)){
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"hour");
        String value = jsonObj.get("message");
        String actualDaysCount = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        System.out.println("Actual Value: " + actualDaysCount);
        Assert.assertEquals(actualDaysCount,expectedDaysCount, "Hour count mismatch");

    }

    @Test(priority = 9, description = "TC-009-Get Response when date format is incorrect")
    public void getMissingParamTest(){
        JsonPath jsonObj = birthApi.getBirthdayApiResponse("2023/08/23","day");
        String value = jsonObj.get("message");
        System.out.println("Actual Value: " + value);
        Assert.assertEquals(value,BirthdayApiResponse.DATE_FORMAT_INCORRECT, "Hour count mismatch");

    }





}
