package dev.rmjr.leadmanagement.infrastructure.api;

import dev.rmjr.leadmanagement.infrastructure.dto.response.ZipCodeDataResponse;
import dev.rmjr.leadmanagement.infrastructure.exception.CustomErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zipCodeApi", url = "http://localhost:8080/zipcodes", configuration = CustomErrorDecoder.class)
public interface ZipCodeApi {

    @GetMapping("/{zipCode}")
    ZipCodeDataResponse getAddressDataByZipCode(@PathVariable("zipCode") String zipCode);
}
