package com.gbourant;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuthService {

    @Inject
    Mailer mailer;

    @Inject
    ReactiveMailer reactiveMailer;

    @Location("emails/invite.html")
    Template invite;

    public void sendVerificationEmail(String email, String token) {
        AdminEmailTemplates
                .invite(token)
                .to(email)
                .send();
    }

    public void sendWithMailer(String email, String token) {
        mailer.send(Mail.withHtml(email,"Works fine",invite.render()));
    }

    public void sendWithReactiveMailer(String email, String token) {
        reactiveMailer
                .send(Mail.withHtml(email,"Works fine",invite.render()))
                .await().indefinitely();
    }
}
