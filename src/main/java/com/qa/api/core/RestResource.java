

package com.qa.api.core;


import com.qa.api.core.response.IResponse;
import com.qa.api.core.response.RAResponse;
import com.qa.api.utils.GenericUtil;
import com.qa.api.utils.RALoggerUtil;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static com.qa.api.config.FrameworkConfigFactory.getConfig;


public class RestResource {


    private static RequestSpecification prepareRequestSpecification(BaseRequest requestBuilder) throws Exception{
        List<String> bListHeaders = new ArrayList<String>();
        bListHeaders.add("Authorization");
        RequestSpecBuilder builder = new RequestSpecBuilder();
        if(GenericUtil.isNull(requestBuilder.getBaseURI())) throw new Exception("Base URI cannot be null or empty");
        builder.setBaseUri(requestBuilder.getBaseURI());
        if(requestBuilder.getHeaders() != null && !requestBuilder.getHeaders().isEmpty()) {
            builder.addHeaders(requestBuilder.getHeaders());
        }
        if(requestBuilder.getPathParams() != null && !requestBuilder.getPathParams().isEmpty()) {
            builder.addPathParams(requestBuilder.getPathParams());
        }
        if(requestBuilder.getQueryParams() != null && !requestBuilder.getQueryParams().isEmpty()) {
            builder.addQueryParams(requestBuilder.getQueryParams());
        }
        if(requestBuilder.getFormParams() != null && !requestBuilder.getFormParams().isEmpty()) {
            builder.addFormParams(requestBuilder.getFormParams());
        }
        if(requestBuilder.getBody() != null){
            builder.setBody(requestBuilder.getBody());
        }
        return builder.setConfig(RestAssured.config().logConfig(LogConfig.logConfig().blacklistHeaders(bListHeaders))).log(LogDetail.ALL).build();
    }

    private static ResponseSpecification prepareResponseSpecification(ContentType contentType) throws Exception{

        ContentType actualContentType = contentType != null ? contentType : ContentType.JSON;
        return new ResponseSpecBuilder().
                expectContentType(actualContentType).
                log(LogDetail.ALL).
                build();


    }

    public static IResponse executeApi(BaseRequest request, String baseURI) throws Exception {
        Response raResponse;
        RequestSpecification reqSpec = prepareRequestSpecification(request);
        reqSpec.filters(new RALoggerUtil());
        if(request.getAuthType() != null){
            switch (request.getAuthType()){
                case BASIC:
                    reqSpec.auth().preemptive().basic(request.getBasicAuthorization().getUserName(),request.getBasicAuthorization().getPassword());
            }
        }
        ResponseSpecification resSpec = prepareResponseSpecification(null);

        switch (request.getMethod()){
            case GET:
                raResponse = RestAssured.given().spec(reqSpec).get(request.getPath()).then().spec(resSpec).extract().response();
                break;
            case POST:
                raResponse = RestAssured.given().spec(reqSpec).post(request.getPath()).then().spec(resSpec).extract().response();
                break;
            case PUT:
                raResponse = RestAssured.given().spec(reqSpec).put(request.getPath()).then().spec(resSpec).extract().response();
                break;
            case DELETE:
                raResponse = RestAssured.given().spec(reqSpec).delete(request.getPath()).then().spec(resSpec).extract().response();
                break;
            default:
                throw new Exception("Method "+request.getMethod().name()+" not implemented...");
        }
        RAResponse response = new RAResponse(raResponse);
        return response;
    }

    public  synchronized IResponse executeApi(BaseRequest request) throws Exception {
        return executeApi(request,null);
    }

}

