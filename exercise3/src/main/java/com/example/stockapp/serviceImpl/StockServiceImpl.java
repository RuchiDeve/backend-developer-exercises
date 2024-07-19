package com.example.stockapp.serviceImpl;

import com.example.stockapp.model.Stock;
import com.example.stockapp.repository.StockRepository;
import com.example.stockapp.service.StockService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Flux<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Mono<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public Mono<Stock> createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Mono<Stock> updateStockPrice(Long id, BigDecimal newPrice) {
        return stockRepository.findById(id)
                .flatMap(stock -> {
                    stock.setCurrentPrice(newPrice);
                    stock.setLastUpdate(LocalDateTime.now());
                    return stockRepository.save(stock);
                });
    }
}
