package org.kbotsk.order.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.kbotsk.order.Entity.OrderLineItem;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id") // Foreign key in order_line_items
    private List<OrderLineItem> items;
}