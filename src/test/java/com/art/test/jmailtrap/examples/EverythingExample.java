package com.art.test.jmailtrap.examples;

import com.art.test.jmailtrap.ApiKeyToken;
import com.art.test.jmailtrap.MailTrapClient;
import com.art.test.jmailtrap.data.Attachment;
import com.art.test.jmailtrap.data.EmailAddress;
import com.art.test.jmailtrap.data.Mail;
import com.art.test.jmailtrap.data.Settings;

import java.util.HashMap;
import java.util.List;

public class EverythingExample {

    public static void main(String... args) {
        EverythingExample everything = new EverythingExample();
        everything.sendMail();
    }

    public void sendMail() {
        var mail = new Mail();

        var fromMailAddress = new EmailAddress(
                "sales@example.com",
                "Example Sales Team");
        mail.setFrom(fromMailAddress);

        var bccMailAddress = new EmailAddress();
        bccMailAddress.setEmail("james_doe@example.com");
        bccMailAddress.setName("Jim Doe");
        mail.setBcc(List.of(bccMailAddress));

        var ccMailAddress = new EmailAddress();
        ccMailAddress.setEmail("jane_doe@example.com");
        ccMailAddress.setName("Jane Doe");
        mail.setCc(List.of(ccMailAddress));

        var toMailAddress = new EmailAddress();
        toMailAddress.setEmail("john_doe@example.com");
        toMailAddress.setName("John Doe");
        mail.setTo(List.of(toMailAddress));

        var attachment = new Attachment();
        attachment.setContent("PCFET0NUWVBFIGh0bWw+CjxodG1sIGxhbmc9ImVuIj4KCiAgICA8aGVhZD4KICAgICAgICA8bWV0YSBjaGFyc2V0PSJVVEYtOCI+CiAgICAgICAgPG1ldGEgaHR0cC1lcXVpdj0iWC1VQS1Db21wYXRpYmxlIiBjb250ZW50PSJJRT1lZGdlIj4KICAgICAgICA8bWV0YSBuYW1lPSJ2aWV3cG9ydCIgY29udGVudD0id2lkdGg9ZGV2aWNlLXdpZHRoLCBpbml0aWFsLXNjYWxlPTEuMCI+CiAgICAgICAgPHRpdGxlPkRvY3VtZW50PC90aXRsZT4KICAgIDwvaGVhZD4KCiAgICA8Ym9keT4KCiAgICA8L2JvZHk+Cgo8L2h0bWw+Cg==");
        attachment.setFilename("index.html");
        attachment.setType("text/html");
        attachment.setDisposition("attachment");
        mail.setAttachments(List.of(attachment));

        mail.setHeaders(new HashMap<>());
        mail.getHeaders().put("X-Message-Source", "dev.mydomain.com");
        mail.setCustomVariables(new HashMap<>());
        mail.getCustomVariables().put("user_id", "45982");
        mail.getCustomVariables().put("batch_id", "PSJ-12");

        var subject = "Your Example Order Confirmation";
        mail.setSubject(subject);

        var text = "Congratulations on your order no. 1234";
        mail.setText(text);

        var category = "API Test";
        mail.setCategory(category);

        ApiKeyToken apiKeyToken = new ApiKeyToken(Settings.getTOKEN());
        MailTrapClient client = new MailTrapClient(apiKeyToken);


        client.send(mail);
    }
}
