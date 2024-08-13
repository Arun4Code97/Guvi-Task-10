package com.arun.product_catalog_system.Services;

import com.arun.product_catalog_system.Dto.ProductDto;

import java.util.List;

public interface ProductServices {

    ProductDto addProduct(ProductDto productDto);
    List<ProductDto> getAllProductsOrderByCategory();
    List<ProductDto> getAllProductsOfSpecificCategory(String givenSpecificCategory);
    List<String> getAllCategoryNames();
}
