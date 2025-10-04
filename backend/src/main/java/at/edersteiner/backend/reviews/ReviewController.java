package at.edersteiner.backend.reviews;

import at.edersteiner.backend.reviews.dto.CreateReviewRequest;
import at.edersteiner.backend.reviews.dto.PageDto;
import at.edersteiner.backend.reviews.dto.ReviewDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping
    public PageDto<ReviewDto> list(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "8") int size) {
        return service.list(page, size);
    }

    @PostMapping
    public ReviewDto create(@Valid @RequestBody CreateReviewRequest req) {
        return service.create(req);
    }
}