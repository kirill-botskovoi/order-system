package org.kbotsk.order.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_line_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private int quantity;
    private double price;
}
