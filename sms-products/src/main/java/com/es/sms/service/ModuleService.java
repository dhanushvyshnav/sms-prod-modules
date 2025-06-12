package com.es.sms.service;

import com.es.sms.dto.ModuleDTO;
import com.es.sms.dto.ProductDTO;

import java.util.List;

public interface ModuleService {

    ModuleDTO getModuleDetails(Integer id);

    List<ProductDTO> getProductsByModuleId(Integer moduleId);
}
