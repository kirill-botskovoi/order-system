package org.kbotsk.order.Service;

import lombok.RequiredArgsConstructor;
import org.kbotsk.order.Dto.OrderRequestDto;
import org.kbotsk.order.Entity.Order;
import org.kbotsk.order.Entity.OrderLineItem;
import org.kbotsk.order.Event.OrderPlacedEvent;
import org.kbotsk.order.Repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequestDto request) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> items = request.getItems().stream().map(dto ->
                OrderLineItem.builder()
                        .productId(dto.getProductId())
                        .quantity(dto.getQuantity())
                        .price(dto.getPrice())
                        .build()
        ).toList();

        order.setItems(items);
        Order saved = orderRepository.save(order);

        kafkaTemplate.send("order-placed", new OrderPlacedEvent(saved.getId(), saved.getOrderNumber()));
        System.out.println("📤 Заказ отправлен в Kafka: " + saved.getOrderNumber());
    }
}
