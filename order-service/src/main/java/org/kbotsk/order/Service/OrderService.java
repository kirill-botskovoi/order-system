package org.kbotsk.order.Service;

import lombok.RequiredArgsConstructor;
import org.kbotsk.order.Dto.OrderRequestDto;
import org.kbotsk.order.Entity.Order;
import org.kbotsk.order.Entity.OrderLineItem;
import org.kbotsk.order.Event.OrderPlacedEvent;
import org.kbotsk.order.Repository.OrderRepository;
import org.kbotsk.order.kafka.OrderEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventPublisher eventPublisher;

    public void placeOrder(OrderRequestDto request) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> items = request.getItems().stream()
                .map(dto -> OrderLineItem.builder()
                        .productId(dto.getProductId())
                        .quantity(dto.getQuantity())
                        .price(dto.getPrice()) // позже заменим на fetch из product-service
                        .build())
                .toList();

        order.setItems(items);
        Order saved = orderRepository.save(order);

        OrderPlacedEvent event = new OrderPlacedEvent(saved.getId(), saved.getOrderNumber());
        eventPublisher.sendOrderPlacedEvent(event);
    }
}
