package com.art.test.jmailtrap;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.art.test.jmailtrap.com.art.test.jmailtrap.data.EmailAddress;
import com.art.test.jmailtrap.com.art.test.jmailtrap.data.EmailValidation;
import com.art.test.jmailtrap.com.art.test.jmailtrap.data.Mail;
import com.art.test.jmailtrap.com.art.test.jmailtrap.data.SendEmailResponse;
import com.art.test.jmailtrap.com.art.test.jmailtrap.data.Settings;
import com.art.test.jmailtrap.validator.EmailValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MailTrapClient {

    private static Logger logger = LogManager.getLogger(HttpClientWrapper.class);

    // API Token:
    private ApiKeyToken apiKeyToken;

    private ObjectMapper objectMapper = new ObjectMapper();

    private HttpClient client = HttpClient.newHttpClient();

    private HttpClientWrapper httpClientWrapper = new HttpClientWrapper(client, objectMapper);

    private EmailValidator mailValidator = new EmailValidator();

    public MailTrapClient(ApiKeyToken apiKeyToken) {
        this.apiKeyToken = apiKeyToken;
    }

    public HttpClientWrapper getHttpClientWrapper() {
        return httpClientWrapper;
    }

    public void setHttpClientWrapper(HttpClientWrapper httpClientWrapper) {
        this.httpClientWrapper = httpClientWrapper;
    }


    private String prepareRequest(Mail mail) throws JsonProcessingException {


        String requestBody = objectMapper.writeValueAsString(mail);
        return requestBody;
    }

    public SendEmailResponse send(EmailAddress from, EmailAddress to, String subject, String text) {
        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setTo(List.of(to));
        mail.setSubject(subject);
        mail.setText(text);

        return send(mail);
    }

    /**
     * send mail
     * @param mail
     * @return errors or success
     */
    public SendEmailResponse send(Mail mail) {
        EmailValidation emailValidation = mailValidator.validate(mail);
        if (!emailValidation.getSuccess()) {
            return emailValidation.toSendEmailResponse();
        }
        return sendMail(mail);
    }

    private SendEmailResponse sendMail(Mail mail) {

        try {
            var requestBody = prepareRequest(mail);

            var request = HttpRequest.newBuilder().uri(URI.create(Settings.SENDING_URL))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .header("Accept", "application/json")
                    .header(apiKeyToken.getName(), apiKeyToken.getValue())
                    .header("Content-Type", "application/json")
                    .build();

            SendEmailResponse result = httpClientWrapper.sendEmail(request);

            logger.info(result);
            return result;
        } catch (IOException e) {
            return new SendEmailResponse(false);
        } catch (InterruptedException e) {
            return new SendEmailResponse(false);
        } catch (ExecutionException e) {
            return new SendEmailResponse(false);
        }
    }


}