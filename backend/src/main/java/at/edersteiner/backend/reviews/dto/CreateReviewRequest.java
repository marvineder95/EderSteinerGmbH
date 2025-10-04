package at.edersteiner.backend.reviews.dto;

import jakarta.validation.constraints.*;

public record CreateReviewRequest(
        String code,
        String name,
        @Min(1) @Max(5) int rating,
        @NotBlank @Size(max = 2000) String text // <-- NEU
) {}