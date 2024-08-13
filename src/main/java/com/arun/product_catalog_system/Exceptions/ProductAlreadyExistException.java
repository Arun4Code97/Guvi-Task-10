package com.arun.product_catalog_system.Exceptions;

public class ProductAlreadyExistException extends RuntimeException{
    // Manually set Condition for adding only unique Product name to the database
    // Also can throw Exception using Spring MVC - @ResponseBody
    public ProductAlreadyExistException(String message){
        super(message);
    }
}
