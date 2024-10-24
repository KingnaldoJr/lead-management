package dev.rmjr.leadmanagement.application.usecase;

import dev.rmjr.leadmanagement.application.gateway.ZipCodeGateway;
import dev.rmjr.leadmanagement.domain.entity.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetAddressDataByZipCodeUseCaseTest {

    @Mock
    ZipCodeGateway zipCodeGateway;

    @Mock
    SaveZipCodeSearchHistoryUseCase saveZipCodeSearchHistoryUseCase;

    @InjectMocks
    GetAddressDataByZipCodeUseCase getAddressDataByZipCode;

    @Test
    void givenValidZipCode_whenProcess_thenReturnsAddress() {
        String zipCode = "01001000";
        Address address = new Address(UUID.randomUUID(), "Praça da Sé", "123", null, "Sé", "São Paulo", "SP", zipCode, LocalDateTime.now());

        when(zipCodeGateway.getAddressDataByZipCode(zipCode)).thenReturn(address);

        Address result = getAddressDataByZipCode.process(zipCode);

        assertEquals(address, result);
        verify(saveZipCodeSearchHistoryUseCase).process(zipCode, address);
    }

    @Test
    void givenInvalidZipCode_whenProcess_thenThrowsException() {
        String zipCode = "invalid";
        when(zipCodeGateway.getAddressDataByZipCode(zipCode))
                .thenThrow(new IllegalArgumentException("Invalid zip code"));

        assertThrows(IllegalArgumentException.class, () -> getAddressDataByZipCode.process(zipCode));
        verify(saveZipCodeSearchHistoryUseCase, never()).process(anyString(), any(Address.class));
    }
}
