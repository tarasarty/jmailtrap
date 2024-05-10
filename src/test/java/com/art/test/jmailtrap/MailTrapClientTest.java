package com.art.test.jmailtrap;

import com.art.test.jmailtrap.data.EmailAddress;
import com.art.test.jmailtrap.data.Mail;
import com.art.test.jmailtrap.data.SendEmailResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MailTrapClientTest {
    private MailTrapClient mailTrapClient;

    @Mock
    private HttpClientWrapper httpClientWrapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ApiKeyToken apiKeyToken = new ApiKeyToken("");
        mailTrapClient = new MailTrapClient(apiKeyToken);
        mailTrapClient.setHttpClientWrapper(httpClientWrapper);
    }

    @Test
    void testSuccessfulEmailSending() throws InterruptedException, ExecutionException {

        Mail mail = createTestMail();

        SendEmailResponse sendEmailResponse = new SendEmailResponse(Boolean.TRUE);

        when(httpClientWrapper.sendEmail(any(HttpRequest.class)))
                .thenReturn(sendEmailResponse);
        SendEmailResponse result = mailTrapClient.send(mail.getFrom(), mail.getTo().get(0), mail.getSubject(), mail.getText());
        assertTrue(result.getSuccess());
    }

    @Test
    void testEmailSendingFailure() throws InterruptedException, ExecutionException {
        Mail mail = createTestMail();

        when(httpClientWrapper.sendEmail(any()))
                .thenThrow(new InterruptedException("Connection error X"));

        SendEmailResponse result = mailTrapClient.send(mail.getFrom(), mail.getTo().get(0), mail.getSubject(), mail.getText());

        assertFalse(result.getSuccess());
    }

    private Mail createTestMail(){
        EmailAddress from = new EmailAddress(
                "test@demomailtrap.com",
                "Test");

        EmailAddress to = new EmailAddress(
                "",
                "Test");

        String subject = "Hello from Mailtrap!";
        String text = "Welcome to Mailtrap Sending!";
        Mail result = new Mail();
        result.setFrom(from);
        result.setTo(List.of(to));
        result.setSubject(subject);
        result.setText(text);
        return result;
    }

}