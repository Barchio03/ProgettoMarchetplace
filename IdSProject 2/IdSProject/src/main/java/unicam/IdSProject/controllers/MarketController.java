package unicam.IdSProject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.services.MarketService;


/**
*
* This class implements the methods and the features of the marketplace
*
* @author Erika Aguiari, Luca Barchiesi
*/
@Controller
@RequiredArgsConstructor
public class MarketController {

    private final MarketService marketService;

    // -- MARKET --
    /**
    * This method return the products from the product board and sets a route to it
    */
    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProducts(){
        return marketService.getProducts();
    }

    @RequestMapping(value="/events")
    public ResponseEntity<Object> getEvents(){
        return marketService.getEvents();
    }

}
