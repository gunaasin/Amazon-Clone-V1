package com.clone.amazon.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p " +
            "WHERE LOWER(p.category.brand) LIKE LOWER(CONCAT('%', :brand, '%')) " +
            "AND LOWER(p.category.categoryName) LIKE LOWER(CONCAT('%', :categoryName, '%'))")
    List<Product> getProductBasedOnBrandAndCategory(@Param("brand") String brand,
                                                    @Param("categoryName") String categoryName);


    @Query(
            "SELECT p FROM Product p WHERE" +
            " LOWER(p.keywords) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "AND LOWER(p.category.categoryName) LIKE LOWER(CONCAT('%', :categoryName, '%'))")
    List<Product> getProductBasedOnKeyWordAndCategory(@Param("keyword") String keyword,
                                                      @Param("categoryName") String categoryName);

    @Query(
            "SELECT p FROM Product p WHERE" +
            " LOWER(p.keywords) LIKE LOWER(CONCAT('%', :keyOne, '%'))" +
            " OR LOWER(p.keywords) LIKE LOWER(CONCAT('%', :keyTwo, '%'))")
    List<Product> getProductBasedOnKeyWordAndKeyWord(@Param("keyOne") String keyOne,
                                                     @Param("keyTwo") String keyTwo);

    @Query(

            "SELECT p FROM Product p " +
            "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) "+
            "OR LOWER(p.keywords) LIKE LOWER(CONCAT('%', :keyword, '%'))"+
            "OR LOWER(p.category.categoryName) LIKE LOWER(CONCAT('%', :keyword, '%'))"
     )
    List<Product> searchProducts(String keyword);

    @Query(
            "SELECT p FROM Product p WHERE" +
            " LOWER(p.category.brand) LIKE LOWER(CONCAT('%', :brand, '%')) " +
            "AND LOWER(p.category.categoryName) LIKE LOWER(CONCAT('%', :categoryName, '%'))")
    List<Product> relatedProducts(@Param("categoryName") String categoryName ,@Param("brand") String brand );



}
