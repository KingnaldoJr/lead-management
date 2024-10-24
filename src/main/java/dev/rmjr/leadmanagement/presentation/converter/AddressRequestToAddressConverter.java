package dev.rmjr.leadmanagement.presentation.converter;

import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.presentation.dto.request.AddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface AddressRequestToAddressConverter extends Converter<AddressRequest, Address> {

    @Override
    @Named("AddressRequestToAddress")
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Address convert(AddressRequest source);
}
