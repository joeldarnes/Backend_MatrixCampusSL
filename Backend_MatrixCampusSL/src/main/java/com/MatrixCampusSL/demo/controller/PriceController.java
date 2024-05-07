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

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<?> getPrices(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam("productId") Integer productId,
            @RequestParam("brandId") Integer brandId) {

        List<Price> prices = priceService.findApplicablePrices(date, productId, brandId);

        if (prices.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Assumption: prices are sorted by priority in the service
        Price bestPrice = prices.stream()
                                .max(Comparator.comparingInt(Price::getPriority))
                                .orElseThrow();

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