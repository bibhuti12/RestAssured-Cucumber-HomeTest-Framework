package com.qa.api.client.user;

/**
 * @author bjha
 */
public enum UserEndpoints {

    USERS("/users");

    private String path;
    UserEndpoints(String path){
        this.path = path;
    }
    public String getPath() {
        return this.path;
    }
}
