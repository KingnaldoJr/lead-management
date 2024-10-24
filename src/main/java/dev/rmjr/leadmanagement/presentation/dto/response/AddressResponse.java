package dev.rmjr.leadmanagement.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
}
