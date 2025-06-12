package com.es.sms.controller;

import com.es.sms.dto.ModuleDTO;
import com.es.sms.dto.ProductDTO;
import com.es.sms.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/module")
@CrossOrigin(origins = "*")
@Slf4j
public class ModuleController {

    private final ModuleService moduleService;

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }
    /*
     * Handles dual-purpose endpoint for module details and products list
     * returns list of products associated to that moduleId, otherwise returns module details
     *
     * @param moduleId ID of the module to retrieve
     * @return ResponseEntity containing either ModuleDTO or List<ProductDTO>
     */
    @GetMapping("/{moduleId}")
    public ResponseEntity<?> getModuleAndProducts(@PathVariable Integer moduleId,
                                                  @RequestParam(value = "includeProducts", defaultValue = "false") boolean includeProducts) {
        log.info("Received request for module ID: {}", moduleId);
        if (moduleId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Module ID is required");
        }
        if (includeProducts) {
            List<ProductDTO> productDTO = moduleService.getProductsByModuleId(moduleId);
            log.info("Products retrieved: {}", productDTO);
            return ResponseEntity.ok(productDTO);
        }
        ModuleDTO moduleDTO = moduleService.getModuleDetails(moduleId);
        log.info("Module details retrieved: {}", moduleDTO);
        if (moduleDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Module not found with ID: " + moduleId);
        }
        return ResponseEntity.ok(moduleDTO);
    }
}

