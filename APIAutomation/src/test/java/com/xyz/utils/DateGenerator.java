package com.xyz.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DateGenerator {

    /*
    Method to generate a date that can be used to manipulate the data
     */
    public static LocalDate getDate(int quantity, TemporalUnit unit){
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date is: " + currentDate);
        System.out.println("New Generated Date is: " + currentDate.minus(quantity, unit));
        return currentDate.minus(quantity, unit);
    }


    /*
    This method can be used to generate the next birthday, which can then be used to calculate the difference
     */
    public static LocalDate getNextDate(LocalDate date){
        System.out.println("Next Birthday on: " + date.plus(1,ChronoUnit.YEARS));
        return date.plus(1,ChronoUnit.YEARS);
    }

    public static String getDateInDays(LocalDate endDate){
        System.out.println("Number of Days: " + ChronoUnit.DAYS.between(LocalDate.now(),endDate));
        return String.valueOf(ChronoUnit.DAYS.between(LocalDate.now(),endDate));
    }

    public static String getDateInWeeks(LocalDate endDate){
        //Commenting this as the o/p of api is rounding up the value
        //return String.valueOf(ChronoUnit.WEEKS.between(LocalDate.now(),endDate));
        System.out.println("Number of Weeks: " + Integer.valueOf(getDateInDays(endDate))/7);
        return String.valueOf(Integer.valueOf(getDateInDays(endDate))/7);
    }

    public static String getDateInMonths(LocalDate endDate){
        //Commenting this as the o/p of api is rounding up the value
        //return String.valueOf(ChronoUnit.MONTHS.between(LocalDate.now(),endDate));
        System.out.println("Number of Months: " + Integer.valueOf(getDateInDays(endDate))/30);
        return String.valueOf(Integer.valueOf(getDateInDays(endDate))/30);
    }
    public static String getDateInHours(LocalDate endDate){
        System.out.println("Number of Months: " + Integer.valueOf(getDateInDays(endDate))/30);
        return String.valueOf(Integer.valueOf(getDateInDays(endDate))*24);
    }
}
