package org.kbotsk.notification.Service;

import lombok.extern.slf4j.Slf4j;
import org.kbotsk.notification.Dto.ProductCreatedEvent;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    public void sendProductCreatedNotification(ProductCreatedEvent event) {
        log.info("🔔 Новый продукт создан: {} — цена: {}", event.getName(), event.getPrice());
    }
}
