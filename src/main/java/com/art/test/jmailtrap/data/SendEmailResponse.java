package com.art.test.jmailtrap.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SendEmailResponse {
    /*
    success boolean true or false
    array[string] message_ids An array of message IDs, one per recipient, in order of To, Cc, Bcc
    Example: {success=true, message_ids=[66b52620-0d4f-11ef-0040-f19dcf7b8950]}
     */
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message_ids")
    private List<String> messageIds;

    @JsonProperty("errors")
    private List<String> errors;

    public SendEmailResponse(Boolean success,
                             List<String> messageIds,
                             List<String> errors) {
        this.success = success;
        this.messageIds = messageIds;
        this.errors = errors;
    }

    public SendEmailResponse(Boolean success) {
        this.success = success;
        messageIds = List.of();
    }

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("message_ids")
    public List<String> getMessageIds() {
        return messageIds;
    }

    @JsonProperty("message_ids")
    public void setMessageIds(List<String> messageIds) {
        this.messageIds = messageIds;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "SendEmailResponse{" +
                "success=" + success +
                ", messageIds=" + messageIds +
                ", errors=" + errors +
                '}';
    }
}
