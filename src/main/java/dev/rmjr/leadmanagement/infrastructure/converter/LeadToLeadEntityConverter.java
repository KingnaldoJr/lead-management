package dev.rmjr.leadmanagement.infrastructure.converter;

import dev.rmjr.leadmanagement.domain.entity.Lead;
import dev.rmjr.leadmanagement.infrastructure.entity.LeadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(uses = AddressToAddressEntityConverter.class)
public interface LeadToLeadEntityConverter extends Converter<Lead, LeadEntity> {

    @Override
    @Mapping(target = "address", qualifiedByName = "AddressToAddressEntity")
    LeadEntity convert(Lead source);
}
