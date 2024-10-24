package dev.rmjr.leadmanagement.infrastructure.repository;

import dev.rmjr.leadmanagement.application.repository.LeadRepository;
import dev.rmjr.leadmanagement.domain.entity.Lead;
import dev.rmjr.leadmanagement.infrastructure.entity.LeadEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class LeadRepositoryImpl implements LeadRepository {
    private final LeadJpaRepository leadRepository;
    private final AddressJpaRepository addressRepository;
    private final ConversionService conversionService;

    @Override
    public Optional<Lead> findByEmail(String email) {
        return leadRepository.findByEmail(email)
                .map(lead -> conversionService.convert(lead, Lead.class));
    }

    @Override
    public Lead save(Lead lead) {
        return conversionService.convert(
                leadRepository.save(conversionService.convert(lead, LeadEntity.class)),
                Lead.class);
    }
}
