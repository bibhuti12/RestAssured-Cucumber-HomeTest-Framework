package com.qa.api.enums;

public enum Environment {


    PROD("prod"),
    STAGE("stage"),
    DEV("dev");
    private String env;
    Environment(String s){
        this.env = s;
    }

    public String getEnv(){
        return this.env;
    }
}
