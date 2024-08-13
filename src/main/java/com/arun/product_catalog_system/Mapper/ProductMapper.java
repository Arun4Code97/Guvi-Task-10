package com.arun.product_catalog_system.Mapper;

import com.arun.product_catalog_system.Dto.ProductDto;
import com.arun.product_catalog_system.Model.Product;

public class ProductMapper {
    public  static Product toMapProduct(ProductDto productDto){
        return new Product(productDto.getId(),productDto.getProductName(), productDto.getProductPrice(), productDto.getProductCategory());
    }
    public static ProductDto toMapProductDto(Product product){
        return new ProductDto(product.getId(), product.getProductName(), product.getProductPrice(), product.getProductCategory());
    }
}
