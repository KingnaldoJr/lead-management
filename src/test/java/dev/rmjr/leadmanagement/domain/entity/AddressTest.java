package dev.rmjr.leadmanagement.domain.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void givenValidParameters_whenCreatingAddress_thenAddressIsCreated() {
        UUID id = UUID.randomUUID();
        String street = "Praça da Sé";
        String number = "123";
        String complement = "Apto 48C";
        String neighborhood = "Sé";
        String city = "São Paulo";
        String state = "SP";
        String zipCode = "01001000";
        LocalDateTime createdAt = LocalDateTime.now();

        Address address = new Address(id, street, number, complement, neighborhood, city, state, zipCode, createdAt);

        assertEquals(id, address.getId());
        assertEquals(street, address.getStreet());
        assertEquals(number, address.getNumber());
        assertEquals(complement, address.getComplement());
        assertEquals(neighborhood, address.getNeighborhood());
        assertEquals(city, address.getCity());
        assertEquals(state, address.getState());
        assertEquals(zipCode, address.getZipCode());
        assertEquals(createdAt, address.getCreatedAt());
    }

    @Test
    void givenValidParametersWithNullComplement_whenCreatingAddress_thenAddressIsCreated() {
        UUID id = UUID.randomUUID();
        String street = "Praça da Sé";
        String number = "123";
        String neighborhood = "Sé";
        String city = "São Paulo";
        String state = "SP";
        String zipCode = "01001000";
        LocalDateTime createdAt = LocalDateTime.now();

        Address address = new Address(id, street, number, null, neighborhood, city, state, zipCode, createdAt);

        assertEquals(id, address.getId());
        assertEquals(street, address.getStreet());
        assertEquals(number, address.getNumber());
        assertNull(address.getComplement());
        assertEquals(neighborhood, address.getNeighborhood());
        assertEquals(city, address.getCity());
        assertEquals(state, address.getState());
        assertEquals(zipCode, address.getZipCode());
        assertEquals(createdAt, address.getCreatedAt());
    }

    @Test
    void givenNullId_whenCreatingAddress_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Address(null, "Praça da Sé", "123", "Apto 48C", "Sé", "São Paulo", "SP", "01001000", LocalDateTime.now()));
    }

    @Test
    void givenInvalidStreet_whenCreatingAddress_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Address(id, null, "123", "Apto 48C", "Sé", "São Paulo", "SP", "01001000", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "St", "123", "Apto 48C", "Sé", "São Paulo", "SP", "01001000", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "S".repeat(256), "123", "Apto 48C", "Sé", "São Paulo", "SP", "01001000", createdAt));
    }

    @Test
    void givenInvalidNumber_whenCreatingAddress_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", null, "Apto 48C", "Sé", "São Paulo", "SP", "01001000", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "", "Apto 48C", "Sé", "São Paulo", "SP", "01001000", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "1".repeat(11), "Apto 48C", "Sé", "São Paulo", "SP", "01001000", createdAt));
    }

    @Test
    void givenInvalidComplement_whenCreatingAddress_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "C".repeat(256), "Sé", "São Paulo", "SP", "01001000", createdAt));
    }

    @Test
    void givenInvalidNeighborhood_whenCreatingAddress_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", null, "São Paulo", "SP", "01001000", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "", "São Paulo", "SP", "01001000", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "N".repeat(101), "São Paulo", "SP", "01001000", createdAt));
    }

    @Test
    void givenInvalidCity_whenCreatingAddress_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", null, "SP", "01001000", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", "Ci", "SP", "01001000", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", "C".repeat(101), "SP", "01001000", createdAt));
    }

    @Test
    void givenInvalidState_whenCreatingAddress_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", "São Paulo", null, "01001000", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", "São Paulo", "N", "01001000", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", "São Paulo", "SPC", "01001000", createdAt));
    }

    @Test
    void givenInvalidZipCode_whenCreatingAddress_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", "São Paulo", "SP", null, createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", "São Paulo", "SP", "1234567", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", "São Paulo", "SP", "010010009", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", "São Paulo", "SP", "1234abcd", createdAt));
    }

    @Test
    void givenNullCreatedAt_whenCreatingAddress_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();

        assertThrows(IllegalArgumentException.class, () -> new Address(id, "Praça da Sé", "123", "Apto 48C", "Sé", "São Paulo", "SP", "01001000", null));
    }
}
