package com.api.testData;

import com.api.models.requests.AddUser;

public class UserTestDataBuilder {
    public static AddUser createDefaultUser() {
        return new AddUser("Manu", "Senior SDET");
    }

    public static AddUser createUser(String name, String job) {
        return new AddUser(name, job);
    }
}
