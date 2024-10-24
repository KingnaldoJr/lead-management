package dev.rmjr.leadmanagement.presentation.dto.request;

import dev.rmjr.leadmanagement.domain.util.Patterns;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeadRequest {

    @NotNull
    @Valid
    private AddressRequest address;

    @NotBlank
    @Size(min = 3, max = 100)
    @Pattern(regexp = Patterns.NAME)
    private String name;

    @NotBlank
    @Size(min = 8, max = 255)
    @Pattern(regexp = Patterns.EMAIL)
    private String email;
}
