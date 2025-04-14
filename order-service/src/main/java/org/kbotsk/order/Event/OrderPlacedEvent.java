package org.kbotsk.order.Event;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderPlacedEvent {
    private Long id;
    private String orderNumber;
}