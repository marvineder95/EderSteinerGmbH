package at.edersteiner.backend.reviews;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "review_codes", indexes = {
        @Index(name = "idx_review_codes_code", columnList = "code", unique = true)
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReviewCode {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** z.B. ES-7K3Q-2M9A */
    @Column(nullable = false, unique = true, length = 32)
    private String code;

    /** optional – um Codes intern zuzuordnen (Rechnung, Auftrag etc.) */
    private String note;

    /** wann erzeugt */
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant createdAt;

    /** optional – bis wann gültig */
    private Instant expiresAt;

    /** wurde bereits für eine Bewertung verwendet? */
    private boolean used;

    /** wann verwendet */
    private Instant usedAt;

    /** optional – Referenz auf die erstellte Review */
    @OneToOne(fetch = FetchType.LAZY)
    private Review review;
}