package org.kbotsk.product.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
   private Long id;
   private String name;
   private String description;
   private double price;
   private int quantity;
}