package com.api.utils;

import com.api.models.requests.CreateUserRequest;
import com.api.models.responses.CreateUserResponse;
import org.testng.Assert;


public class UserResponseValidator {

    public static void  validateCreateUserResponse(CreateUserResponse actual, CreateUserRequest expected) {

        Assert.assertEquals(actual.getName(), expected.getName());
        Assert.assertEquals(actual.getJob(), expected.getJob());
        Assert.assertNotNull(actual.getId());
        Assert.assertNotNull(actual.getCreatedAt());
    }
}
