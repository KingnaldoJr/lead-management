package dev.rmjr.leadmanagement.infrastructure.entity;

import dev.rmjr.leadmanagement.domain.entity.Address;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "zipcode_search_history")
@Entity
public class ZipCodeSearchHistoryEntity {

    @Id
    private UUID id;

    private String zipcode;

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private Address response;

    @CreatedDate
    private LocalDateTime createdAt;
}
