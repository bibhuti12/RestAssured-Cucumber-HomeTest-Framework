package com.qa.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author bjha
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Company {
    @JsonProperty("name")
    private String name;
    @JsonProperty("catchPhrase")
    private String catchPhrase;
    @JsonProperty("bs")
    private String bs;
}
