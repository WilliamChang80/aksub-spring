package com.training.spring.repository;

import com.training.spring.entity.Product;
import com.training.spring.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsByProduct(Product product);

}
