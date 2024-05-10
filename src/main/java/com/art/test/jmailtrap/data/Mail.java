package com.art.test.jmailtrap.data;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "from", //from Address required
        "to",   //to  array[Address]  required
        "cc",   //cc array[Address]
        "bcc", //bcc array[Address]
        "attachments", // array[object]
        "custom_variables", //dictionary[string, string]
        "headers", //dictionary[string, string]
        "subject", //subject string required
        "text", //text string
        "category" //category string <= 255 characters
})
public class Mail {

    @JsonProperty("to")
    private List<EmailAddress> to;
    @JsonProperty("cc")
    private List<EmailAddress> cc;
    @JsonProperty("bcc")
    private List<EmailAddress> bcc;
    @JsonProperty("from")
    private EmailAddress from;
    @JsonProperty("attachments")
    private List<Attachment> attachments;
    @JsonProperty("custom_variables")
    private Map<String, String> customVariables ;
    @JsonProperty("headers")
    private Map<String, String> headers;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("text")
    private String text;
    @JsonProperty("html")
    private String html;
    @JsonProperty("category")
    private String category;

    //generated data


    public List<EmailAddress> getTo() {
        return to;
    }

    public void setTo(List<EmailAddress> to) {
        this.to = to;
    }

    public List<EmailAddress> getCc() {
        return cc;
    }

    public void setCc(List<EmailAddress> cc) {
        this.cc = cc;
    }

    public List<EmailAddress> getBcc() {
        return bcc;
    }

    public void setBcc(List<EmailAddress> bcc) {
        this.bcc = bcc;
    }

    public EmailAddress getFrom() {
        return from;
    }

    public void setFrom(EmailAddress from) {
        this.from = from;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public Map<String, String> getCustomVariables() {
        return customVariables;
    }

    public void setCustomVariables(Map<String, String> customVariables) {
        this.customVariables = customVariables;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
