package com.arun.product_catalog_system.Exceptions;

import com.arun.product_catalog_system.Dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductAlreadyExistException.class)
    @ResponseBody
    public ErrorResponse handleProductAlreadyExistException(ProductAlreadyExistException ex)
    {
       return  new ErrorResponse("HTTP Status Code : 409 Conflict", ex.getMessage());
    }
//Disabled below exception as already handled all the common errors using ErrorController - /errors

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ErrorResponse handleGeneralException(Exception ex) {
//        return new ErrorResponse("An error occurred: " , ex.getMessage());
//    }

}
