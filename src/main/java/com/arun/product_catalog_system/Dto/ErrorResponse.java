package com.arun.product_catalog_system.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    String errorCode;
    String errorMessage;
}
