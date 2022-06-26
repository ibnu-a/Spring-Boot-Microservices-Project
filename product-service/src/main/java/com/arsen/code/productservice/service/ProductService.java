package com.arsen.code.productservice.service;

import com.arsen.code.productservice.dto.ProductRequestDto;
import com.arsen.code.productservice.dto.ProductResponseDto;
import com.arsen.code.productservice.entity.Product;
import com.arsen.code.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequestDto productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponseDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();

        return productList.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponseDto mapToProductResponse(Product product){
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
