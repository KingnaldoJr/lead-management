package dev.rmjr.leadmanagement.infrastructure.repository;

import dev.rmjr.leadmanagement.infrastructure.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity, String> {}
