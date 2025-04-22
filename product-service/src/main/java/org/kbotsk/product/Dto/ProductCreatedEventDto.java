package org.kbotsk.product.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreatedEventDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
}
