package com.xyz.utils;

public class BirthdayAPITimeCount {
    /*
    Method to get the numeric value from the api response
     */
    public static String getTimeValue(String str){
        String[] strArr = str.split(" ");
        return strArr[0];
    }
}
