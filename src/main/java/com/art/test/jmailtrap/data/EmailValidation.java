package com.art.test.jmailtrap.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class EmailValidation {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("errors")
    private List<String> errors = new ArrayList<>();

    public EmailValidation(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void addError(String errorMessage) {
        this.errors.add(errorMessage);
    }

    public SendEmailResponse toSendEmailResponse() {
        SendEmailResponse result = new SendEmailResponse(success);
        result.setErrors(this.errors);
        return result;
    }
}
