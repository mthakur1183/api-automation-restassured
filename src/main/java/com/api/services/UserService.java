package com.api.services;

import com.api.endpoints.ApiRoutes;
import com.api.models.requests.CreateUserRequest;
import io.restassured.response.Response;

public class UserService extends BaseService {

    private static final  String Users_Path = ApiRoutes.GET_USER;
    public Response getUsersList (){
      return getRequest(Users_Path);

    }
    public Response getUserById(int userId){
        return getRequest(Users_Path+userId);
    }

    public Response createUser(CreateUserRequest payload){
        return postRequest(payload , Users_Path);
    }

  }
