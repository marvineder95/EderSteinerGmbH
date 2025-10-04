package at.edersteiner.backend.contact.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContactRequest(
        @NotBlank String name,
        @Email @NotBlank String email,
        String phone,
        String topic,
        String date,      // ISO-String aus deinem Datepicker
        @NotBlank String message
) {}