package com.art.test.jmailtrap.validator;

import com.art.test.jmailtrap.data.EmailAddress;
import com.art.test.jmailtrap.data.EmailValidation;
import com.art.test.jmailtrap.data.Mail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {
    Mail validMail = new Mail();
    EmailValidator emailValidator = new EmailValidator();

    @BeforeEach
    void setUp() {
        validMail = new Mail();
        EmailAddress from = new EmailAddress(
                "test@demomailtrap.com",
                "Test");

        EmailAddress to = new EmailAddress(
                "to@example.com",
                "Test");

        String subject = "Hello from Mailtrap!";
        String text = "Welcome to Mailtrap Sending!";
        String html = """
                <html>
                    <head>
                        <title>title</title>
                    </head>
                    <body>
                        <h1>Hello, world!</h1>
                    </body>
                </html>
                """;
        validMail.setFrom(from);
        validMail.setTo(List.of(to));
        validMail.setSubject(subject);
        validMail.setText(text);
        validMail.setHtml(html);
    }

    @Test
    void testValidEmail() {
        EmailValidation result = emailValidator.validate(validMail);
        assertTrue(result.getSuccess());
        assertTrue(result.getErrors().isEmpty());
    }

    @Test
    void testMissingFrom() {
        validMail.setFrom(null);
        EmailValidation result = emailValidator.validate(validMail);
        assertFalse(result.getSuccess());
        assertTrue(result.getErrors().contains(EmailValidator.FROM_REQUIRED));
    }

    @Test
    void testMissingSubject() {
        validMail.setSubject(null);
        EmailValidation result = emailValidator.validate(validMail);
        assertFalse(result.getSuccess());
        assertTrue(result.getErrors().contains(EmailValidator.SUBJECT_REQUIRED));
    }

    @Test
    void testMissingContent() {
        validMail.setText(null);
        validMail.setHtml(null);
        EmailValidation result = emailValidator.validate(validMail);
        assertFalse(result.getSuccess());
        assertTrue(result.getErrors().contains(EmailValidator.CONTENT_REQUIRED));
    }
}
