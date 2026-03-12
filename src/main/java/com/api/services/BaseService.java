package com.api.services;

import com.api.config.ConfigManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public abstract class BaseService {

    private RequestSpecification requestSpecification;
    private static final String BaseUrl =  ConfigManager.get("baseUrl");

    public BaseService(){

       requestSpecification = given().baseUri(BaseUrl);
    }

    protected Response getRequest(String endpoint)
    {
        return given()
                .spec(requestSpecification)
                .header("x-api-key",ConfigManager.get("apiKey"))
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    protected Response postRequest(Object payload , String endpoint)
    {
        return given()
                .spec(requestSpecification)
                .contentType("application/json")
                .header("x-api-key",ConfigManager.get("apiKey"))
                .body(payload)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();

    }

}
