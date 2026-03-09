package com.api.tests;


import com.api.models.responses.ListUsersResponse;
import com.api.models.responses.User;
import com.api.services.UserService;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUserTest {

    @Test(groups = {"smoke"})
    public void verifyUsersListTest()
    {
       UserService userService=new UserService();
       Response response =userService.getUsersList();
       response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(3000L))
                .body("page",equalTo(1))
                .body("total", greaterThan(0))
                .body("total_pages", greaterThan(0))
                .body("data.size()", greaterThan(0))
                .body("data.id", everyItem(notNullValue()))
                .body("data.email", everyItem(containsString("@")))
                .body("data.first_name", everyItem(not(isEmptyOrNullString())))
                .body("data.last_name", everyItem(not(isEmptyOrNullString())))
                .body("data.avatar", everyItem(startsWith("https://")));

       ListUsersResponse usersResponse = response.as(ListUsersResponse.class);

        for (User singleUserData : usersResponse.getData()) {
            Assert.assertNotNull(singleUserData.getId());
            Assert.assertNotNull(singleUserData.getEmail());
            Assert.assertTrue(singleUserData.getEmail().contains("@"));
            Assert.assertNotNull(singleUserData.getFirst_name());
            Assert.assertNotNull(singleUserData.getLast_name());
            Assert.assertNotNull(singleUserData.getAvatar());
        }

    }

    @Test(groups = {"smoke"})
    public void verifySingleUserByIdTest()
    {

        UserService userService = new UserService();
        Response response = userService.getUserById(2);
        response.prettyPrint();
          response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(3000L))
                .body(matchesJsonSchemaInClasspath("schemas/single-user-schema.json"))
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", containsString("2-image.jpg"))
                .body("support.url", notNullValue())
                .body("support.text", not(isEmptyOrNullString()));
    }
    @Test(groups = {"negative", "regression"})
    public void verifyUserNotFoundTest() {
        UserService userService = new UserService();
        Response response = userService.getUserById(23);

        response.then()
                .statusCode(404)
                .time(lessThan(3000L));
    }

    }

