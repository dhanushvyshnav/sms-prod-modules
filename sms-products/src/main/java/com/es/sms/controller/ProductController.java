package com.es.sms.controller;

import com.es.sms.dto.ModuleDTO;
import com.es.sms.dto.ProductDTO;
import com.es.sms.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    /*
     * Retrieves either product details or its modules
     * Returns product details by default, or modules
     *
     * @param productId The ID of the product to retrieve
     * @return ResponseEntity containing either ProductDTO or List<ModuleDTO>
     */
    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductOrModules( @PathVariable Integer productId, @RequestHeader
                                                 @RequestParam(value = "includeModules", defaultValue = "false" ) boolean includeModules) {
        log.info("Received request to retrieve product details for ID: {}", productId);
        if (productId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product ID is required");
        }
        if (includeModules) {
            List<ModuleDTO> moduleDTO = productService.getModulesByProductId(productId);
            log.info("Modules retrieved: {}", moduleDTO);
            return ResponseEntity.ok(moduleDTO);
        }
        ProductDTO productDTO = productService.getProductDetails(productId);
        log.info("Product details: {}", productDTO);
        if (productDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with ID: " + productId);
        }
        return ResponseEntity.ok(productDTO);
    }
}



