package com.gbourant;

import io.quarkus.mailer.MailTemplate;
import io.quarkus.qute.CheckedTemplate;

@CheckedTemplate(basePath = "emails", defaultName = CheckedTemplate.HYPHENATED_ELEMENT_NAME)
public class AdminEmailTemplates {
    public static native MailTemplate.MailTemplateInstance invite(String token);
}

