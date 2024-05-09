package com.art.test.jmailtrap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.http.HttpResponse;
import java.util.function.Supplier;

public class JsonBodyHandler<T> implements HttpResponse.BodyHandler<Supplier<T>> {

    private ObjectMapper objectMapper;

    public JsonBodyHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private <T> Supplier<T> toSupplierOfType(InputStream inputStream) {
        return () -> {
            try (InputStream stream = inputStream) {
                return objectMapper.readValue(stream, new TypeReference<T>() {
                });
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        };
    }

    private <T> HttpResponse.BodySubscriber<Supplier<T>> fromJSON() {
        return HttpResponse.BodySubscribers.mapping(
                HttpResponse.BodySubscribers.ofInputStream(),
                stream -> toSupplierOfType(stream));
    }

    @Override
    public HttpResponse.BodySubscriber<Supplier<T>> apply(HttpResponse.ResponseInfo responseInfo) {
        return fromJSON();
    }

}
