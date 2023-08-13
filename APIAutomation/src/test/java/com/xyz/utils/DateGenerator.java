package com.xyz.utils;

import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DateGenerator {

    public static final String INCORECT_DATE_OF_BIRTH = "Incorrect Date of Birth";

    /*
    Method to generate a date that can be used to manipulate the data
     */
    public static LocalDate getDate(int quantity, TemporalUnit unit, Logger log) {
        LocalDate currentDate = LocalDate.now();
        log.info("Current Date is: " + currentDate);
        log.info("New Generated Date of Birth is: " + currentDate.minus(quantity, unit));
        return currentDate.minus(quantity, unit);
    }


    /*
    This method can be used to generate the next birthday, which can then be used to calculate the difference
     */
    public static LocalDate getNextDate(LocalDate date, Logger log) {
        log.info("Next Birthday on: " + date.plus(1, ChronoUnit.YEARS));
        return date.plus(1, ChronoUnit.YEARS);

    }

    public static String getDateInDays(LocalDate endDate, Logger log) {
        log.info("Number of Days: " + ChronoUnit.DAYS.between(LocalDate.now(), endDate));
        return String.valueOf(ChronoUnit.DAYS.between(LocalDate.now(), endDate));
    }

    public static String getDateInWeeks(LocalDate endDate, Logger log) {
        //Commenting this as the o/p of api is rounding up the value
        //return String.valueOf(ChronoUnit.WEEKS.between(LocalDate.now(),endDate));
        log.info("Number of Weeks: " + Integer.valueOf(getDateInDays(endDate,log)) / 7);
        return String.valueOf(Integer.valueOf(getDateInDays(endDate,log)) / 7);
    }

    public static String getDateInMonths(LocalDate endDate, Logger log) {
        //Commenting this as the o/p of api is rounding up the value
        //return String.valueOf(ChronoUnit.MONTHS.between(LocalDate.now(),endDate));
        System.out.println("Number of Months: " + Integer.valueOf(getDateInDays(endDate,log)) / 30);
        return String.valueOf(Integer.valueOf(getDateInDays(endDate,log)) / 30);
    }

    public static String getDateInHours(LocalDate endDate, Logger log) {
        System.out.println("Number of Months: " + Integer.valueOf(getDateInDays(endDate,log)) / 30);
        return String.valueOf(Integer.valueOf(getDateInDays(endDate,log)) * 24);
    }

    public static boolean checkGeneratedDate(LocalDate genDate, Logger log) {
        if (genDate.isAfter(LocalDate.now())) {
            log.info("Input Date of Birth is Invalid!!");
            return false;

        } else {
            log.info("Input Date of Birth is valid..");
            return true;
        }

    }
}
