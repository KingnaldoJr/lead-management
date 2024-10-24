package dev.rmjr.leadmanagement.presentation.controller;

import dev.rmjr.leadmanagement.application.usecase.GetAddressDataByZipCodeUseCase;
import dev.rmjr.leadmanagement.presentation.dto.response.ZipCodeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Validated
@RequestMapping("/zipcodes")
@RestController
public class ZipCodeController {
    private final GetAddressDataByZipCodeUseCase getAddressDataByZipCodeUseCase;
    private final ConversionService conversionService;

    @GetMapping("/{zipcode}")
    public ResponseEntity<ZipCodeResponse> getZipCodeData(
            @PathVariable(value = "")
            @Valid String zipcode) {
        return ResponseEntity.ok(conversionService.convert(getAddressDataByZipCodeUseCase.process(zipcode), ZipCodeResponse.class));
    }
}
