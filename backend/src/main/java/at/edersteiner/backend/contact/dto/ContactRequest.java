package at.edersteiner.backend.contact.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactRequest(
        @NotBlank @Size(max = 120) String name,
        @NotBlank @Email @Size(max = 200) String email,
        @Size(max = 50) String phone,
        @Size(max = 80) String topic,
        String date, // optional: ISO-String
        @NotBlank @Size(max = 2000) String message
) {}