package org.kbotsk.order.kafka;

import lombok.RequiredArgsConstructor;
import org.kbotsk.order.Event.OrderPlacedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendOrderPlacedEvent(OrderPlacedEvent event) {
        kafkaTemplate.send("order-placed", event);
        System.out.println("📤 Отправлено событие OrderPlaced: " + event);
    }
}