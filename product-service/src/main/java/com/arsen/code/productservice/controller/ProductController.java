package com.arsen.code.productservice.controller;

import com.arsen.code.productservice.dto.ProductRequestDto;
import com.arsen.code.productservice.dto.ProductResponseDto;
import com.arsen.code.productservice.entity.Product;
import com.arsen.code.productservice.repository.ProductRepository;
import com.arsen.code.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequestDto productRequestDto){
        productService.createProduct(productRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProduct(){
        return productService.getAllProduct();
    }
}
