package com.MatrixCampusSL.demo.controller;

import com.MatrixCampusSL.demo.model.Price;
import com.MatrixCampusSL.demo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private static final Logger log = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<?> getPrices(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam("productId") Integer productId,
            @RequestParam("brandId") Integer brandId) {

        log.info("Received request - Date: {}, ProductID: {}, BrandID: {}", date, productId, brandId);

        List<Price> prices = priceService.findApplicablePrices(date, productId, brandId);
        log.info("Found {} applicable prices", prices.size());

        if (prices.isEmpty()) {
            log.warn("No prices found for the given parameters.");
            return ResponseEntity.notFound().build();
        }

        Price bestPrice = prices.stream()
                                .max(Comparator.comparingInt(Price::getPriority))
                                .orElseThrow();

        log.info("Best price details: {}", bestPrice);

        var result = new Object() {
            public final Integer productId = bestPrice.getProductId();
            public final Integer brandId = bestPrice.getBrandId();
            public final Integer priceList = bestPrice.getPriceList();
            public final LocalDateTime startDate = bestPrice.getStartDate();
            public final LocalDateTime endDate = bestPrice.getEndDate();
            public final BigDecimal finalPrice = bestPrice.getPrice();
        };

        return ResponseEntity.ok(result);
    }
}