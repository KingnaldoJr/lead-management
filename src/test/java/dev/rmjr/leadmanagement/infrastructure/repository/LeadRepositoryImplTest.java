package dev.rmjr.leadmanagement.infrastructure.repository;

import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.domain.entity.Lead;
import dev.rmjr.leadmanagement.infrastructure.entity.LeadEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LeadRepositoryImplTest {

    @Mock
    LeadJpaRepository leadRepository;

    @Mock
    AddressJpaRepository addressRepository;

    @Mock
    ConversionService conversionService;

    @InjectMocks
    LeadRepositoryImpl leadRepositoryImpl;

        @Test
    void givenExistingEmail_whenFindByEmail_thenReturnsLead() {
        String email = "john.doe@example.com";
        LeadEntity leadEntity = new LeadEntity();
        Lead lead = Lead.builder()
                .id(UUID.randomUUID())
                .address(Address.builder()
                        .id(UUID.randomUUID())
                        .street("Praça da Sé")
                        .number("123")
                        .neighborhood("Sé")
                        .city("São Paulo")
                        .state("SP")
                        .zipCode("01001000")
                        .createdAt(LocalDateTime.now())
                        .build())
                .name("Reinaldo Junior")
                .email(email)
                .createdAt(LocalDateTime.now())
                .build();

        when(leadRepository.findByEmail(email))
                .thenReturn(Optional.of(leadEntity));
        when(conversionService.convert(leadEntity, Lead.class))
                .thenReturn(lead);

        Optional<Lead> result = leadRepositoryImpl.findByEmail(email);

        assertTrue(result.isPresent());
        assertEquals(lead, result.get());
    }

    @Test
    void givenNonExistingEmail_whenFindByEmail_thenReturnsEmpty() {
        String email = "non.existing@example.com";
        when(leadRepository.findByEmail(email)).thenReturn(Optional.empty());

        Optional<Lead> result = leadRepositoryImpl.findByEmail(email);

        assertFalse(result.isPresent());
    }

    @Test
    void givenValidLead_whenSave_thenReturnsSavedLead() {
        Lead lead = Lead.builder()
                .id(UUID.randomUUID())
                .address(Address.builder()
                        .id(UUID.randomUUID())
                        .street("Praça da Sé")
                        .number("123")
                        .neighborhood("Sé")
                        .city("São Paulo")
                        .state("SP")
                        .zipCode("01001000")
                        .createdAt(LocalDateTime.now())
                        .build())
                .name("Reinaldo Junior")
                .email("john.doe@example.com")
                .createdAt(LocalDateTime.now())
                .build();
        LeadEntity leadEntity = new LeadEntity();
        when(conversionService.convert(lead, LeadEntity.class)).thenReturn(leadEntity);
        when(leadRepository.save(leadEntity)).thenReturn(leadEntity);
        when(conversionService.convert(leadEntity, Lead.class)).thenReturn(lead);

        Lead result = leadRepositoryImpl.save(lead);

        assertEquals(lead, result);
    }
}
