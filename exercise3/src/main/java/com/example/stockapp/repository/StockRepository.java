package com.example.stockapp.repository;

import com.example.stockapp.model.Stock;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StockRepository {
    private final Map<Long, Stock> stockStore = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public StockRepository() {
        save(new Stock(null, "Apple", new BigDecimal("150.00"), LocalDateTime.now(), LocalDateTime.now()));
        save(new Stock(null, "Google", new BigDecimal("2800.00"), LocalDateTime.now(), LocalDateTime.now()));
    }

    public Flux<Stock> findAll() {
        return Flux.fromIterable(stockStore.values());
    }

    public Mono<Stock> findById(Long id) {
        return Mono.justOrEmpty(stockStore.get(id));
    }

    public Mono<Stock> save(Stock stock) {
        if (stock.getId() == null) {
            stock.setId(counter.incrementAndGet());
            stock.setCreateDate(LocalDateTime.now());
        }
        stock.setLastUpdate(LocalDateTime.now());
        stockStore.put(stock.getId(), stock);
        return Mono.just(stock);
    }

    public Mono<Stock> updatePrice(Long id, BigDecimal newPrice) {
        Stock stock = stockStore.get(id);
        if (stock != null) {
            stock.setCurrentPrice(newPrice);
            stock.setLastUpdate(LocalDateTime.now());
            stockStore.put(id, stock);
            return Mono.just(stock);
        }
        return Mono.empty();
    }
}