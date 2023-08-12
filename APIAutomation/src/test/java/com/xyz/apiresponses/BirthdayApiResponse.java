package com.xyz.apiresponses;

import com.xyz.utils.PropertyFileReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class BirthdayApiResponse {
    public static final String QUERY_PARAMS_MISSING = "Please specify both query parameter dateofbirth and unit";
    public static final String DATE_FORMAT_INCORRECT = "Please specify dateofbirth in ISO format YYYY-MM-DD";
    public JsonPath getBirthdayApiResponse(String birthDate, String unit){
//        RestAssured.baseURI = PropertyFileReader.getPropertyValue("birthday_end_point","apiendpoints.properties");
        System.out.println("Query Params --> " + "dateofbirth: " + birthDate);
        System.out.println("Query Params --> " + "unit: " + unit);
        Response res = RestAssured.given().queryParam("dateofbirth",birthDate).queryParam("unit",unit).get();
        res.toString();
        Assert.assertEquals(res.statusCode(),200, "Invalid Status Code, expected 200");
        res.prettyPrint();
        return res.jsonPath();
    }
}
