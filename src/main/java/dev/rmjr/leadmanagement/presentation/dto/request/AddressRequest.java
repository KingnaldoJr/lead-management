package dev.rmjr.leadmanagement.presentation.dto.request;

import dev.rmjr.leadmanagement.domain.util.Patterns;
import jakarta.validation.constraints.NotBlank;
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
public class AddressRequest {

    @NotBlank
    @Size(min = 3, max = 255)
    private String street;

    @NotBlank
    @Size(min = 1, max = 10)
    private String number;

    @Size(max = 255)
    private String complement;

    @NotBlank
    @Size(min = 3, max = 255)
    private String neighborhood;

    @NotBlank
    @Size(min = 3, max = 255)
    private String city;

    @NotBlank
    @Size(min = 2, max = 2)
    private String state;

    @NotBlank
    @Size(min = 8, max = 8)
    @Pattern(regexp = Patterns.ZIPCODE)
    private String zipCode;
}
