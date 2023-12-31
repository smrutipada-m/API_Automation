package com.xyz.tests;

import com.xyz.apiresponses.BirthdayApiResponse;
import com.xyz.utils.BirthdayAPITimeCount;
import com.xyz.utils.DateGenerator;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class BirthdateApiTests extends InitializeTest {
    LocalDate generatedDate = null;
    LocalDate nextDate = null;
    String expectedDaysCount = null;
    JsonPath jsonObj = null;
    String actualVal = null;

    BirthdayApiResponse birthApi = new BirthdayApiResponse();

    /*
    Check response when date of birth is less than current date
     */
    @Test(priority = 1, description = "TC001-Get birthday in week where input week is less than the current e.g. 2023-07-27")
    @Parameters({"countVal"})
    public void birthdayInWeeksHistoricalTest(Integer countVal) {

        generatedDate = DateGenerator.getDate(countVal, ChronoUnit.WEEKS, log);
        if (!DateGenerator.checkGeneratedDate(generatedDate, log)) {
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        } else {
            nextDate = DateGenerator.getNextDate(generatedDate, log);
            expectedDaysCount = DateGenerator.getDateInWeeks(nextDate, log);
        }
        jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate), "week", log);
        actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response : " + actualVal);
        Assert.assertEquals(actualVal, expectedDaysCount, "Week count mismatch");

    }

    /*
    Check response when date of birth is less than current date
     */
    @Test(priority = 2, description = "TC-002-Get birthday in months where input month is less than currente.g. 2023-06-11")
    @Parameters({"countVal"})
    public void birthdayInMonthsHistoricalTest(Integer countVal) {
        generatedDate = DateGenerator.getDate(countVal, ChronoUnit.MONTHS, log);
        if (!DateGenerator.checkGeneratedDate(generatedDate, log)) {
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        } else {
            nextDate = DateGenerator.getNextDate(generatedDate, log);
            expectedDaysCount = DateGenerator.getDateInMonths(nextDate, log);
        }
        jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate), "month", log);
        actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response : " + actualVal);
        Assert.assertEquals(actualVal, expectedDaysCount, "Months count mismatch");

    }

    /*
    Check response when date of birth is less than current date
     */
    @Test(priority = 3, description = "TC-003-Get birthday in days where input date is less than current e.g. 2023-08-10")
    @Parameters({"countVal"})
    public void birthdayInDaysHistoricalTest(Integer countVal) {

        generatedDate = DateGenerator.getDate(countVal, ChronoUnit.DAYS, log);
        if (!DateGenerator.checkGeneratedDate(generatedDate, log)) {
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }else{
            nextDate = DateGenerator.getNextDate(generatedDate, log);
            expectedDaysCount = DateGenerator.getDateInDays(nextDate, log);
        }
        jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate), "day", log);
        actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response : " + actualVal);
        Assert.assertEquals(actualVal, expectedDaysCount, "Days count mismatch");

    }

    /*
    Check response when date of birth is less than current date
     */
    @Test(priority = 4, description = "TC-004-Get birthday in hours where input hour is less than current e.g. 2023-06-11")
    @Parameters({"countVal"})
    public void birthdayInHoursHistoricalTest(Integer countVal) {

        generatedDate = DateGenerator.getDate(countVal, ChronoUnit.DAYS, log);
        if (!DateGenerator.checkGeneratedDate(generatedDate, log)) {
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }else {
            nextDate = DateGenerator.getNextDate(generatedDate, log);
            expectedDaysCount = DateGenerator.getDateInHours(nextDate, log);
        }
        jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate), "hour", log);
        actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response : " + actualVal);
        Assert.assertEquals(actualVal, expectedDaysCount, "Hour count mismatch");

    }

    /*
    Check response when date of birth is greater than current date
     */
    @Test(priority = 5, description = "TC-005-Get birthday in weeks where input week is greater than the current e.g. 2023-07-27")
    @Parameters({"countVal"})
    public void birthdayInWeeksFutureTest(Integer countVal) {

        generatedDate = DateGenerator.getDate(-countVal, ChronoUnit.WEEKS, log);
        if (!DateGenerator.checkGeneratedDate(generatedDate, log)) {
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate), "week", log);
        actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response : " + actualVal);
        Assert.assertEquals(actualVal, expectedDaysCount, "Week count mismatch, Date of Birth entered is: " + generatedDate);

    }

    /*
    Check response when date of birth is greater than current date
     */
    @Test(priority = 6, description = "TC-006-Get birthday in months where input month is greater than currente.g. 2023-06-11")
    @Parameters({"countVal"})
    public void birthdayInMonthsFutureTest(Integer countVal) {

        generatedDate = DateGenerator.getDate(-countVal, ChronoUnit.MONTHS, log);
        if (!DateGenerator.checkGeneratedDate(generatedDate, log)) {
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate), "month", log);
        actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response: " + actualVal);
        Assert.assertEquals(actualVal, expectedDaysCount, "Months count mismatch, Date of Birth entered is: " + generatedDate);

    }

    /*
    Check response when date of birth is greater than current date
     */
    @Test(priority = 7, description = "TC-007-Get birthday in days where input date is greater than current e.g. 2023-08-10")
    @Parameters({"countVal"})
    public void birthdayInDaysFutureTest(Integer countVal) {

        generatedDate = DateGenerator.getDate(-countVal, ChronoUnit.DAYS, log);
        if (!DateGenerator.checkGeneratedDate(generatedDate, log)) {
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate), "day", log);
        actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response: " + actualVal);
        Assert.assertEquals(actualVal, expectedDaysCount, "Days count mismatch, Date of Birth entered is: " + generatedDate);

    }

    /*
    Check response when date of birth is greater than current date
     */
    @Test(priority = 8, description = "TC-008-Get birthday in hours where input hour is greater than current e.g. 2023-06-11")
    @Parameters({"countVal"})
    public void birthdayInHoursFutureTest(Integer countVal) {

        generatedDate = DateGenerator.getDate(-countVal, ChronoUnit.DAYS, log);
        if (!DateGenerator.checkGeneratedDate(generatedDate, log)) {
            expectedDaysCount = DateGenerator.INCORECT_DATE_OF_BIRTH;
        }
        jsonObj = birthApi.getBirthdayApiResponse(String.valueOf(generatedDate), "hour", log);
        actualVal = BirthdayAPITimeCount.getTimeValue(jsonObj.get("message"));
        log.info("Actual Value from API Response: " + actualVal);
        Assert.assertEquals(actualVal, expectedDaysCount, "Hour count mismatch, Date of Birth entered is: " + generatedDate);

    }

    /*
    Check response when date of birth format is incorrect
     */
    @Test(priority = 9, description = "TC-009-Get Response when date format is incorrect")
    public void invalidDateFormatTest() {
        jsonObj = birthApi.getBirthdayApiResponse("2023/08/23", "day", log);
        String value = jsonObj.get("message");
        log.info("Actual Value from API Response: " + value);
        Assert.assertEquals(value, BirthdayApiResponse.DATE_FORMAT_INCORRECT, "Hour count mismatch");

    }

}
