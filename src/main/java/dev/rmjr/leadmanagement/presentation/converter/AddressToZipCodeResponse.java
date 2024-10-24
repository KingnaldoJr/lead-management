package dev.rmjr.leadmanagement.presentation.converter;

import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.presentation.dto.response.ZipCodeResponse;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface AddressToZipCodeResponse extends Converter<Address, ZipCodeResponse> {

    @Override
    ZipCodeResponse convert(Address address);
}
