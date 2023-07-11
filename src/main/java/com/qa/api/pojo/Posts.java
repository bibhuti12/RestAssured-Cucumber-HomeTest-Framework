package com.qa.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author bjha
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Posts {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;



    @Override
    public String toString() {
        return "Posts [title=" + title + ", id=" + id + "]";
    }
}
