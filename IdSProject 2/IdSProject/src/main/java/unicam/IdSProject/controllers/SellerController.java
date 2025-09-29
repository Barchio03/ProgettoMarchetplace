package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import unicam.IdSProject.dtos.requests.ProducerProductCreationDTO;
import unicam.IdSProject.dtos.requests.TransformerProductCreationDTO;
import unicam.IdSProject.services.SellerService;

/**
*
* This class implements the methods of a Seller used to interact with the marketplace
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*/
@Controller
@RequiredArgsConstructor
@RequestMapping(value="/seller")
public class SellerController {

    private final SellerService sellerService;

    // -- PRODUCER --
    /**
    * This method implements the feature for a Seller with tag Producer to add a Product and sets a route for it
    */
    @PostMapping(value = "/addProducerProduct")
    public ResponseEntity<Object> addProducerProduct(@RequestBody ProducerProductCreationDTO product){
        return sellerService.addProducerProduct(product);
    }

    // -- TRANSFORMER --
    /**
    * This method implements the feature for a Seller with tag Transformer to add a Product and sets a route for it
    */
    @PostMapping(value = "/addTransformerProduct")
    public ResponseEntity<Object> addTransformerProduct(@RequestBody TransformerProductCreationDTO product){
        return sellerService.addTransformerProduct(product);
    }

    /**
    * This method implements the method for removing a Product made by the Seller from the marketplace and sets a route for it
    */
    @DeleteMapping(value = "/removeProduct")
    public ResponseEntity<Object> removeProduct(@PathParam("id") Long id) {
        return sellerService.removeProduct(id);
    }

    /**
     * This method implements the feature for a Seller to enable permissions for a Producer
     */
    @PutMapping(value = "/addProducerTag")
    public ResponseEntity<Object> addProducerTag(){
        return sellerService.addProducerTag();
    }

    /**
     * This method implements the feature for a Seller to enable permissions for a Transformer
     */
    @PutMapping(value = "/addTransformerTag")
    public ResponseEntity<Object> addTransformerTag(){
        return sellerService.addTransformerTag();
    }

    @GetMapping(value = "/mailbox")
    public ResponseEntity<Object> openMailbox() {
        return sellerService.openMailbox();
    }
}
