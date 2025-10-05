package at.edersteiner.backend.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewCodeService {

    private final ReviewCodeRepository repo;
    private static final SecureRandom RNG = new SecureRandom();
    // gut lesbare Zeichen (ohne 0/O, 1/I, B/8 etc.)
    private static final char[] ALPHABET =
            "ABCDEFGHJKLMNPQRSTUVWXYZ2345679".toCharArray();

    /** z.B. ES-7K3Q-2M9A */
    public String generateCode() {
        StringBuilder sb = new StringBuilder("ES-");
        for (int block = 0; block < 2; block++) {      // ES-XXXX-XXXX
            if (block == 1) sb.append('-');
            for (int i = 0; i < 4; i++) {
                sb.append(ALPHABET[RNG.nextInt(ALPHABET.length)]);
            }
        }
        return sb.toString();
    }

    public List<ReviewCode> generateBatch(int count, Integer validDays, String note) {
        List<ReviewCode> list = new ArrayList<>(count);
        Instant expires = validDays != null ? Instant.now().plus(validDays, ChronoUnit.DAYS) : null;

        for (int i = 0; i < count; i++) {
            String code;
            do { code = generateCode(); } while (repo.existsByCode(code));

            ReviewCode rc = new ReviewCode();
            rc.setCode(code);
            rc.setNote(note);
            rc.setExpiresAt(expires);
            list.add(rc);
        }
        return repo.saveAll(list);
    }

    /** nur prüfen */
    public boolean isValid(String code) {
        return repo.findByCode(code)
                .filter(c -> !c.isUsed())
                .filter(c -> c.getExpiresAt() == null || c.getExpiresAt().isAfter(Instant.now()))
                .isPresent();
    }

    /** beim Absenden der Bewertung „verbrauchen“ */
    public ReviewCode consume(String code, Review review) {
        ReviewCode rc = repo.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Code nicht gefunden"));

        if (rc.isUsed()) throw new IllegalStateException("Code bereits verwendet");
        if (rc.getExpiresAt() != null && rc.getExpiresAt().isBefore(Instant.now()))
            throw new IllegalStateException("Code abgelaufen");

        rc.setUsed(true);
        rc.setUsedAt(Instant.now());
        rc.setReview(review);
        return repo.save(rc);
    }

    public List<ReviewCode> findAll() {
        return repo.findAll();
    }
}