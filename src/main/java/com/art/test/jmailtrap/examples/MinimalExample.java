package com.art.test.jmailtrap.examples;

import com.art.test.jmailtrap.ApiKeyToken;
import com.art.test.jmailtrap.MailtrapClient;
import com.art.test.jmailtrap.com.art.test.jmailtrap.data.EmailAddress;

/**
 * For this example to work, you need to set up a sending domain,
 * and obtain a token that is authorized to send from the domain.
 *
 */
public class MinimalExample {
    private final static String TOKEN = "";

    public static void main(String... args) {
        MinimalExample minimal = new MinimalExample();
        minimal.sendMinimal();
    }

   public void sendMinimal() {
       ApiKeyToken apiKeyToken = new ApiKeyToken(TOKEN);
       MailtrapClient client = new MailtrapClient(apiKeyToken);
       EmailAddress from = new EmailAddress(
               "test@demomailtrap.com",
               "Test");

       EmailAddress to = new EmailAddress(
               "",
               "Test");

       String subject = "Hello from Mailtrap!";
       String text = "Welcome to Mailtrap Sending!";

       client.send(from, to, subject, text);
   }


}