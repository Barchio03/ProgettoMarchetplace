package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.dtos.requests.EventBoughtDTO;
import unicam.IdSProject.dtos.requests.ProductBoughtDTO;
import unicam.IdSProject.services.BuyerService;

/**
*
* This class implements the methods for handling all the Buyer interaction with the marketplace
*
* @author Erika Aguiari, Luca Barchiesi
*
*/
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/buyer")
public class BuyerController {

    private final BuyerService buyerService;


    /**
     * This method adds a Product to the Shopping Cart.
     *
     * @param id, the Product that needs to be added.
     *
     * @return the response of the method
     */
    @PostMapping(value = "/addToShoppingCart")
    public ResponseEntity<Object> addToShoppingCart(@PathParam("id") Long id, @PathParam("quantity") int quantity) {
        return buyerService.addProductToShoppingCart(id, quantity);
    }

    /**
     * This method is used to buy all the Products in the Shopping Cart.
     *
     * @return the response of the method
     */
    @PostMapping(value = "/buyShoppingCart")
    public ResponseEntity<Object> buyShoppingCart() {
        return buyerService.buyShoppingCart();
    }

    /**
     * This method allows to buy an Event ticket
     *
     * @param eventDTO, the Event from which buying the ticket
     *
     * @return the response of the method
     */
    @PostMapping("/subscribe")
    public ResponseEntity<Object> subscribeToEvent(@RequestBody EventBoughtDTO eventDTO) {
        return buyerService.subscribeToEvent(eventDTO);
    }

    /**
     * This method allows to unsubscribe from an Event from which the user is registered
     *
     * @param eventDTO, the Event from which unsubscribing
     *
     * @return the response of the method
     */
    @DeleteMapping(value = "/unsubscribe")
    public ResponseEntity<Object> unsubscribeToEvent(@RequestBody EventBoughtDTO eventDTO) {
        return buyerService.unsubscribeToEvent(eventDTO);
    }
}


