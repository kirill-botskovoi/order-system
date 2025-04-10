package org.kbotsk.notification.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.kbotsk.notification.Service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductEventsListener {

    private final NotificationService notificationService;

    public ProductEventsListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "product-created", groupId = "notification-group")
    public void onProductCreated(String messageJson) {
        log.info("📥 Получено событие из Kafka: {}", messageJson);

        // Здесь позже будет парсинг JSON в объект и вызов NotificationService
        // Например: objectMapper.readValue(messageJson, ProductCreatedEvent.class);
    }
}
