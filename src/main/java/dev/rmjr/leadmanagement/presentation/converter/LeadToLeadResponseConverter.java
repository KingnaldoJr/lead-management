package dev.rmjr.leadmanagement.presentation.converter;

import dev.rmjr.leadmanagement.domain.entity.Lead;
import dev.rmjr.leadmanagement.presentation.dto.response.LeadResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(uses = AddressToAddressResponseConverter.class)
public interface LeadToLeadResponseConverter extends Converter<Lead, LeadResponse> {

    @Override
    @Mapping(target = "address", qualifiedByName = "AddressToAddressResponse")
    LeadResponse convert(Lead source);
}
