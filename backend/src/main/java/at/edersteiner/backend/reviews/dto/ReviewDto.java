package at.edersteiner.backend.reviews.dto;

import java.time.Instant;

public record ReviewDto(
        Long id, String name, int rating, String text, Instant createdAt
) {}