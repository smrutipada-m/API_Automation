package com.xyz.apiresponses;

import com.xyz.utils.PropertyFileReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class BirthdayApiResponse {

    public JsonPath getBirthdayApiResponse(String birthDate, String unit){
        RestAssured.baseURI = PropertyFileReader.getPropertyValue("birthday_end_point","apiendpoints.properties");
        System.out.println("Query Params --> " + "dateofbirth: " + birthDate);
        System.out.println("Query Params --> " + "unit: " + unit);
        Response res = RestAssured.given().queryParam("dateofbirth",birthDate).queryParam("unit",unit).get();
        Assert.assertEquals(res.statusCode(),200, "Invalid Status Code, expected 200");
        res.prettyPrint();
        return res.jsonPath();
    }
}
