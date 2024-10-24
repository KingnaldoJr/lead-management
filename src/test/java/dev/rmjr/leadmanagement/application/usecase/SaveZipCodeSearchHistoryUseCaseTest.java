package dev.rmjr.leadmanagement.application.usecase;

import dev.rmjr.leadmanagement.application.repository.ZipCodeHistoryRepository;
import dev.rmjr.leadmanagement.domain.entity.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SaveZipCodeSearchHistoryUseCaseTest {

    @Mock
    private ZipCodeHistoryRepository zipCodeHistoryRepository;

    @InjectMocks
    private SaveZipCodeSearchHistoryUseCase saveZipCodeSearchHistoryUseCase;

    @Test
    void givenValidZipCodeAndAddress_whenProcess_thenSavesZipCodeLog() {
        String zipCode = "01001000";
        Address address = new Address(UUID.randomUUID(), "Praça da Sé", "123", null, "Sé", "São Paulo", "SP", zipCode, LocalDateTime.now());

        saveZipCodeSearchHistoryUseCase.process(zipCode, address);

        verify(zipCodeHistoryRepository).saveZipCodeLog(zipCode, address);
    }
}
