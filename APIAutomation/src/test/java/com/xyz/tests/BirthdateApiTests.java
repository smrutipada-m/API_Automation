package com.xyz.tests;

import com.xyz.apiresponses.BirthdayApiResponse;
import com.xyz.utils.BirthdayAPITimeCount;
import com.xyz.utils.DateGenerator;
import io.restassured.path.json.JsonPath;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



public class BirthdateApiTests extends InitializeTest {

    BirthdayApiResponse birthApi = new BirthdayApiResponse();
    /*
    In this scenario we pass the user birthday 2 days less than the current date and validate that the api is
    returning the correct response
     */
    @Test(priority = 1, description = "TC001-Get birthday in week where input week is less than the current e.g. 2023-07-27")
    @Parameters({"countVal"})
    public void getBirthdayInWeeksHistoricalTest(Integer countVal){

        LocalDate generatedDate = DateGenerator.getDate(countVal, ChronoUnit.WEEKS, log);
        LocalDate nextDate = DateGenerator.getNextDate(generatedDate, log);
        String expectedDaysCount = DateGenerator.getDateInWeeks(nextDate, log);
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"week", log);
        String value = jsonObj.get("message");
        String actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response : " + actualVal);
        Assert.assertEquals(actualVal,expectedDaysCount, "Week count mismatch");

    }

    @Test(priority = 2, description = "TC-002-Get birthday in months where input month is less than currente.g. 2023-06-11")
    @Parameters({"countVal"})
    public void getBirthdayInMonthsHistoricalTest(Integer countVal){
        LocalDate generatedDate = DateGenerator.getDate(countVal, ChronoUnit.MONTHS , log);
        LocalDate nextDate = DateGenerator.getNextDate(generatedDate, log);
        String expectedDaysCount = DateGenerator.getDateInMonths(nextDate, log);
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"month", log);
        String value = jsonObj.get("message");
        String actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response : " + actualVal);
        Assert.assertEquals(actualVal,expectedDaysCount, "Months count mismatch");

    }

    @Test(priority = 3, description = "TC-003-Get birthday in days where input date is less than current e.g. 2023-08-10")
    @Parameters({"countVal"})
    public void getBirthdayInDaysHistoricalTest(Integer countVal){
//        int count = 2;
        LocalDate generatedDate = DateGenerator.getDate(countVal, ChronoUnit.DAYS, log);
        LocalDate nextDate = DateGenerator.getNextDate(generatedDate, log);
        String expectedDaysCount = DateGenerator.getDateInDays(nextDate, log);
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"day", log);
        String value = jsonObj.get("message");
        String actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response : " + actualVal);
        Assert.assertEquals(actualVal,expectedDaysCount, "Days count mismatch");

    }

    @Test(priority = 4, description = "TC-004-Get birthday in hours where input hour is less than current e.g. 2023-06-11")
    @Parameters({"countVal"})
    public void getBirthdayInHoursHistoricalTest(Integer countVal){

        LocalDate generatedDate = DateGenerator.getDate(countVal, ChronoUnit.DAYS, log);
        LocalDate nextDate = DateGenerator.getNextDate(generatedDate, log);
        String expectedDaysCount = DateGenerator.getDateInHours(nextDate, log);
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"hour", log);
        String value = jsonObj.get("message");
        String actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response : " + actualVal);
        Assert.assertEquals(actualVal,expectedDaysCount, "Hour count mismatch");

    }

    @Test(priority = 5, description = "TC-005-Get birthday in weeks where input week is greater than the current e.g. 2023-07-27")
    @Parameters({"countVal"})
    public void getBirthdayInWeeksFutureTest(Integer countVal){

        LocalDate generatedDate = DateGenerator.getDate(-countVal, ChronoUnit.WEEKS, log);
        String expectedDaysCount = null;
        if(!DateGenerator.checkGeneratedDate(generatedDate, log)){
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"week", log);
        String value = jsonObj.get("message");
        String actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response : " + actualVal);
        Assert.assertEquals(actualVal,expectedDaysCount, "Week count mismatch");

    }

    @Test(priority = 6, description = "TC-006-Get birthday in months where input month is greater than currente.g. 2023-06-11")
    @Parameters({"countVal"})
    public void getBirthdayInMonthsFutureTest(Integer countVal){

        LocalDate generatedDate = DateGenerator.getDate(-countVal, ChronoUnit.MONTHS, log);
        String expectedDaysCount = null;
        if(!DateGenerator.checkGeneratedDate(generatedDate, log)){
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"month", log);
        String value = jsonObj.get("message");
        String actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response: " + actualVal);
        Assert.assertEquals(actualVal,expectedDaysCount, "Months count mismatch");

    }

    @Test(priority = 7, description = "TC-007-Get birthday in days where input date is greater than current e.g. 2023-08-10")
    @Parameters({"countVal"})
    public void getBirthdayInDaysFutureTest(Integer countVal){

        LocalDate generatedDate = DateGenerator.getDate(-countVal, ChronoUnit.DAYS, log);
        String expectedDaysCount = null;
        if(!DateGenerator.checkGeneratedDate(generatedDate, log)){
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"day", log);
        String value = jsonObj.get("message");
        String actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response: " + actualVal);
        Assert.assertEquals(actualVal,expectedDaysCount, "Days count mismatch");

    }

    @Test(priority = 8, description = "TC-008-Get birthday in hours where input hour is greater than current e.g. 2023-06-11")
    @Parameters({"countVal"})
    public void getBirthdayInHoursFutureTest(Integer countVal){

        LocalDate generatedDate = DateGenerator.getDate(-countVal, ChronoUnit.DAYS,log) ;
        String expectedDaysCount = null;
        if(!DateGenerator.checkGeneratedDate(generatedDate, log)){
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        JsonPath jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate),"hour", log);
        String value = jsonObj.get("message");
        String actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response: " + actualVal);
        Assert.assertEquals(actualVal,expectedDaysCount, "Hour count mismatch");

    }

    @Test(priority = 9, description = "TC-009-Get Response when date format is incorrect")
    public void getMissingParamTest(){
        JsonPath jsonObj = birthApi.getBirthdayApiResponse("2023/08/23","day", log);
        String value = jsonObj.get("message");
        log.info("Actual Value from API Response: " + value);
        Assert.assertEquals(value,BirthdayApiResponse.DATE_FORMAT_INCORRECT, "Hour count mismatch");

    }





}
