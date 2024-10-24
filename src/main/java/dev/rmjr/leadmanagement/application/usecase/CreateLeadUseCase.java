package dev.rmjr.leadmanagement.application.usecase;

import dev.rmjr.leadmanagement.application.repository.LeadRepository;
import dev.rmjr.leadmanagement.domain.entity.Lead;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateLeadUseCase {
    private final LeadRepository leadRepository;

    public Lead process(Lead lead) {
        return leadRepository.save(lead);
    }
}
