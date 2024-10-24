package dev.rmjr.leadmanagement.domain.entity;

import dev.rmjr.leadmanagement.domain.util.Patterns;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class Address {
    private UUID id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private LocalDateTime createdAt;

    public Address(UUID id, String street, String number, String complement, String neighborhood, String city, String state, String zipCode, LocalDateTime createdAt) {
        setId(id);
        setStreet(street);
        setNumber(number);
        setComplement(complement);
        setNeighborhood(neighborhood);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
        setCreatedAt(createdAt);
    }

    public void setId(UUID id) {
        if (id == null)
            throw new IllegalArgumentException("id cannot be null");

        this.id = id;
    }

    public void setStreet(String street) {
        if (street == null)
            throw new IllegalArgumentException("street cannot be null");

        if (street.length() < 3 || street.length() > 255)
            throw new IllegalArgumentException("street must be between 3 and 255 characters");

        this.street = street;
    }

    public void setNumber(String number) {
        if (number == null) return;

        if (number.isEmpty() || number.length() > 10)
            throw new IllegalArgumentException("number must be between 1 and 10 characters");

        this.number = number;
    }

    public void setComplement(String complement) {
        if (complement == null) return;

        if (complement.length() > 100)
            throw new IllegalArgumentException("complement must be less than 255 characters");

        this.complement = complement;
    }

    public void setNeighborhood(String neighborhood) {
        if (neighborhood == null)
            throw new IllegalArgumentException("neighborhood cannot be null");

        if (neighborhood.isEmpty() || neighborhood.length() > 100)
            throw new IllegalArgumentException("neighborhood must be between 1 and 100 characters");

        this.neighborhood = neighborhood;
    }

    public void setCity(String city) {
        if (city == null)
            throw new IllegalArgumentException("city cannot be null");

        if (city.length() < 3 || city.length() > 100)
            throw new IllegalArgumentException("city must be between 3 and 100 characters");

        this.city = city;
    }

    public void setState(String state) {
        if (state == null)
            throw new IllegalArgumentException("state cannot be null");

        if (state.length() != 2)
            throw new IllegalArgumentException("state must be 2 characters");

        this.state = state;
    }

    public void setZipCode(String zipCode) {
        if (zipCode == null)
            throw new IllegalArgumentException("zipCode cannot be null");

        if (zipCode.length() != 8)
            throw new IllegalArgumentException("zipCode must be 8 characters");

        if (!zipCode.matches(Patterns.ZIPCODE))
            throw new IllegalArgumentException("zipCode must contain only numbers");

        this.zipCode = zipCode;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        if (createdAt == null)
            throw new IllegalArgumentException("createdAt cannot be null");

        this.createdAt = createdAt;
    }
}
