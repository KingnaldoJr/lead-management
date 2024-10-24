package dev.rmjr.leadmanagement.domain.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LeadTest {
    Address address = new Address(UUID.randomUUID(), "Praça da Sé", "123",
            null, "Sé", "São Paulo", "SP", "01001000", LocalDateTime.now());

    @Test
    void givenValidParameters_whenCreatingLead_thenLeadIsCreated() {
        UUID id = UUID.randomUUID();
        String name = "Reinaldo Junior";
        String email = "reinaldo@rmjr.dev";
        LocalDateTime createdAt = LocalDateTime.now();

        Lead lead = new Lead(id, address, name, email, createdAt);

        assertEquals(id, lead.getId());
        assertEquals(address, lead.getAddress());
        assertEquals(name, lead.getName());
        assertEquals(email, lead.getEmail());
        assertEquals(createdAt, lead.getCreatedAt());
    }

    @Test
    void givenNullId_whenCreatingLead_thenThrowsIllegalArgumentException() {
        String name = "Reinaldo Junior";
        String email = "reinaldo@rmjr.dev";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Lead(null, address, name, email, createdAt));
    }

    @Test
    void givenNullAddress_whenCreatingLead_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        String name = "Reinaldo Junior";
        String email = "reinaldo@rmjr.dev";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Lead(id, null, name, email, createdAt));
    }

    @Test
    void givenNullName_whenCreatingLead_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        String email = "reinaldo@rmjr.dev";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Lead(id, address, null, email, createdAt));
    }

    @Test
    void givenInvalidName_whenCreatingLead_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        String email = "reinaldo@rmjr.dev";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Lead(id, address, "Re", email, createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Lead(id, address, "R".repeat(101), email, createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Lead(id, address, "Rei123", email, createdAt));
    }

    @Test
    void givenNullEmail_whenCreatingLead_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        String name = "Reinaldo Junior";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Lead(id, address, name, null, createdAt));
    }

    @Test
    void givenInvalidEmail_whenCreatingLead_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        String name = "Reinaldo Junior";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Lead(id, address, name, "invalid-email", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Lead(id, address, name, "a", createdAt));
        assertThrows(IllegalArgumentException.class, () -> new Lead(id, address, name, "a".repeat(256), createdAt));
    }

    @Test
    void givenNullCreatedAt_whenCreatingLead_thenThrowsIllegalArgumentException() {
        UUID id = UUID.randomUUID();
        String name = "Reinaldo Junior";
        String email = "reinaldo@rmjr.dev";

        assertThrows(IllegalArgumentException.class, () -> new Lead(id, address, name, email, null));
    }
}
