package com.api.tests;

import com.api.models.requests.AddUser;
import com.api.models.responses.CreateUserResponse;
import com.api.services.UserService;
import com.api.testData.UserTestDataBuilder;
import com.api.utils.UserResponseValidator;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class AddUserTest {

    @Test(groups = {"smoke"})
    public void CreateUser(){

        AddUser request =  UserTestDataBuilder.createDefaultUser();
        UserService userService = new UserService();
        Response response = userService.createUser(request);
        response.prettyPrint();
        response.then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .time(lessThan(3000L))
                .body("name", equalTo("Manu"))
                .body("job", equalTo("Senior SDET"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());

        CreateUserResponse user = response.as(CreateUserResponse.class);
        UserResponseValidator.validateCreateUserResponse(user,request);

    }
}
