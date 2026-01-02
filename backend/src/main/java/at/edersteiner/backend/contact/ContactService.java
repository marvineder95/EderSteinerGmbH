package at.edersteiner.backend.contact;

import at.edersteiner.backend.contact.dto.ContactRequest;
import at.edersteiner.backend.mail.EmailService;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final EmailService emailService;

    public ContactService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendContact(ContactRequest req) {
        String subject = buildSubject(req);
        String body = buildBody(req);

        emailService.sendContactMail(subject, body, req.email());
    }

    private String buildSubject(ContactRequest req) {
        String topic = safe(req.topic());
        return topic.isBlank()
                ? "Neue Anfrage über die Webseite"
                : "Neue Anfrage über die Webseite: " + topic;
    }

    private String buildBody(ContactRequest req) {
        return """
                Name: %s
                E-Mail: %s
                Telefon: %s
                Wunschtermin: %s

                Nachricht:
                %s
                """.formatted(
                safe(req.name()),
                safe(req.email()),
                safe(req.phone()),
                safe(req.date()),
                safe(req.message())
        );
    }

    private String safe(String v) {
        return (v == null) ? "" : v.trim();
    }
}