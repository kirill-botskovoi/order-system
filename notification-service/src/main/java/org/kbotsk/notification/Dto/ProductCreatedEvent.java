package org.kbotsk.notification.Dto;

import lombok.Data;

@Data
public class ProductCreatedEvent {
    private Long id;
    private String name;
    private double price;
}
