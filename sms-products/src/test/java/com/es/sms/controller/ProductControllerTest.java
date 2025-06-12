package com.es.sms.controller;

import com.es.sms.dto.ProductDTO;
import com.es.sms.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//class ProductControllerTest {
//
//    @Mock
//    private ProductService productService;
//
//    @InjectMocks
//    private ProductController productController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetProductDetails_WithValidTokenAndProductFound() {
//        Integer productId = 1;
//        String authToken = "1";
//        ProductDTO product = new ProductDTO();
//        when(productService.getProductDetails(productId)).thenReturn(product);
//
//        ResponseEntity<ProductDTO> response = productController.getProductDetails(productId, authToken);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(product, response.getBody());
//        verify(productService, times(1)).getProductDetails(productId);
//    }
//
//    @Test
//    void testGetProductDetails_WithInvalidToken() {
//        Integer productId = 123;
//        String authToken = "invalid";
//
//        ResponseEntity<ProductDTO> response = productController.getProductDetails(productId, authToken);
//
//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//        assertEquals(null, response.getBody());
//        verify(productService, never()).getProductDetails(productId);
//    }
//
//    @Test
//    void testGetProductDetails_WithValidTokenAndProductNotFound() {
//        Integer productId = 123;
//        String authToken = "1";
//        when(productService.getProductDetails(productId)).thenReturn(null);
//
//        ResponseEntity<ProductDTO> response = productController.getProductDetails(productId, authToken);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals(null, response.getBody());
//        verify(productService, times(1)).getProductDetails(productId);
//    }
//}
