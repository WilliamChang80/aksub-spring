package com.training.spring.repository;

import com.training.spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT *\n" +
            "FROM products\n" +
            "WHERE id = ?1", nativeQuery = true)
    Product getProductById(Long id);

    @Query(value = "SELECT avg(price)\n" +
            "FROM products", nativeQuery = true)
    Long getProductAveragePrice();

    @Query(value = "SELECT count(id)\n" +
            "FROM products", nativeQuery = true)
    Long getNumberOfProducts();

    @Query(value = "SELECT MAX(price)\n" +
            "FROM products", nativeQuery = true)
    Long getMaxProductPrice();
}
