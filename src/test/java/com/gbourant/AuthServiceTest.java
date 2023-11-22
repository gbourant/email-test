package com.gbourant;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.MockMailbox;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

@QuarkusTest
class AuthServiceTest {

    @Inject
    AuthService authService;

    @Inject
    MockMailbox mockMailbox;

    @BeforeEach
    void before(){
        mockMailbox.clear();
    }

    @Test
    void sendVerificationEmail() {
        var email = "info@iana.org";
        authService.sendVerificationEmail(email, UUID.randomUUID().toString());
        List<Mail> sent = mockMailbox.getMailsSentTo(email);
        Assertions.assertEquals(1,sent.size());
    }

    @Test
    void sendVerificationEmailWithMailer() {
        var email = "info@iana.org";
        authService.sendWithMailer(email, UUID.randomUUID().toString());
        List<Mail> sent = mockMailbox.getMailsSentTo(email);
        Assertions.assertEquals(1,sent.size());
    }

    @Test
    void sendVerificationEmailWithReactiveMailer() {
        var email = "info@iana.org";
        authService.sendWithReactiveMailer(email, UUID.randomUUID().toString());
        List<Mail> sent = mockMailbox.getMailsSentTo(email);
        Assertions.assertEquals(1,sent.size());
    }

}