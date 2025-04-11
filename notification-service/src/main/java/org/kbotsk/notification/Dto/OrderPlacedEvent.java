package org.kbotsk.notification.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderPlacedEvent {
    private Long id;
    private String orderNumber;
}
