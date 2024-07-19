package com.example.stockapp.service;


import com.example.stockapp.model.Stock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface StockService {
    Flux<Stock> getAllStocks();

    Mono<Stock> getStockById(Long id);

    Mono<Stock> createStock(Stock stock);

    Mono<Stock> updateStockPrice(Long id, BigDecimal newPrice);
}
