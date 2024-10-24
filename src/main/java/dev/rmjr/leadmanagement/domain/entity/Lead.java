package dev.rmjr.leadmanagement.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class Lead {
    private UUID id;
    private Address address;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    public Lead(UUID id, Address address, String name, String email, LocalDateTime createdAt) {
        setId(id);
        setAddress(address);
        setName(name);
        setEmail(email);
        setCreatedAt(createdAt);
    }

    public void setId(UUID id) {
        if (id == null)
            throw new IllegalArgumentException("id cannot be null");

        this.id = id;
    }

    public void setAddress(Address address) {
        if (address == null)
            throw new IllegalArgumentException("address cannot be null");

        this.address = address;
    }

    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException("name cannot be null");

        if (name.length() < 3 || name.length() > 100)
            throw new IllegalArgumentException("name must be between 3 and 100 characters");

        if (!name.matches("[\\p{L}\\s]*"))
            throw new IllegalArgumentException("name must contain only letters and spaces");

        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null)
            throw new IllegalArgumentException("email cannot be null");

        if (email.length() < 8 || email.length() > 255)
            throw new IllegalArgumentException("email must be between 3 and 255 characters");

        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new IllegalArgumentException("email must be a valid email address");

        this.email = email;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        if (createdAt == null)
            throw new IllegalArgumentException("createdAt cannot be null");

        this.createdAt = createdAt;
    }
}
