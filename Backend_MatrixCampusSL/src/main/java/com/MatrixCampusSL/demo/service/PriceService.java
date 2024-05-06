package com.MatrixCampusSL.demo.service;

import com.MatrixCampusSL.demo.model.Price;
import com.MatrixCampusSL.demo.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    /**
     * Finds the most applicable price based on the product ID, brand ID, and application date.
     * This method assumes that the prices returned by the repository are already sorted by priority and start date.
     *
     * @param applicationDate the date when the price needs to be applied
     * @param productId the product identifier
     * @param brandId the brand identifier
     * @return an optional containing the most applicable price or empty if no price is found
     */
    public Optional<Price> findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        List<Price> prices = priceRepository.findApplicablePrices(productId, brandId, applicationDate);
        return prices.stream().findFirst();
    }
}
