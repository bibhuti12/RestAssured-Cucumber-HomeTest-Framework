package com.qa.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Address {

    @JsonProperty("street")
    private String street;
    @JsonProperty("suite")
    private String suite;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("geo")
    private Geo geo;

}
