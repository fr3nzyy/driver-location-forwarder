package com.alekseyzhukov.driverlocationforwarder.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Coordinates {
    private Integer driverId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDateTime time;
}
