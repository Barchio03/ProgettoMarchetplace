package unicam.IdSProject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.models.*;
import unicam.IdSProject.repositories.EventBoard;
import unicam.IdSProject.repositories.ProductBoard;
import unicam.IdSProject.repositories.RequestHandler;
import unicam.IdSProject.services.MarketService;
import unicam.IdSProject.users.Animator;
import unicam.IdSProject.users.Buyer;
import unicam.IdSProject.users.PlatformHandler;
import unicam.IdSProject.users.Seller;


/**
*
* This class implements the methods and the features of the marketplace
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
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
