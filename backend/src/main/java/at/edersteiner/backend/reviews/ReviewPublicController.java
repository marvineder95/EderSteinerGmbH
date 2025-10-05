// src/main/java/at/edersteiner/backend/reviews/ReviewPublicController.java
package at.edersteiner.backend.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewPublicController {

    private final ReviewCodeService codes;

    @GetMapping("/validate")
    public ResponseEntity<Void> validate(@RequestParam("code") String code) {
        boolean ok = codes.isValid(code.trim().toUpperCase());
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}