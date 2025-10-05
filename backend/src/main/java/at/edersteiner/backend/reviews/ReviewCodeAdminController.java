// src/main/java/at/edersteiner/backend/reviews/ReviewCodeAdminController.java
package at.edersteiner.backend.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/review-codes")
@RequiredArgsConstructor
public class ReviewCodeAdminController {

    private final ReviewCodeService service;

    public record GenerateRequest(int count, Integer validDays, String note) {}
    public record GenerateResponse(List<String> codes) {}

    @PostMapping
    public GenerateResponse generate(@RequestBody GenerateRequest req) {
        var list = service.generateBatch(
                Math.max(1, req.count()),
                req.validDays(),
                req.note()
        );
        return new GenerateResponse(list.stream().map(ReviewCode::getCode).toList());
    }

    @GetMapping(value = "/export.csv", produces = "text/csv")
    public String exportCsv() {
        var sb = new StringBuilder("code;note;expiresAt;used\n");
        service.findAll().forEach(rc ->
                sb.append(rc.getCode()).append(';')
                        .append(rc.getNote() == null ? "" : rc.getNote()).append(';')
                        .append(rc.getExpiresAt()).append(';')
                        .append(rc.isUsed()).append('\n')
        );
        return sb.toString();
    }
}