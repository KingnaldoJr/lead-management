package dev.rmjr.leadmanagement.presentation.controller;

import dev.rmjr.leadmanagement.application.exception.NotFoundException;
import dev.rmjr.leadmanagement.application.usecase.CreateLeadUseCase;
import dev.rmjr.leadmanagement.application.usecase.FindLeadByEmailUseCase;
import dev.rmjr.leadmanagement.domain.entity.Lead;
import dev.rmjr.leadmanagement.domain.util.Patterns;
import dev.rmjr.leadmanagement.presentation.dto.request.LeadRequest;
import dev.rmjr.leadmanagement.presentation.dto.response.LeadResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Validated
@RequestMapping("/leads")
@RestController
public class LeadController {
    private final CreateLeadUseCase createLeadUseCase;
    private final FindLeadByEmailUseCase findLeadByEmail;
    private final ConversionService conversionService;

    @GetMapping
    public ResponseEntity<LeadResponse> getLead(
            @RequestParam("email")
            @Size(min = 1, max = 255, message = "Email must be between 8 and 255 characters")
            @Pattern(regexp = Patterns.EMAIL, message = "Invalid email")
            @Valid String email) {
        Optional<Lead> lead = findLeadByEmail.process(email);

        return lead
                .map(value -> ResponseEntity.ok(conversionService.convert(value, LeadResponse.class)))
                .orElseThrow(() -> new NotFoundException("Lead not found with email: " + email));
    }

    @PostMapping
    public ResponseEntity<LeadResponse> createLead(@RequestBody @Valid LeadRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(conversionService.convert(
                createLeadUseCase.process(conversionService.convert(request, Lead.class)),
                LeadResponse.class));
    }
}
