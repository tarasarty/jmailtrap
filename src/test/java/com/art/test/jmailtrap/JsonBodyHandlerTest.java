package com.art.test.jmailtrap;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;


@ExtendWith(MockitoExtension.class)
class JsonBodyHandlerTest {
    @Mock HttpResponse<String> response;
    @Mock HttpClient httpClient;
}