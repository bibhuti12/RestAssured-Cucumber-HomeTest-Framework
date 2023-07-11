package com.qa.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Geo {

    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lng")
    private String lng;

}
