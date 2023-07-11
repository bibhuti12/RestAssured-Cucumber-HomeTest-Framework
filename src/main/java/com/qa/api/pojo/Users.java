package com.qa.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author bjha
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Users {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("website")
    private String website;
    @JsonProperty("company")
    private Company company;

    @Override
    public String toString() {
        return "Employee [firstName=" + name + ", id=" + id + "]";
    }
}
