package unicam.IdSProject.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import unicam.IdSProject.dtos.requests.ProducerProductCreationDTO;
import unicam.IdSProject.dtos.requests.TransformerProductCreationDTO;
import unicam.IdSProject.dtos.response.ProducerProductDTO;
import unicam.IdSProject.dtos.response.TransformerProductDTO;
import unicam.IdSProject.models.ProducerProduct;
import unicam.IdSProject.models.TransformerProduct;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-29T16:32:37+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProducerProduct toEntityWithAllFields(ProducerProductCreationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProducerProduct producerProduct = new ProducerProduct();

        producerProduct.setName( dto.getName() );
        producerProduct.setPrice( dto.getPrice() );
        producerProduct.setDescription( dto.getDescription() );
        producerProduct.setStockNumber( dto.getStockNumber() );

        return producerProduct;
    }

    @Override
    public ProducerProductDTO toDtoWithAllFields(ProducerProduct product) {
        if ( product == null ) {
            return null;
        }

        ProducerProductDTO producerProductDTO = new ProducerProductDTO();

        producerProductDTO.setName( product.getName() );
        producerProductDTO.setPrice( product.getPrice() );
        producerProductDTO.setDescription( product.getDescription() );
        producerProductDTO.setDistributorDescription( product.getDistributorDescription() );
        producerProductDTO.setStockNumber( product.getStockNumber() );
        producerProductDTO.setCreator( product.getCreator() );

        return producerProductDTO;
    }

    @Override
    public TransformerProduct toEntityWithAllFields(TransformerProductCreationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TransformerProduct transformerProduct = new TransformerProduct();

        transformerProduct.setName( dto.getName() );
        transformerProduct.setPrice( dto.getPrice() );
        transformerProduct.setDescription( dto.getDescription() );
        transformerProduct.setStockNumber( dto.getStockNumber() );
        transformerProduct.setSourceProduct( dto.getSourceProduct() );

        return transformerProduct;
    }

    @Override
    public TransformerProductDTO toDtoWithAllFields(TransformerProduct product) {
        if ( product == null ) {
            return null;
        }

        TransformerProductDTO transformerProductDTO = new TransformerProductDTO();

        transformerProductDTO.setName( product.getName() );
        transformerProductDTO.setPrice( product.getPrice() );
        transformerProductDTO.setDescription( product.getDescription() );
        transformerProductDTO.setDistributorDescription( product.getDistributorDescription() );
        transformerProductDTO.setStockNumber( product.getStockNumber() );
        transformerProductDTO.setCreator( product.getCreator() );
        transformerProductDTO.setSourceProduct( product.getSourceProduct() );

        return transformerProductDTO;
    }
}
