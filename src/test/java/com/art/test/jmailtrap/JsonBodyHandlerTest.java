package com.art.test.jmailtrap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

public class JsonBodyHandlerTest {

    @Test
    public void testBodySubscriber() {
        JsonBodyHandler<String> handler = new JsonBodyHandler<>(new ObjectMapper());
        HttpResponse.BodySubscriber<Supplier<String>> subscriber = handler.apply(mock(HttpResponse.ResponseInfo.class));
        assertNotNull(subscriber);
    }

    @Test
    public void testExtractsDataUsingObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        String expectedData =  "{\"key\": \"value\"}";;
        byte[] data = expectedData.getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);

        JsonBodyHandler<Map<String, String>> handler = new JsonBodyHandler<>(om);
        Supplier<Map> supplier = handler.toSupplierOfType(inputStream);
        Map<String, String> actualData = supplier.get();

        assertEquals("value", actualData.get("key"));
    }

}