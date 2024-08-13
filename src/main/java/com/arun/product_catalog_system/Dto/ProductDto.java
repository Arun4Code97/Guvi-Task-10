package com.arun.product_catalog_system.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    Long id;

    @NotNull(message = "product name is required")
    @Size(min = 3,message = "product name must have at least three characters")
    String productName;

    @NotNull(message = "product price is required")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "Invalid product price format. Only numeric values are allowed with up to 2 decimal places.")
    String productPrice;

    @NotNull(message = "product category required")
    @Size(min = 3,message = "product category should have at least three characters")
    String productCategory;
}
