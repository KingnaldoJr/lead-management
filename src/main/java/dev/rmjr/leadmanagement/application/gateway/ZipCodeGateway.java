package dev.rmjr.leadmanagement.application.gateway;

import dev.rmjr.leadmanagement.domain.entity.Address;

public interface ZipCodeGateway {

    Address getAddressDataByZipCode(String zipCode);
}
