package org.kbotsk.product.Mapper;

import org.kbotsk.product.Dto.ProductRequestDto;
import org.kbotsk.product.Dto.ProductResponseDto;
import org.kbotsk.product.Entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
   Product toEntity(ProductRequestDto request);
   ProductResponseDto toResponse(Product product);
}
