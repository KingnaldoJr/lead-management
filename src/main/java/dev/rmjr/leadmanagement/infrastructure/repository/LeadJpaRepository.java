package dev.rmjr.leadmanagement.infrastructure.repository;

import dev.rmjr.leadmanagement.infrastructure.entity.LeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LeadJpaRepository extends JpaRepository<LeadEntity, UUID> {
    Optional<LeadEntity> findByEmail(String email);
}
