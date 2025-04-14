package org.kbotsk.order.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.kbotsk.order.Dto.OrderRequestDto;
import org.kbotsk.order.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "Order", description = "Operations with orders")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Create a new order")
    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequestDto request) {
        orderService.placeOrder(request);
        return ResponseEntity.ok("✅ Заказ успешно создан");
    }
}
