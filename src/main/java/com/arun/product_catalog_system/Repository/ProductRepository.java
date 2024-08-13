package com.arun.product_catalog_system.Repository;

import com.arun.product_catalog_system.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

//No need to mention @Repository as CrudRepository implements SimplePJARepository,which has @Repository annotations in it
public interface ProductRepository extends JpaRepository<Product,Long> {

//-------- Finds all distinct product categories names -----------------
    @Query(value = "SELECT DISTINCT Lower(p.productCategory) FROM Product p ORDER BY LOWER(p.productCategory) ASC")
    List<String> findAllProductCategoryNamesAsc();

// ------- Finds all products ordered by category in a case-insensitive manner---------
    @Query(value = "SELECT * FROM products ORDER BY Lower(product_category) ",nativeQuery = true)
    List<Product> findAllByOrderedByProductCategoryIgnoreCaseAsc();


//-------- Finds all products in a specific category, ordered by category in a case-insensitive manner ------
    @Query(value = "SELECT * FROM products WHERE Lower(product_category) = Lower(?1) " +
                   "ORDER BY Lower(product_category)",nativeQuery = true)
    List<Product> findAllBySpecificProductCategoryIgnoreCase(String specificCategory);


//-------- Finds a product by name in a case-insensitive manner-----------------
    Optional<Product> findByProductNameIgnoreCase(String productName);



}
