package org.kbotsk.order.Dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    private List<OrderLineItemDto> items;
}
