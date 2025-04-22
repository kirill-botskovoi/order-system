package org.kbotsk.product.Service;

import lombok.RequiredArgsConstructor;
import org.kbotsk.product.Dto.ProductCreatedEventDto;
import org.kbotsk.product.Dto.ProductRequestDto;
import org.kbotsk.product.Dto.ProductResponseDto;
import org.kbotsk.product.Entity.Product;
import org.kbotsk.product.Mapper.ProductMapper;
import org.kbotsk.product.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductEventPublisher productEventPublisher;

    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream()
              .map(productMapper::toResponse)
              .collect(Collectors.toList());
    }

    public ProductResponseDto getById(Long id) {
        Product product = productRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toResponse(product);
    }

    public ProductResponseDto create(ProductRequestDto dto) {
        Product entity = productMapper.toEntity(dto);
        Product saved = productRepository.save(entity);

        productEventPublisher.sendProductCreatedEvent(
              ProductCreatedEventDto.builder()
                    .id(saved.getId())
                    .name(saved.getName())
                    .description(saved.getDescription())
                    .price(saved.getPrice())
                    .quantity(saved.getQuantity())
                    .build()
        );

        return productMapper.toResponse(saved);
    }

    public ProductResponseDto update(Long id, ProductRequestDto dto) {
        Product existing = productRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setPrice(dto.getPrice());
        existing.setQuantity(dto.getQuantity());
        Product updated = productRepository.save(existing);
        return productMapper.toResponse(updated);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
