package com.art.test.jmailtrap.examples;

import com.art.test.jmailtrap.ApiKeyToken;
import com.art.test.jmailtrap.MailTrapClient;
import com.art.test.jmailtrap.data.EmailAddress;
import com.art.test.jmailtrap.data.Settings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * For this example to work, you need to set up a sending domain,
 * and obtain a token that is authorized to send from the domain.
 *
 */
public class MinimalExample {

    private static Logger logger = LogManager.getLogger(MinimalExample.class);

    public static void main(String... args) {
        MinimalExample minimal = new MinimalExample();
        minimal.sendMinimal();
    }

   public void sendMinimal() {
       ApiKeyToken apiKeyToken = new ApiKeyToken(Settings.getTOKEN());
       MailTrapClient client = new MailTrapClient(apiKeyToken);
       EmailAddress from = new EmailAddress(
               "test@demomailtrap.com",
               "Test");

       EmailAddress to = new EmailAddress(
               "",
               "Test");

       String subject = "";
       String text = "Welcome to Mailtrap Sending!";

       var response = client.send(from, to, subject, text);

       logger.info("Response from mailtrap server " + response);
   }


}