package org.kbotsk.order.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kbotsk.order.Event.OrderPlacedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendOrderPlacedEvent(OrderPlacedEvent event) {
        log.info("📤 Отправлено событие OrderPlaced: " + event);
        kafkaTemplate.send("order-placed", event);
    }
}