package com.api.models.requests;

public class CreateUserRequest {

    private String name;
    private String job;


    public String getJob() {
        return job;
    }

    public String getName() {
        return name;
    }
    private CreateUserRequest(Builder builder) {
        this.name = builder.name;
        this.job = builder.job;
    }

    public static class Builder
    {
         private String name;
        private String job;

        public Builder name (String name)
        {
            this.name = name;
            return this;

        }
        public Builder job (String job)
        {
            this.job = job;
            return this;

        }

        public CreateUserRequest build()
        {
            return new CreateUserRequest(this);

        }




    }


}
