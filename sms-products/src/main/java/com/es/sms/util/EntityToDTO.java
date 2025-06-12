package com.es.sms.util;

import com.es.sms.dto.ModuleDTO;
import com.es.sms.dto.ProductDTO;
import com.es.sms.entity.Modules;
import com.es.sms.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class EntityToDTO {


    public static ProductDTO productEntityToDTO(Product productEntity) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(productEntity.getProductId());
            productDTO.setProductDesc(productEntity.getProductDesc());
            productDTO.setStartdate(productEntity.getStartdate());
            productDTO.setEnddate(productEntity.getEnddate());
            return productDTO;
    }

    public static List<ModuleDTO> listModulesEntityToDTO(Set<Modules> modules) {
        return modules.stream().map(module -> new ModuleDTO(
                module.getModuleId(),
                module.getModuleDesc(),
                module.getStartdate(),
                module.getEnddate()
        )).toList();
    }

    public static ModuleDTO moduleEntityToDTO(Modules modulesEntity) {
        ModuleDTO moduleDTO= new ModuleDTO();
        moduleDTO.setModuleId(modulesEntity.getModuleId());
        moduleDTO.setModuleDesc(modulesEntity.getModuleDesc());
        moduleDTO.setStartdate(modulesEntity.getStartdate());
        moduleDTO.setEnddate(modulesEntity.getEnddate());
        return moduleDTO;
    }

    public static List<ProductDTO> listProductsEntityToDTO(Set<Product> products) {
        return products.stream().map(product -> new ProductDTO(
                product.getProductId(),
                product.getProductDesc(),
                product.getStartdate(),
                product.getEnddate()
        )).toList();
    }
}
