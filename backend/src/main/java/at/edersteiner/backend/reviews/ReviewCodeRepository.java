package at.edersteiner.backend.reviews;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewCodeRepository extends JpaRepository<ReviewCode, Long> {
    Optional<ReviewCode> findByCode(String code);
    boolean existsByCode(String code);
}