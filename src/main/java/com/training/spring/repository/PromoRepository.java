package com.training.spring.repository;

import com.training.spring.entity.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Long> {

    Promo findPromoByCode(String code);
}
