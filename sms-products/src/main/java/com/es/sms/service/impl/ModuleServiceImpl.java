package com.es.sms.service.impl;

import com.es.sms.dto.ModuleDTO;
import com.es.sms.dto.ProductDTO;
import com.es.sms.entity.Product;
import com.es.sms.exception.ModuleNotFoundException;
import com.es.sms.exception.ProductNotFoundException;
import com.es.sms.repository.ModuleRepository;
import com.es.sms.service.ModuleService;
import com.es.sms.util.EntityToDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.es.sms.entity.Modules;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

@Autowired
    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    /**
     * Retrieves module details by ID and converts to DTO
     * Throws ModuleNotFoundException if module doesn't exist
     */
    @Override
    public ModuleDTO getModuleDetails(Integer moduleId) {
        log.info("Fetching module details for ID: {}", moduleId);
        Optional<Modules> modules = moduleRepository.findById(moduleId);
        if (modules.isPresent()) {
            Modules moduleEntity = modules.get();
            return EntityToDTO.moduleEntityToDTO(moduleEntity);
        }
        throw new ModuleNotFoundException("Module not found for ID: " + moduleId);
    }
    /**
     * Retrieves products associated with a module by ID
     * Throws ProductNotFoundException if module doesn't exist
     */
    @Override
    public List<ProductDTO> getProductsByModuleId(Integer moduleId) throws ProductNotFoundException {
        log.info("Fetching products for module ID: {}", moduleId);
        Optional<Modules> module = moduleRepository.findById(moduleId);
        if (module.isPresent()) {
            Set<Product> products = module.get().getProducts();

            return EntityToDTO.listProductsEntityToDTO(products);
        }
            throw new ProductNotFoundException("Products not found for Module ID: " + moduleId);
    }
}