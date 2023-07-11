package com.qa.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author bjha
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Comments {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;
    @JsonProperty("postId")
    private Integer postId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("body")
    private String body;
   


    @Override
    public String toString() {
        return "Posts [postId=" + postId + ", id=" + id + "]";
    }
}
