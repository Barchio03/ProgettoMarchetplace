package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.requests.ProducerProductCreationDTO;
import unicam.IdSProject.dtos.requests.ProductBoughtDTO;
import unicam.IdSProject.dtos.response.ProducerProductDTO;
import unicam.IdSProject.dtos.requests.TransformerProductCreationDTO;
import unicam.IdSProject.dtos.response.ProductDTO;
import unicam.IdSProject.dtos.response.TransformerProductDTO;
import unicam.IdSProject.models.ProducerProduct;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.models.TransformerProduct;

@Mapper(componentModel = "spring")
public interface ProductMapper {
     ProductDTO toDtoWithAllFields(Product product);

     Product toEntityWithAllFields(ProductBoughtDTO dto);

     ProducerProduct toEntityWithAllFields(ProducerProductCreationDTO dto);
     ProducerProductDTO toDtoWithAllFields(ProducerProduct product);

     TransformerProduct toEntityWithAllFields(TransformerProductCreationDTO dto);
     TransformerProductDTO toDtoWithAllFields(TransformerProduct product);
}
