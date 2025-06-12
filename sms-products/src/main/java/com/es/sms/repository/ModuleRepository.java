package com.es.sms.repository;

import com.es.sms.entity.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Modules entity
 * Provides CRUD operations using JpaRepository
 * Type parameters: <Modules, Integer> specify entity and ID type
 */
@Repository
public interface ModuleRepository extends JpaRepository<Modules, Integer> {
}
