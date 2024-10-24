package dev.rmjr.leadmanagement.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;


import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "leads")
@Entity
public class LeadEntity {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    private String name;
    private String email;

    @CreatedDate
    private LocalDateTime createdAt;
}
