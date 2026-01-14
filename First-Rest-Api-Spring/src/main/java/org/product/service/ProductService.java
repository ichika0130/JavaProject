package org.product.service;

import org.product.api.request.UpdateProductRequest;
import org.product.support.ProductExceptionSupplier;
import org.springframework.stereotype.Service;
import org.product.domain.Product;
import org.product.api.request.ProductRequest;
import org.product.api.response.ProductResponse;
import org.product.repository.OldProductRepository;
import org.product.support.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ProductService {
    private final OldProductRepository productRepository;
    private final ProductMapper productMapper;
    public ProductService(OldProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse find(Long id){
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest){
        Product product = productRepository.findById(id).orElseThrow(
                ProductExceptionSupplier.productNotFound(id)); //这里pdf是productNotFound
        productRepository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll(){
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

    public void delete(Long id){
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id)); //这里该是productNotFound
        productRepository.deleteById(product.getId());
    }

}
