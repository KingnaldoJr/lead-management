package dev.rmjr.leadmanagement.application.usecase;

import dev.rmjr.leadmanagement.application.repository.ZipCodeHistoryRepository;
import dev.rmjr.leadmanagement.domain.entity.Address;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveZipCodeSearchHistoryUseCase {
    private final ZipCodeHistoryRepository zipCodeHistoryRepository;

    public void process(String zipCode, Address address) {
        zipCodeHistoryRepository.saveZipCodeLog(zipCode, address);
    }
}
