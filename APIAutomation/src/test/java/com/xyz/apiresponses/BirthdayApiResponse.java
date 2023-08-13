package com.xyz.apiresponses;

import com.xyz.utils.PropertyFileReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class BirthdayApiResponse {
    public static final String QUERY_PARAMS_MISSING = "Please specify both query parameter dateofbirth and unit";
    public static final String DATE_FORMAT_INCORRECT = "Please specify dateofbirth in ISO format YYYY-MM-DD";
    public JsonPath getBirthdayApiResponse(String birthDate, String unit, Logger log){
        log.info("Query Params --> " + "dateofbirth: " + birthDate);
        log.info("Query Params --> " + "unit: " + unit);
        Response res = RestAssured.given().queryParam("dateofbirth",birthDate).queryParam("unit",unit).get();
        res.toString();
        Assert.assertEquals(res.statusCode(),200, "Invalid Status Code, expected 200");
        res.prettyPrint();
        return res.jsonPath();
    }
}
