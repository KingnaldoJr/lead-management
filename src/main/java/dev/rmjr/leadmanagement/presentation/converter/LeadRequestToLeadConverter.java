package dev.rmjr.leadmanagement.presentation.converter;

import dev.rmjr.leadmanagement.domain.entity.Lead;
import dev.rmjr.leadmanagement.presentation.dto.request.LeadRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(uses = AddressRequestToAddressConverter.class)
public interface LeadRequestToLeadConverter extends Converter<LeadRequest, Lead> {

    @Override
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "address", qualifiedByName = "AddressRequestToAddress")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Lead convert(LeadRequest source);
}
