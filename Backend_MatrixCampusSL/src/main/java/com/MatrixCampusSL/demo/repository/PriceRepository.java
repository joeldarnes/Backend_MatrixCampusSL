package com.MatrixCampusSL.demo.repository;

import com.MatrixCampusSL.demo.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    // Query to find the applicable price based on product ID, brand ID, and application date
    @Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId " +
           "AND p.startDate <= :applicationDate AND p.endDate >= :applicationDate " +
           "ORDER BY p.priority DESC, p.startDate DESC")
    List<Price> findApplicablePrices(Integer productId, Integer brandId, LocalDateTime applicationDate);
}
