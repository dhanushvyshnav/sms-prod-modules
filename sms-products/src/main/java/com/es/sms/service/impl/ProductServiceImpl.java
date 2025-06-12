package com.es.sms.service.impl;

import com.es.sms.dto.ModuleDTO;
import com.es.sms.dto.ProductDTO;
import com.es.sms.entity.Modules;
import com.es.sms.entity.Product;
import com.es.sms.exception.ModuleNotFoundException;
import com.es.sms.exception.ProductNotFoundException;
import com.es.sms.repository.ProductsRepository;
import com.es.sms.service.ProductService;
import com.es.sms.util.EntityToDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductsRepository productRepository) {
        this.productRepository = productRepository;
    }
    /*
     * Retrieves product details by ID and converts to DTO
     * Throws ProductNotFoundException if product doesn't exist
     */
    @Override
    public ProductDTO getProductDetails(Integer productId) {
        log.info("Fetching product details for ID: {}", productId);
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            Product productEntity = product.get();
        return EntityToDTO.productEntityToDTO(productEntity);
        }
        throw new ProductNotFoundException("Product not found for ID: " + productId);
    }

/*
 * Fetches all modules associated with a product ID
 * Throws ModuleNotFoundException if product doesn't exist
 */
    @Override
    public List<ModuleDTO> getModulesByProductId(Integer productId) {
        log.info("Fetching modules for product ID: {}", productId);
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            Set<Modules> modules = product.get().getModules();
            return EntityToDTO.listModulesEntityToDTO(modules);
        }
            throw new ModuleNotFoundException("Modules not found for Product ID: " + productId);
    }
}