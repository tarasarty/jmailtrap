package com.art.test.jmailtrap.validator;

import com.art.test.jmailtrap.com.art.test.jmailtrap.data.EmailValidation;
import com.art.test.jmailtrap.com.art.test.jmailtrap.data.Mail;

public class MailValidator {

    private final String FILENAME_REQUIRED = "Filename is required.";
    private final String CONTENT_REQUIRED = "Content is required.";
    private final String SUBJECT_REQUIRED = "Subject is required.";
    private final String FROM_REQUIRED = "From is required.";

    public EmailValidation validate(Mail mail) {
        EmailValidation result =  new EmailValidation(true);
        if (mail.getFrom() == null ||
                mail.getFrom().getEmail().isBlank()) {
            result.setSuccess(false);
            result.addError(FROM_REQUIRED);
        }

        if (mail.getSubject() == null ||
                mail.getSubject().isBlank()) {
            result.setSuccess(false);
            result.addError(SUBJECT_REQUIRED);
        }

        if (mail.getText() == null ||
                mail.getText().isBlank()) {
            result.setSuccess(false);
            result.addError(CONTENT_REQUIRED);
        }

        return result;
    }
}
