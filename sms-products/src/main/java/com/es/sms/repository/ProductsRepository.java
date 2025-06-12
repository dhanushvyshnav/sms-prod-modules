package com.es.sms.repository;

import com.es.sms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Product entity
 * Provides CRUD operations using JpaRepository
 * Type parameters: <Product, Integer> specify entity and ID type
 */
@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
}
