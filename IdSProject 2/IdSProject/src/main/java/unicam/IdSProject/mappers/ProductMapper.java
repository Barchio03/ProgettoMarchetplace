package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.ProductDTO;
import unicam.IdSProject.models.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
     Product toEntityWithAllFields(ProductDTO dto);
     ProductDTO toDtoWithAllFields(Product product);
}
