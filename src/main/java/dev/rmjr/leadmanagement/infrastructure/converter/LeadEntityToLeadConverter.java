package dev.rmjr.leadmanagement.infrastructure.converter;

import dev.rmjr.leadmanagement.domain.entity.Lead;
import dev.rmjr.leadmanagement.infrastructure.entity.LeadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(uses = AddressEntityToAddressConverter.class)
public interface LeadEntityToLeadConverter extends Converter<LeadEntity, Lead> {

    @Override
    @Mapping(target = "address", qualifiedByName = "AddressEntityToAddress")
    Lead convert(LeadEntity source);
}
