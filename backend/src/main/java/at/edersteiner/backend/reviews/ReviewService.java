package at.edersteiner.backend.reviews;

import at.edersteiner.backend.reviews.dto.CreateReviewRequest;
import at.edersteiner.backend.reviews.dto.PageDto;
import at.edersteiner.backend.reviews.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository repo;

    @Value("${app.reviews.requireCode:false}")
    private boolean requireCode;

    public ReviewService(ReviewRepository repo) {
        this.repo = repo;
    }

    public PageDto<ReviewDto> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"createdAt"));
        Page<Review> p = repo.findByPublishedTrueOrderByCreatedAtDesc(pageable);
        return new PageDto<>(
                p.map(this::toDto).getContent(),
                p.getNumber(),
                p.getTotalPages()
        );
    }

    public ReviewDto create(CreateReviewRequest req) {
        if (requireCode && (req.code() == null || req.code().isBlank())) {
            throw new IllegalArgumentException("Verifizierungscode erforderlich.");
        }
        Review r = new Review();
        r.setCode(req.code());
        r.setName(req.name());
        r.setRating(req.rating());
        r.setText(req.text());
        // ggf. Moderation:
        // r.setPublished(false);
        r = repo.save(r);
        return toDto(r);
    }

    private ReviewDto toDto(Review r) {
        return new ReviewDto(r.getId(), r.getName(), r.getRating(), r.getText(), r.getCreatedAt());
    }
}