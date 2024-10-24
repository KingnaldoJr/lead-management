package dev.rmjr.leadmanagement.application.repository;

import dev.rmjr.leadmanagement.domain.entity.Lead;

import java.util.Optional;

public interface LeadRepository {

    Optional<Lead> findByEmail(String email);
    Lead save(Lead lead);
}
