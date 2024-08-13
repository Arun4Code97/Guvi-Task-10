package com.arun.product_catalog_system.Controller;


import com.arun.product_catalog_system.Dto.ProductDto;
import com.arun.product_catalog_system.Services.ProductServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product-catalog")
public class ProductController {
    @Autowired
    ProductServices productServices;

    @GetMapping
    public String homePage(Model model) {
        return "product-catalog-home";
    }

    @GetMapping("/add-product")
    public String handlerMethodForFormRequest(Model model){
        ProductDto newProduct = new ProductDto();
        model.addAttribute("newProduct", newProduct);
        return "add-product-form";
    }
    @PostMapping("/add-product")
    public String handlerMethodForFormSubmission(@Valid @ModelAttribute("newProduct") ProductDto clonedNewProduct, BindingResult result,Model model){
        //Spring Boot validation -> @Valid -> to trigger validation ;
        //BindingResult interface -> to catch validation errors
        //@ModelAttribute -> to bind form data to a model object.

        if(result.hasErrors())
            return "add-product-form";
        ProductDto storedProduct = productServices.addProduct(clonedNewProduct);
        model.addAttribute("storedProduct",clonedNewProduct);

        return "add-product-submission";
//        return "redirect:/product-catalog";
    }
    @GetMapping("/display-all-products")
    public String handlerMethodForGetAllProducts(@RequestParam(value = "category", required = false) String givenSpecificCategory, Model model) {

        List<ProductDto> productsList = new ArrayList<>();
        List<String> uniqueCategoriesList = new ArrayList<>();
        boolean isError = false;

        //To display in drop down search box to select specific category
        uniqueCategoriesList = productServices.getAllCategoryNames();

        // Retrieve products based on the presence of the category filter
        if (givenSpecificCategory == null || givenSpecificCategory.trim().isEmpty()) {
            productsList = (productServices.getAllProductsOrderByCategory());
        } else {
            productsList = productServices.getAllProductsOfSpecificCategory(givenSpecificCategory);
            isError = productsList.isEmpty();
        }

        model.addAttribute("categoriesList", uniqueCategoriesList);
        model.addAttribute("productsList", productsList);
        model.addAttribute("customError", isError);

        return "display-all-products";
    }


}