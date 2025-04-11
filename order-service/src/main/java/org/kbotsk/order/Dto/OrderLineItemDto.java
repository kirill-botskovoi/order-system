package org.kbotsk.order.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemDto {
    private Long productId;
    private int quantity;
    private double price;
}
