package dev.rmjr.leadmanagement.infrastructure.repository;

import dev.rmjr.leadmanagement.application.repository.ZipCodeHistoryRepository;
import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.infrastructure.entity.ZipCodeSearchHistoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class ZipCodeHistoryRepositoryImpl implements ZipCodeHistoryRepository {
    private final ZipCodeHistoryJpaRepository zipCodeHistoryRepository;

    @Override
    public void saveZipCodeLog(String zipCode, Address address) {
        zipCodeHistoryRepository.save(ZipCodeSearchHistoryEntity.builder()
                .id(UUID.randomUUID())
                .zipcode(zipCode)
                .response(address)
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .build());
    }
}
