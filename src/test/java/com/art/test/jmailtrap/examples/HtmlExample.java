package com.art.test.jmailtrap.examples;

import com.art.test.jmailtrap.ApiKeyToken;
import com.art.test.jmailtrap.MailTrapClient;
import com.art.test.jmailtrap.data.EmailAddress;
import com.art.test.jmailtrap.data.Mail;
import com.art.test.jmailtrap.data.Settings;

import java.util.List;

public class HtmlExample {
    public static void main(String... args) {
        HtmlExample html = new HtmlExample();
        html.sendHtml();
    }

    public void sendHtml() {
        ApiKeyToken apiKeyToken = new ApiKeyToken(Settings.getTOKEN());
        MailTrapClient client = new MailTrapClient(apiKeyToken);
        EmailAddress from = new EmailAddress(
                "test@demomailtrap.com",
                "Test");

        EmailAddress to = new EmailAddress(
                "artymyshynt@gmail.com",
                "Test");

        String subject = "Hello from Mailtrap!";
        String text = "Welcome to Mailtrap Sending!";
        String html = """
            <!doctype html>
            <html>
              <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              </head>
              <body style="font-family: sans-serif;">
                <div style="display: block; margin: auto; max-width: 600px;" class="main">
                  <h1 style="font-size: 18px; font-weight: bold; margin-top: 20px">Congrats for sending test email with Mailtrap!</h1>
                  <p>Inspect it using the tabs you see above and learn how this email can be improved.</p>
                  <img alt="Inspect with Tabs" src="cid:welcome.png" style="width: 100%;">
                  <p>Now send your email using our fake SMTP server and integration of your choice!</p>
                  <p>Good luck! Hope it works.</p>
                </div>
                <!-- Example of invalid for email html/css, will be detected by Mailtrap: -->
                <style>
                  .main { background-color: white; }
                a:hover { border-left-width: 1em; min-height: 2em; }
                </style>
              </body>
            </html>
        """;

        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setTo(List.of(to));
        mail.setHtml(html);
        mail.setText(text);
        mail.setSubject(subject);
        var category = "API Test";
        mail.setCategory(category);

        client.send(mail);
    }


}
