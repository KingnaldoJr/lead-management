package dev.rmjr.leadmanagement.infrastructure.repository;

import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.infrastructure.entity.ZipCodeSearchHistoryEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ZipCodeHistoryRepositoryImplTest {

    @Mock
    ZipCodeHistoryJpaRepository zipCodeHistoryRepository;

    @InjectMocks
    ZipCodeHistoryRepositoryImpl zipCodeHistoryRepositoryImpl;

    @Test
    void givenValidZipCodeAndAddress_whenSaveZipCodeLog_thenSavesEntity() {
        String zipCode = "12345678";
        Address address = new Address(UUID.randomUUID(), "Praça da Sé", "123",
                null, "Sé", "São Paulo", "SP", zipCode, LocalDateTime.now());

        zipCodeHistoryRepositoryImpl.saveZipCodeLog(zipCode, address);

        ArgumentCaptor<ZipCodeSearchHistoryEntity> captor = ArgumentCaptor.forClass(ZipCodeSearchHistoryEntity.class);
        verify(zipCodeHistoryRepository).save(captor.capture());
        ZipCodeSearchHistoryEntity savedEntity = captor.getValue();

        assertNotNull(savedEntity.getId());
        assertEquals(zipCode, savedEntity.getZipcode());
        assertEquals(address, savedEntity.getResponse());
        assertNotNull(savedEntity.getCreatedAt());
    }
}
