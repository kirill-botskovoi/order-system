package org.kbotsk.product.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.kbotsk.product.Dto.ProductRequestDto;
import org.kbotsk.product.Dto.ProductResponseDto;
import org.kbotsk.product.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Product", description = "Operations with products")
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "Get all products")
    @GetMapping
    public List<ProductResponseDto> getAll() {
        return productService.getAll();
    }

    @Operation(summary = "Get specific product by its ID")
    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @Operation(summary = "Create a new product")
    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductRequestDto dto) {
        ProductResponseDto created = productService.create(dto);
        return ResponseEntity.ok(created);
    }

    @Operation(summary = "Update product")
    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id, @RequestBody ProductRequestDto dto) {
        return productService.update(id, dto);
    }

    @Operation(summary = "Delete product by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
