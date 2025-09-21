package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import unicam.IdSProject.dtos.EventDTO;
import unicam.IdSProject.dtos.ProductDTO;
import unicam.IdSProject.models.*;
import unicam.IdSProject.repositories.EventBoard;
import unicam.IdSProject.repositories.ProductBoard;
import unicam.IdSProject.services.BuyerService;

/**
*
* This class implements the methods for handling all the Buyer interaction with the marketplace
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/

@Controller
@RequiredArgsConstructor
public class BuyerController {

    private final ProductBoard productBoard;
    private final EventBoard eventboard;

    private final BuyerService buyerService;


    /**
     * This method adds a Product to the Shopping Cart.
     *
     * @param productDto, the Product that needs to be added.
     * @return the response of the moethod
     */
    @PostMapping(value = "/addToShoppingKart")
    public ResponseEntity<Object> addToShoppingCart(@RequestBody ProductDTO productDto, @PathParam("quantity") int quantity) {
        return buyerService.addProductToShoppingKart(productDto, quantity);
    }

    /**
     * This method is used to buy all the Products in the Shopping Cart.
     *
     * @return true  if the purchase was successfull, false otherwise
     */
    public ResponseEntity<Object> buyShoppingCart() {
        return buyerService.buyShoppingCart();
    }

    /**
     * This method allows to buy an Event tickey
     *
     * @param eventDto, the Event from which buying the ticket
     *
     * @return true if the purchase was successfull, false otherwise
     */
    public ResponseEntity<Object> subscribeToEvent(EventDTO eventDto) {
        return buyerService.subscribeToEvent(eventDto);
    }

    public ResponseEntity<Object> unsubscribeToEvent(EventDTO eventDto) {
        return buyerService.unsubscribeToEvent(eventDto);
    }
}


