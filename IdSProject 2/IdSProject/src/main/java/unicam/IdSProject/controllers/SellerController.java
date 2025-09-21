package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.enumerations.Tag;
import unicam.IdSProject.models.*;
import unicam.IdSProject.repositories.ProductBoard;
import unicam.IdSProject.repositories.RequestHandler;

/**
*
* This class implements the methods of a Seller used to interact with the marketplace
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*/

@Controller
public class SellerController {

    @Autowired
    private RequestHandler requestHandler;
    @Autowired
    private ProductBoard productBoard;

    private final Seller seller;

    /**
    * This method creates a new SellerController object
    */
    public SellerController(Seller seller){
        this.seller = seller;
    }


    // -- PRODUCER --
    /**
    * This method implements the feature for a Seller with tag Producer to add a Product and sets a route for it
    */
    @RequestMapping(value = "/producer/addProduct")
    public ResponseEntity<Object> addProducerProduct(@RequestBody ProducerProduct product){
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

    // -- TRANSFORMER --
    /**
    * This method implements the feature for a Seller with tag Transformer to add a Product and sets a route for it
    */
    @RequestMapping(value = "/transformer/addProduct")
    public ResponseEntity<Object> addTransformerProduct(@RequestBody TransformerProduct product){
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

    /**
    * This method implements the method for removing a Product made by the Seller from the marketplace and sets a route for it
    */
    @RequestMapping(value = "/removeProduct")
    public ResponseEntity<Object> removeProduct(@PathParam("id") int id) {
        if (productBoard.removeProduct(id)){
            return new ResponseEntity<>("Prodotto rimosso con successo", HttpStatus.OK);
        }
        return new ResponseEntity<>("Id non pervenuto", HttpStatus.NOT_FOUND);

    }



}
