package org.kbotsk.product.Service;

import lombok.RequiredArgsConstructor;
import org.kbotsk.product.Dto.ProductCreatedEvent;
import org.kbotsk.product.Entity.Product;
import org.kbotsk.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductEventPublisher eventPublisher;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product create(Product product) {
        eventPublisher.sendProductCreatedEvent(
                new ProductCreatedEvent(product.getId(), product.getName(), product.getPrice())
        );
        return productRepository.save(product);
    }

    public Product update(Long id, Product updated) {
        Product existing = getById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());
        return productRepository.save(existing);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
