package at.edersteiner.backend.contact;

import at.edersteiner.backend.contact.dto.ContactRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Void> send(@Valid @RequestBody ContactRequest req) {
        contactService.sendContact(req);
        return ResponseEntity.ok().build();
    }
}