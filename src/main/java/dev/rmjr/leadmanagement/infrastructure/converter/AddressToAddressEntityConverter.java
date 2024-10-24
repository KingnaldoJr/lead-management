package dev.rmjr.leadmanagement.infrastructure.converter;

import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.infrastructure.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface AddressToAddressEntityConverter extends Converter<Address, AddressEntity> {

    @Override
    @Named("AddressToAddressEntity")
    @Mapping(target = "zipcode", source = "zipCode")
    @Mapping(target = "createdAt", expression = "java(java.sql.Timestamp.valueOf(source.getCreatedAt()))")
    AddressEntity convert(Address source);
}
