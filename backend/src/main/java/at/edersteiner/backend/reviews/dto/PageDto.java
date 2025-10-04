package at.edersteiner.backend.reviews.dto;

import java.util.List;

public record PageDto<T>(List<T> content, int page, int totalPages) {}