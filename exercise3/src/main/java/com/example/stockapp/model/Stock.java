package com.example.stockapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("stocks")

public class Stock {
    @Id
    private Long id;
    private String name;
    private BigDecimal currentPrice;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
}
