package dev.rmjr.leadmanagement.infrastructure.entity;

import dev.rmjr.leadmanagement.domain.entity.Address;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
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

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp createdAt;
}
