package org.product.support;

import org.hibernate.sql.Update;
import org.product.api.request.UpdateProductRequest;
import org.springframework.stereotype.Component;
import org.product.domain.Product;
import org.product.api.request.ProductRequest;
import org.product.api.response.ProductResponse;

@Component
public class ProductMapper {
    public Product toProduct(ProductRequest productRequest) {
        return new Product(productRequest.getName());
    }

    public Product toProduct(Product product, UpdateProductRequest updateProductRequest) {
        product.setName(updateProductRequest.getName());
        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}
