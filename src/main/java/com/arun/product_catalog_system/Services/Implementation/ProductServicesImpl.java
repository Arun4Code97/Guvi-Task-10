package com.arun.product_catalog_system.Services.Implementation;

import com.arun.product_catalog_system.Dto.ProductDto;
import com.arun.product_catalog_system.Exceptions.ProductAlreadyExistException;
import com.arun.product_catalog_system.Mapper.ProductMapper;
import com.arun.product_catalog_system.Model.Product;
import com.arun.product_catalog_system.Repository.ProductRepository;
import com.arun.product_catalog_system.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImpl implements ProductServices {
@Autowired
    ProductRepository productRepository;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Optional<Product>  existProduct = productRepository.findByProductNameIgnoreCase(productDto.getProductName());
        if(existProduct.isPresent())
        {
            throw new ProductAlreadyExistException("Product name : " + productDto.getProductName() + " already exist");
        }
        Product createdproduct = productRepository.save(ProductMapper.toMapProduct(productDto));
        return ProductMapper.toMapProductDto(createdproduct);
    }

    @Override
    public List<ProductDto> getAllProductsOrderByCategory() {
        List<Product> allRetrievedProducts = productRepository.findAllByOrderedByProductCategoryIgnoreCaseAsc();
        return allRetrievedProducts.stream().map(ProductMapper::toMapProductDto).toList();
    }

    @Override
    public List<ProductDto> getAllProductsOfSpecificCategory(String givenSpecificCategory) {

        List<Product> allRetrievedProducts = productRepository.findAllBySpecificProductCategoryIgnoreCase(givenSpecificCategory);
        return allRetrievedProducts.stream().map(ProductMapper::toMapProductDto).toList();
    }

    @Override
    public List<String> getAllCategoryNames() {
        return productRepository.findAllProductCategoryNamesAsc();
    }

}
