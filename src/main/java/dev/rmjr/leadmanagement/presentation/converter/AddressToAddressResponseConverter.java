package dev.rmjr.leadmanagement.presentation.converter;

import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.presentation.dto.response.AddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface AddressToAddressResponseConverter extends Converter<Address, AddressResponse> {

    @Override
    @Named("AddressToAddressResponse")
    AddressResponse convert(Address source);
}
