package at.edersteiner.backend.contact;

import at.edersteiner.backend.contact.dto.ContactRequest;
import at.edersteiner.backend.mail.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<?> send(@Valid @RequestBody ContactRequest req) {
        String subject = "Neue Anfrage über die Website: " + (req.topic() == null ? "-" : req.topic());
        String body = """
        Name: %s
        E-Mail: %s
        Telefon: %s
        Wunschtermin: %s

        Nachricht:
        %s
        """.formatted(req.name(), req.email(), req.phone(), req.date(), req.message());

        emailService.sendContactMail(subject, body, req.email());
        return ResponseEntity.ok().build();
    }
}