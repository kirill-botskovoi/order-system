package org.kbotsk.product.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreatedEvent {
    private Long id;
    private String name;
    private double price;
}
