package com.es.sms.service;

import com.es.sms.dto.ModuleDTO;
import com.es.sms.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO getProductDetails(Integer id);

    List<ModuleDTO> getModulesByProductId(Integer productId);
}
