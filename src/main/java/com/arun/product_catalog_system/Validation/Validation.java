package com.arun.product_catalog_system.Validation;

import com.arun.product_catalog_system.Dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
// Have not used this Manually written Java based Validation Class
// Used Spring Validation in the Controller
@Component
public class Validation {

    public List<String> validateCreateProductRequest(ProductDto productDto){
        List<String> validationErrors = new ArrayList<>();

        if(productDto.getProductName() == null || productDto.getProductName().isEmpty())
            validationErrors.add("Product name is required");

        if(productDto.getProductPrice() == null   )
            validationErrors.add("Valid product price is required");

        if(productDto.getProductCategory() == null || productDto.getProductCategory().isEmpty())
            validationErrors.add("product category is required");

        return validationErrors;
    }
}
