//package com.es.sms.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import com.es.sms.dto.ModuleDTO;
//import com.es.sms.dto.ProductDTO;
//import com.es.sms.entity.Modules;
//import com.es.sms.entity.Product;
//import com.es.sms.exception.ProductNotFoundException;
//import com.es.sms.repository.ProductsRepository;
//import com.es.sms.service.impl.ProductServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @Mock
//    private ProductsRepository productRepository;
//
//    @InjectMocks
//    private ProductServiceImpl productService;
//
//    private Product product;
//    private ProductDTO expectedProductDTO;
//    private Modules module1;
//    private Modules module2;
//    private List<Modules> modules;
//    private List<ModuleDTO> expectedModuleDTOs;
//
//    @BeforeEach
//    void setUp() {
//        initializeTestData();
//    }
//
//    private void initializeTestData() {
//        product = new Product();
//        product.setProductId(1);
//        product.setProductDesc("Product 1 Description");
//        product.setStartdate("11-01-2025");
//        product.setEnddate("23-06-2025");
//
//        expectedProductDTO = new ProductDTO();
//        expectedProductDTO.setProductId(1);
//        expectedProductDTO.setProductDesc("Product 1 Description");
//        expectedProductDTO.setStartdate("11-01-2025");
//        expectedProductDTO.setEnddate("23-06-2025");
//
//
//        module1 = new Modules();
//        module1.setModuleId(1);
//        module1.setModuleDesc("Module 1 Description");
//        module1.setStartdate("11-01-2025");
//        module1.setEnddate("15-06-2025");
//
//        module2 = new Modules();
//        module2.setModuleId(2);
//        module2.setModuleDesc("Module 2 Description");
//        module2.setStartdate("23-03-2025");
//        module2.setEnddate("20-06-2025");
//
//        modules = Arrays.asList(module1, module2);
//
//        expectedModuleDTOs = modules.stream().map(module -> {
//            ModuleDTO dto = new ModuleDTO();
//            dto.setModuleId(module.getModuleId());
//            dto.setModuleDesc(module.getModuleDesc());
//            dto.setStartdate(module.getStartdate());
//            dto.setEnddate(module.getEnddate());
//            return dto;
//        }).collect(Collectors.toList());
//    }
//
//    @Test
//    void testGetProductDetails_ValidProductId() {
//        when(productRepository.findById(1)).thenReturn(Optional.of(product));
//        ProductDTO productDTO = productService.getProductDetails(1);
//        assertEquals(expectedProductDTO.getProductId(), productDTO.getProductId());
//        assertEquals(expectedProductDTO.getProductDesc(), productDTO.getProductDesc());
//        assertEquals(expectedProductDTO.getStartdate(), productDTO.getStartdate());
//        assertEquals(expectedProductDTO.getEnddate(), productDTO.getEnddate());
//        System.out.println("Valid productId test : testGetProductDetails_ValidProductId()");
//    }
//
//    @Test
//    void testGetProductDetails_InvalidProductId() {
//        Integer invalidProductId = -1;
//        when(productRepository.findById(invalidProductId)).thenReturn(Optional.empty());
//        Exception exception = assertThrows(ProductNotFoundException.class, () -> {
//            productService.getProductDetails(invalidProductId);
//        });
//        assertEquals("Product not found for ID: " + invalidProductId, exception.getMessage());
//        System.out.println("Invalid productId test : testGetProductDetails_InvalidProductId()");
//    }
//
//    @Test
//    void testGetModulesByProductId_ValidProductId() {
//        when(productRepository.findModulesByProductId(1)).thenReturn(modules);
//        List<ModuleDTO> moduleDTOs = productService.getModulesByProductId(1);
//        assertEquals(expectedModuleDTOs.size(), moduleDTOs.size());
//        for (int i = 0; i < expectedModuleDTOs.size(); i++) {
//            assertEquals(expectedModuleDTOs.get(i).getModuleId(), moduleDTOs.get(i).getModuleId());
//            assertEquals(expectedModuleDTOs.get(i).getModuleDesc(), moduleDTOs.get(i).getModuleDesc());
//            assertEquals(expectedModuleDTOs.get(i).getStartdate(), moduleDTOs.get(i).getStartdate());
//            assertEquals(expectedModuleDTOs.get(i).getEnddate(), moduleDTOs.get(i).getEnddate());
//        }
//        System.out.println("Valid productId test : testGetModulesByProductId_ValidProductId()");
//    }
//
//    @Test
//    void testGetModulesByProductId_InvalidProductId() {
//        Integer invalidProductId = -1;
//        when(productRepository.findModulesByProductId(invalidProductId)).thenReturn(Arrays.asList());
//        Exception exception = assertThrows(ProductNotFoundException.class, () -> {
//            productService.getModulesByProductId(invalidProductId);
//        });
//        assertEquals("Modules not found for Product ID: " + invalidProductId, exception.getMessage());
//        System.out.println("Invalid productId test : testGetModulesByProductId_InvalidProductId()");
//    }
//}