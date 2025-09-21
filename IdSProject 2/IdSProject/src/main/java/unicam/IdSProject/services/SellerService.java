package unicam.IdSProject.services;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import unicam.IdSProject.dtos.ProducerProductDTO;
import unicam.IdSProject.dtos.TransformerProductDTO;
import unicam.IdSProject.enumerations.Tag;
import unicam.IdSProject.mappers.ProductMapper;
import unicam.IdSProject.models.ProducerProduct;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.models.TransformerProduct;
import unicam.IdSProject.repositories.ProductBoard;
import unicam.IdSProject.repositories.RequestHandler;
import unicam.IdSProject.users.Seller;


@Service
@RequiredArgsConstructor
public class SellerService {

    private final ProductMapper productMapper;

    private final RequestHandler requestHandler;

    private final ProductBoard productBoard;

    private final Seller seller;


    public ResponseEntity<Object> addProducerProduct(@RequestBody ProducerProductDTO productDTO){
        ProducerProduct product = productMapper.toEntityWithAllFields(productDTO);

        if (seller.getTags().contains(Tag.PRODUCER)) {
            product.setCreator(seller);
            if(!productBoard.contains(product)){
                if (requestHandler.addProduct(product))
                    return new ResponseEntity<>("Prodotto in processo di verifica", HttpStatus.CREATED);
                else return new ResponseEntity<>("Richiesta già in atto", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Il prodotto è già presente", HttpStatus.BAD_REQUEST);
        } else return new ResponseEntity<>("Non autorizzato", HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<Object> addTransformerProduct(@RequestBody TransformerProductDTO productDTO){
        TransformerProduct product = productMapper.toEntityWithAllFields(productDTO);

        if (seller.getTags().contains(Tag.TRANSFORMER)) {
            product.setCreator(seller);
            if(!productBoard.contains(product)){
                if (requestHandler.addProduct(product))
                    return new ResponseEntity<>("Prodotto in processo di verifica", HttpStatus.CREATED);
                else return new ResponseEntity<>("Richiesta già in atto", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Il prodotto è già presente", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Non autorizzato", HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<Object> removeProduct(@PathParam("id") int id) {
        if (productBoard.removeProduct(id)){
            return new ResponseEntity<>("Prodotto rimosso con successo", HttpStatus.OK);
        }
        return new ResponseEntity<>("Id non pervenuto", HttpStatus.NOT_FOUND);

    }

}
