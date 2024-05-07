package com.MatrixCampusSL.demo.repository;

import com.MatrixCampusSL.demo.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
        Integer productId, Integer brandId, LocalDateTime startDate, LocalDateTime endDate);
}