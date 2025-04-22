package org.kbotsk.notification.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.kbotsk.notification.Dto.OrderPlacedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderEventListener {

    @KafkaListener(
            topics = "order-placed",
            groupId = "notification-group",
            containerFactory = "orderEventsFactory"
    )
    public void handleOrderPlaced(OrderPlacedEvent event) {
        log.info("📩 Получено событие из Kafka: {}", event);
        // Здесь можно, например, отправить email, сохранить лог, уведомить кого-то и т.д.
    }
}