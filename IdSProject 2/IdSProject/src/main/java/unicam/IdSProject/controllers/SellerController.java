package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.dtos.ProducerProductDTO;
import unicam.IdSProject.dtos.TransformerProductDTO;
import unicam.IdSProject.enumerations.Tag;
import unicam.IdSProject.models.*;
import unicam.IdSProject.repositories.ProductBoard;
import unicam.IdSProject.repositories.RequestHandler;
import unicam.IdSProject.services.SellerService;
import unicam.IdSProject.users.Seller;

/**
*
* This class implements the methods of a Seller used to interact with the marketplace
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*/

@Controller
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    // -- PRODUCER --
    /**
    * This method implements the feature for a Seller with tag Producer to add a Product and sets a route for it
    */
    @RequestMapping(value = "/producer/addProduct")
    public ResponseEntity<Object> addProducerProduct(@RequestBody ProducerProductDTO product){
        return sellerService.addProducerProduct(product);
    }

    // -- TRANSFORMER --
    /**
    * This method implements the feature for a Seller with tag Transformer to add a Product and sets a route for it
    */
    @RequestMapping(value = "/transformer/addProduct")
    public ResponseEntity<Object> addTransformerProduct(@RequestBody TransformerProductDTO product){
        return sellerService.addTransformerProduct(product);
    }

    /**
    * This method implements the method for removing a Product made by the Seller from the marketplace and sets a route for it
    */
    @RequestMapping(value = "/removeProduct")
    public ResponseEntity<Object> removeProduct(@PathParam("id") int id) {
        return sellerService.removeProduct(id);
    }



}
