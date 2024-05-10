package com.art.test.jmailtrap.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "content",
        "filename",
        "type",
        "disposition"
})
public class Attachment {

    @JsonProperty("content")
    private String content;
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("type")
    private String type;
    @JsonProperty("disposition")
    private String disposition;

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("disposition")
    public String getDisposition() {
        return disposition;
    }

    @JsonProperty("disposition")
    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }


}
