package com.qa.api.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.qa.api.core.auth.BasicAuthorization;
import com.qa.api.enums.AuthType;
import com.qa.api.enums.MethodType;
import io.restassured.http.ContentType;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Getter
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Builder
public class BaseRequest {

    private static final Logger logger = LoggerFactory.getLogger(BaseRequest.class);


    @NonNull
    private MethodType method;
    private ContentType contentType;
    private String baseURI;
    @NonNull
    private String path;

    private Map<String, String> headers;
    private Map<String, Object> queryParams;
    private Map<String, Object> pathParams;
    private Object body;
    private Map<String, Object> formParams;
    private BasicAuthorization basicAuthorization;
    private AuthType authType;

    public BaseRequest header(String key, String value){
        if(this.headers == null)
            this.headers = new HashMap<>();
        this.headers.put(key,value);
        return this;
    }

    public BaseRequest queryParam(String key, Object value){
        if(this.queryParams == null)
            this.queryParams = new HashMap<>();
        this.queryParams.put(key,value);
        return this;
    }

    public BaseRequest pathParam(String key, Object value){
        if(this.pathParams == null)
            this.pathParams = new HashMap<>();
        this.pathParams.put(key,value);
        return this;
    }

    public BaseRequest formParam(String key, Object value){
        if(this.formParams == null)
            this.formParams = new HashMap<>();
        this.formParams.put(key,value);
        return this;
    }

    private static BaseRequestBuilder builder(){
        return new BaseRequestBuilder();
    }

    public static BaseRequestBuilder builder(String path, MethodType method){
        return builder().path(path).method(method);
    }

}
