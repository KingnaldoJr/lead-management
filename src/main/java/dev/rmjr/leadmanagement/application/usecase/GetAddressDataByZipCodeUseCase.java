package dev.rmjr.leadmanagement.application.usecase;

import dev.rmjr.leadmanagement.application.gateway.ZipCodeGateway;
import dev.rmjr.leadmanagement.domain.entity.Address;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAddressDataByZipCodeUseCase {
    private final ZipCodeGateway zipCodeGateway;
    private final SaveZipCodeSearchHistoryUseCase saveZipCodeSearchHistoryUseCase;

    public Address process(String zipCode) {
        Address address = zipCodeGateway.getAddressDataByZipCode(zipCode);

        saveZipCodeSearchHistoryUseCase.process(zipCode, address);

        return address;
    }
}
