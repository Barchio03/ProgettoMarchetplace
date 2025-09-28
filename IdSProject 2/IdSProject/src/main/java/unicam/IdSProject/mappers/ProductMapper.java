package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.requests.*;
import unicam.IdSProject.dtos.response.ProducerProductDTO;
import unicam.IdSProject.dtos.response.ProductDTO;
import unicam.IdSProject.dtos.response.TransformerProductDTO;
import unicam.IdSProject.models.ProducerProduct;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.models.TransformerProduct;

@Mapper(componentModel = "spring")
public interface ProductMapper {

     ProducerProduct toEntityWithAllFields(ProducerProductCreationDTO dto);
//     ProducerProduct toEntityWithAllFields(ProducerProductBoughtDTO dto);
     ProducerProductDTO toDtoWithAllFields(ProducerProduct product);

     TransformerProduct toEntityWithAllFields(TransformerProductCreationDTO dto);
//     TransformerProduct toEntityWithAllFields(TransformerProductBoughtDTO dto);
     TransformerProductDTO toDtoWithAllFields(TransformerProduct product);

}
