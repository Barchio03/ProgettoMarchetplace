package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.ProducerProductDTO;
import unicam.IdSProject.dtos.ProductDTO;
import unicam.IdSProject.dtos.TransformerProductDTO;
import unicam.IdSProject.models.ProducerProduct;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.models.TransformerProduct;

@Mapper(componentModel = "spring")
public interface ProductMapper {
     Product toEntityWithAllFields(ProductDTO dto);
     ProductDTO toDtoWithAllFields(Product product);

     ProducerProduct toEntityWithAllFields(ProducerProductDTO dto);
     ProducerProductDTO toDtoWithAllFields(ProducerProduct product);

     TransformerProduct toEntityWithAllFields(TransformerProductDTO dto);
     TransformerProductDTO toDtoWithAllFields(TransformerProduct product);
}
