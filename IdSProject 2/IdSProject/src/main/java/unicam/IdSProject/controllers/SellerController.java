package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping(value = "/addProducerProduct")
    public ResponseEntity<Object> addProducerProduct(@RequestBody ProducerProductCreationDTO product){
        return sellerService.addProducerProduct(product);
    }

    // -- TRANSFORMER --
    /**
    * This method implements the feature for a Seller with tag Transformer to add a Product and sets a route for it
    */
    @RequestMapping(value = "/addTransformerProduct")
    public ResponseEntity<Object> addTransformerProduct(@RequestBody TransformerProductCreationDTO product){
        return sellerService.addTransformerProduct(product);
    }

    /**
    * This method implements the method for removing a Product made by the Seller from the marketplace and sets a route for it
    */
    @RequestMapping(value = "/removeProduct")
    public ResponseEntity<Object> removeProduct(@PathParam("id") Long id) {
        return sellerService.removeProduct(id);
    }



}
