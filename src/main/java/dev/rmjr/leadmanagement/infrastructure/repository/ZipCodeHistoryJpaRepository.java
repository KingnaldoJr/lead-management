package dev.rmjr.leadmanagement.infrastructure.repository;

import dev.rmjr.leadmanagement.infrastructure.entity.ZipCodeSearchHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ZipCodeHistoryJpaRepository extends JpaRepository<ZipCodeSearchHistoryEntity, UUID> {}
