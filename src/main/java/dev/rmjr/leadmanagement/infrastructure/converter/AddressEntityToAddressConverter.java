package dev.rmjr.leadmanagement.infrastructure.converter;

import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.infrastructure.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface AddressEntityToAddressConverter extends Converter<AddressEntity, Address> {

    @Override
    @Named("AddressEntityToAddress")
    @Mapping(target = "zipCode", source = "zipcode")
    Address convert(AddressEntity source);
}
