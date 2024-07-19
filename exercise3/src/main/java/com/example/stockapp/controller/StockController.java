package com.example.stockapp.controller;


import com.example.demo.dto.UpdatePriceRequest;
import com.example.stockapp.model.Stock;
import com.example.stockapp.service.StockService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public Flux<Stock> getAllStocks() {

        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Mono<Stock> getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PostMapping
    public Mono<Stock> createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    @PutMapping("/{id}")
    public Mono<Stock> updateStockPrice(@PathVariable Long id, @RequestBody UpdatePriceRequest request) {
        return stockService.updateStockPrice(id, request.getNewPrice());
    }
}
