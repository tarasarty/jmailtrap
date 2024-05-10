package com.art.test.jmailtrap;

import com.art.test.jmailtrap.data.SendEmailResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HttpClientWrapper {

    private static Logger logger = LogManager.getLogger(HttpClientWrapper.class);

    private ObjectMapper objectMapper;
    private HttpClient client;

    public HttpClientWrapper(HttpClient client, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.client = client;
    }

    /**
     * Sent email asynchronously by the java HttpClient client .
     * @param request
     * @return SendEmailResponse
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public SendEmailResponse sendEmail(HttpRequest request) throws InterruptedException, ExecutionException {
        var result = client
                .sendAsync(request, new JsonBodyHandler<java.util.LinkedHashMap<String, Object>>(objectMapper))
                .thenApplyAsync((resp) -> {
                    if (resp.statusCode() != 200) {
                        logger.error("Error: " + resp.statusCode());
                    }
                    return resp;
                })
                .thenApply(e -> e.body().get())
                .thenApply(map -> {
                    return new SendEmailResponse(
                            map.get("success") == null ? false : (Boolean) map.get("success"),
                            (List<String>) map.get("message_ids"),
                            (List<String>) map.get("errors")
                    );
                })
                .get();
        return result;
    }
}
