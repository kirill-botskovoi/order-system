package org.kbotsk.product.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kbotsk.product.Dto.ProductCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendProductCreatedEvent(ProductCreatedEvent event) {
        log.info("📤 Отправка события в Kafka: {}", event);
        kafkaTemplate.send("product-created", event);
    }
}