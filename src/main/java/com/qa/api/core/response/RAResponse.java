package com.qa.api.core.response;

import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.MatcherAssert;

import java.io.File;
import java.util.List;

public class RAResponse implements IResponse{
    private Response res;
    public RAResponse(Response res){
        this.res = res;
    }

    /**
     *  This method return the status code of teh response
     *
     * @return int
     */
    @Override
    public int status() {
     return  this.res.statusCode();
    }

    /**
     * This method pretty prints the response
     *
     * @return String
     */
    @Override
    public String asPrettyString() {
        return this.res.asPrettyString();
    }

    /**
     * This method deserialize the response to Java object
     *
     * @param cls
     * @return
     * @param <T>
     */
    @Override
    public <T> T as(Class<T> cls) {
        return this.res.as(cls);
    }

    /**
     * This method validate the json schema
     *
     * @param jsonSchema
     * @param expectedSchemaPath
     */
    @Override
    public void validateSchema(String jsonSchema , String expectedSchemaPath) {
        MatcherAssert.assertThat(jsonSchema, JsonSchemaValidator.matchesJsonSchema(new File(expectedSchemaPath)));
    }


    /**
     *  This method return the value from json object
     * @param path
     * @return String
     */
    @Override
    public String getString(String path) {
        return this.res.jsonPath().getString(path);
    }

    /**
     * This method return the Integer value from json object
     *
     * @param path
     * @return Integer
     */
    @Override
    public Integer getInt(String path) {
        return this.res.jsonPath().getInt(path);
    }


    /**
     * This method return the boolean value from json object
     *
     * @param path
     * @return Integer
     */
    @Override
    public boolean getBoolean(String path) {
        return this.res.jsonPath().getBoolean(path);
    }

    /**
     * This method return the list of value from json object
     *
     * @param path
     * @return Integer
     */
    @Override
    public <T> List<T> getList(String path) {
        return this.res.jsonPath().getList(path);
    }

    /**
     * This method return the headers
     *
     * @return Integer
     */
    @Override
    public Headers getHeaders() {
        return this.res.headers();
    }

    /**
     * This method return the response body
     *
     * @return Integer
     */
    @Override
    public ResponseBody getBody() {
        return this.res.body();
    }
}
