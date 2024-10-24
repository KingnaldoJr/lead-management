package dev.rmjr.leadmanagement.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ZipCodeResponse {
    private String zipCode;
    private String street;
    private String neighborhood;
    private String city;
    private String state;
}
