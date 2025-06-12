//package com.es.sms.service;
//
//import com.es.sms.dto.ModuleDTO;
//import com.es.sms.dto.ProductDTO;
//import com.es.sms.entity.Modules;
//import com.es.sms.entity.Product;
//import com.es.sms.exception.ProductNotFoundException;
//import com.es.sms.repository.ModuleRepository;
//import com.es.sms.service.impl.ModuleServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ModuleServiceTest {
//
//    @Mock
//    private ModuleRepository moduleRepository;
//
//    @InjectMocks
//    private ModuleServiceImpl moduleService;
//
//    private Modules modules;
//    private ModuleDTO expectedModuleDTO;
//    private Product product1;
//    private Product product2;
//    private List<Product> products;
//    private List<ProductDTO> expectedProductDTOs;
//
//@BeforeEach
//    void setUp(){
//        initializeTestData();
//    }
//
//    private void initializeTestData() {
//        modules = new Modules();
//        modules.setModuleId(1);
//        modules.setModuleDesc("Test Module");
//        modules.setStartdate("11-01-2025");
//        modules.setEnddate("23-01-2025");
//
//        expectedModuleDTO = new ModuleDTO();
//        expectedModuleDTO.getModuleId();
//        expectedModuleDTO.getModuleDesc();
//        expectedModuleDTO.getStartdate();
//        expectedModuleDTO.getEnddate();
//
//        product1= new Product();
//        product1.setProductId(1);
//        product1.getProductDesc();
//        product1.getStartdate();
//        product1.getEnddate();
//
//        product2= new Product();
//        product2.setProductId(2);
//        product2.getProductDesc();
//        product2.getStartdate();
//        product2.getEnddate();
//
//        products = Arrays.asList(product1, product2);
//
//        expectedProductDTOs= products.stream().map(product -> {
//            ProductDTO dto = new ProductDTO();
//            dto.setProductId(product.getProductId());
//            dto.setProductDesc(product.getProductDesc());
//            dto.setStartdate(product.getStartdate());
//            dto.setEnddate(product.getEnddate());
//            return dto;
//        }).collect(Collectors.toList());
//}
//
//    @Test
//    void testGetModuleDetails(){
//        Modules modules = new Modules();
//        when( moduleRepository.findById(1)).thenReturn(Optional.of(modules));
//        ModuleDTO moduleDTO = moduleService.getModuleDetails(1);
//        assertEquals(moduleDTO.getModuleId(),modules.getModuleId());
//        assertEquals(moduleDTO.getModuleDesc(), modules.getModuleDesc());
//        assertEquals(moduleDTO.getStartdate(), modules.getStartdate());
//        assertEquals(moduleDTO.getEnddate(), modules.getEnddate());
//        System.out.println("testGetModuleDetails test completed");
//    }
//
//    void testGetProductDetails_InvalidModuleId(){
//    Integer invalidModuleId= -1;
//    when(moduleRepository.findById(invalidModuleId)).thenReturn(Optional.empty());
//    Exception exception= assertThrows(ProductNotFoundException.class, ()-> moduleService.getModuleDetails(invalidModuleId));
//    assertEquals("product not found for ID: "+ invalidModuleId, exception.getMessage());
//        System.out.println("Invalid moduleId test case completed");
//
//    }
//
//}