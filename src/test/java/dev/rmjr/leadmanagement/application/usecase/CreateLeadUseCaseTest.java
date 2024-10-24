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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateLeadUseCaseTest {

    @Mock
    LeadRepository leadRepository;

    @InjectMocks
    CreateLeadUseCase createLeadUseCase;

    @Test
    void givenValidLead_whenProcess_thenReturnsSavedLead() {
        Lead lead = new Lead(
                UUID.randomUUID(),
                new Address(UUID.randomUUID(), "Praça da Sé", "123", null, "Sé", "São Paulo", "SP", "01001000", LocalDateTime.now()),
                "Reinaldo Junior", "reinaldo@rmjr.dev", LocalDateTime.now());
        when(leadRepository.save(lead)).thenReturn(lead);

        Lead result = createLeadUseCase.process(lead);

        assertEquals(lead, result);
    }
}
