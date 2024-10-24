package dev.rmjr.leadmanagement.infrastructure.converter;

import dev.rmjr.leadmanagement.domain.entity.Address;
import dev.rmjr.leadmanagement.infrastructure.dto.response.ZipCodeDataResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface ZipCodeDataResponseToAddressConverter extends Converter<ZipCodeDataResponse, Address> {

    @Override
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "street", source = "logradouro")
    @Mapping(target = "number", ignore = true)
    @Mapping(target = "complement", ignore = true)
    @Mapping(target = "neighborhood", source = "bairro")
    @Mapping(target = "city", source = "localidade")
    @Mapping(target = "state", source = "uf")
    @Mapping(target = "zipCode", expression = "java(zipCodeDataResponse.getCep().replaceAll(\"-\", \"\"))")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Address convert(ZipCodeDataResponse zipCodeDataResponse);
}
