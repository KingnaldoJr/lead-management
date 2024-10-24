package dev.rmjr.leadmanagement.application.usecase;

import dev.rmjr.leadmanagement.application.repository.LeadRepository;
import dev.rmjr.leadmanagement.domain.entity.Lead;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FindLeadByEmailUseCase {
    private final LeadRepository leadRepository;

    public Optional<Lead> process(String email) {
        return leadRepository.findByEmail(email);
    }
}
