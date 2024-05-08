package com.art.test.jmailtrap.com.art.test.jmailtrap.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "email",
        "name"
})
public class EmailAddress {

    public EmailAddress() {
    }

    public EmailAddress(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

}