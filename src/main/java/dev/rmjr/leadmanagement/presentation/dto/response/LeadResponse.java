package dev.rmjr.leadmanagement.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeadResponse {
    private UUID id;
    private AddressResponse address;
    private String name;
    private String email;
    private LocalDateTime createdAt;
}
