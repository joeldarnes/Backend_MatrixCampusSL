package com.MatrixCampusSL.demo.service;

import com.MatrixCampusSL.demo.model.Price;
import com.MatrixCampusSL.demo.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public List<Price> findApplicablePrices(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productId, brandId, applicationDate, applicationDate)
                .stream()
                .sorted((p1, p2) -> p2.getPriority().compareTo(p1.getPriority()))
                .collect(Collectors.toList());
    }
}
