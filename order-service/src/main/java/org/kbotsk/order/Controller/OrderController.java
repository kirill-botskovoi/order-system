package org.kbotsk.order.Controller;

import lombok.RequiredArgsConstructor;
import org.kbotsk.order.Dto.OrderRequestDto;
import org.kbotsk.order.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequestDto request) {
        orderService.placeOrder(request);
        return ResponseEntity.ok("✅ Заказ успешно создан");
    }
}
