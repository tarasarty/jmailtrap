package com.art.test.jmailtrap;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class TestResponse implements HttpResponse {

    private int code = 200;
    private String message;
    private String uri;

    public TestResponse() {
        this.message = "";
    }

    public TestResponse(String message) {
        this.message = message;
    }

    public TestResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int statusCode() {
        return this.code;
    }

    @Override
    public HttpRequest request() {
        return null;
    }

    @Override
    public Optional<HttpResponse> previousResponse() {
        return Optional.empty();
    }

    @Override
    public HttpHeaders headers() {
        return null;
    }

    @Override
    public Object body() {
        return getJsonBody();
    }

    @Override
    public Optional<SSLSession> sslSession() {
        return Optional.empty();
    }

    @Override
    public URI uri() {
        return URI.create(this.uri);
    }

    @Override
    public HttpClient.Version version() {
        return HttpClient.Version.HTTP_2;
    }

    private String getJsonBody() {
        return "{\n" +
                "\"status\": \"ERROR_RESPONSE\",\n" +
                "\"message\": \"" + this.message + "\"\n" +
                "}";
    }

    public int getCode() {
        return code;
    }

    public TestResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public TestResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
