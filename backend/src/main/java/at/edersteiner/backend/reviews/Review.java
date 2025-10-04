package at.edersteiner.backend.reviews;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int rating;

    @Column(name = "text", length = 2000, nullable = false)
    private String text;

    @Column(length = 2000)
    private String message;

    @Column(unique = true)
    private String code;

    private boolean published = false;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant createdAt;
}