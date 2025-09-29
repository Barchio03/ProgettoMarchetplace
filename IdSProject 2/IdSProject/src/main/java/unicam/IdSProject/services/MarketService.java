package unicam.IdSProject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unicam.IdSProject.dtos.response.ProductDTO;
import unicam.IdSProject.mappers.EventMapper;
import unicam.IdSProject.mappers.ProductMapper;
import unicam.IdSProject.models.ProducerProduct;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.models.TransformerProduct;
import unicam.IdSProject.repositories.EventBoard;
import unicam.IdSProject.repositories.ProductBoard;

@Service
@RequiredArgsConstructor
public class MarketService {

    private final ProductMapper productMapper;

    private final EventMapper eventMapper;

    private final ProductBoard productBoard;

    private final EventBoard eventBoard;

    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productBoard.getProducts().stream().map(
                this::toDTO
        ).toList(), HttpStatus.OK);
    }

    public ResponseEntity<Object> getEvents(){
        return new ResponseEntity<>(eventBoard.getEvents().stream().map(
                eventMapper::toDtoWithAllFields
        ).toList(), HttpStatus.OK);
    }

    private ProductDTO toDTO(Product product) {
        if (product instanceof ProducerProduct){
            return productMapper.toDtoWithAllFields((ProducerProduct) product);
        }
        else{
            return productMapper.toDtoWithAllFields((TransformerProduct) product);
        }
    }

}
