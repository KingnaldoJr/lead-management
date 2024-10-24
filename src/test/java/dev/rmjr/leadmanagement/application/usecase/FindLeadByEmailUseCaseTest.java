package dev.rmjr.leadmanagement.application.usecase;

import dev.rmjr.leadmanagement.application.repository.LeadRepository;
import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.domain.entity.Lead;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindLeadByEmailUseCaseTest {

    @Mock
    LeadRepository leadRepository;

    @InjectMocks
    FindLeadByEmailUseCase findLeadByEmailUseCase;

    @Test
    void givenExistingEmail_whenProcess_thenReturnsLead() {
        String email = "test@example.com";
        Lead lead = new Lead(
                UUID.randomUUID(),
                new Address(UUID.randomUUID(), "Praça da Sé", "123", null, "Sé", "São Paulo", "SP", "01001000", LocalDateTime.now()),
                "Reinaldo Junior", "reinaldo@rmjr.dev", LocalDateTime.now());
        when(leadRepository.findByEmail(email)).thenReturn(Optional.of(lead));

        Optional<Lead> result = findLeadByEmailUseCase.process(email);

        assertTrue(result.isPresent());
        assertEquals(lead, result.get());
    }

    @Test
    void givenNonExistingEmail_whenProcess_thenReturnsEmpty() {
        String email = "nonexistent@example.com";
        when(leadRepository.findByEmail(email)).thenReturn(Optional.empty());

        Optional<Lead> result = findLeadByEmailUseCase.process(email);

        assertFalse(result.isPresent());
    }
}
