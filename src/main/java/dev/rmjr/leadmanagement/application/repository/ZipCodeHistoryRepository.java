package dev.rmjr.leadmanagement.application.repository;

import dev.rmjr.leadmanagement.domain.entity.Address;

public interface ZipCodeHistoryRepository {

    void saveZipCodeLog(String zipCode, Address address);
}
