package dev.rmjr.leadmanagement.infrastructure.gateway;

import dev.rmjr.leadmanagement.application.gateway.ZipCodeGateway;
import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.infrastructure.api.ZipCodeApi;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ZipCodeGatewayImpl implements ZipCodeGateway {
    private final ZipCodeApi zipCodeApi;
    private final ConversionService conversionService;

    @Override
    public Address getAddressDataByZipCode(String zipCode) {
        return conversionService.convert(zipCodeApi.getAddressDataByZipCode(zipCode), Address.class);
    }
}
