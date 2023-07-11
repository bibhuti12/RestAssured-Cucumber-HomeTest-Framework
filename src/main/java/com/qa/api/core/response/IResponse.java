package com.qa.api.core.response;

import io.restassured.http.Headers;
import io.restassured.response.ResponseBody;

import java.util.List;

public interface IResponse {

    int status();
    String asPrettyString();
    <T> T as(Class<T> cls);
    void validateSchema(String jsonSchema , String expectedSchemaPath);
    String getString(String path);

     Integer getInt(String path);

     boolean getBoolean(String path);

    <T>List<T> getList(String path);

     Headers getHeaders();

     ResponseBody getBody();
}
