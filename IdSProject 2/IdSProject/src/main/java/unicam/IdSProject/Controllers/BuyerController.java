package unicam.IdSProject.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unicam.IdSProject.Models.EventBoard;
import unicam.IdSProject.Models.Buyer;
import unicam.IdSProject.Models.Event;
import unicam.IdSProject.Models.Product;
import unicam.IdSProject.Models.ProductBoard;

/**
*
* This class implements the methods for handling all the Buyer interaction with the marketplace
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class BuyerController {

    private final Buyer buyer;
    private final ProductBoard productBoard;
    private final EventBoard eventboard;

    public BuyerController(Buyer buyer, ProductBoard productBoard, EventBoard eventBoard){
        this.buyer = buyer;
        this.productBoard = productBoard;
        this.eventboard = eventBoard;
    }


    /**
     * This method adds a Product to the Shopping Cart.
     *
     * @param product, the Product that needs to be added.
     *
     * @return true if it is added successfully, false otherwise.
     */
    public boolean addProduct(Product product, int quantity) {
        buyer.addToShoppingCart(product, quantity);
        return true;
    }



    /**
     * This method is used to buy all the Products in the Shopping Cart.
     *
     * @return true  if the purchase was successfull, false otherwise
     */
    public boolean buyShoppingCart(){
        if (buyer.getShoppingCart() == null || buyer.getShoppingCart().getQuantifiedProducts().isEmpty()){
            return false;
        }

      //Ci sarebbe la necessità di creare una nuova classe addetta all'acquisto di prodotti ed eventi
      //Da farlo con la stretta struttura SpringBoot di RequestHandler

      //if(purchaseHandler.pay(paymentSystem)){
      //    return true;
      //}               

        return false;
    }



    /**
     * This method allows to buy an Event tickey
     *
     * @param event, the Event from which buying the ticket
     *
     * @return true if the purchase was successfull, false otherwise
     */
    public boolean buyEventTicket(Event event){
        if (event == null){
            return false;
        }

      //if(purchaseHandler.pay(paymentSystem)){
      //return true;
      //}                                                                                       

        return false;
    }


    
    /**
    * This method adds a Product to the Shopping Cart.
    *
    * @param product, the Product that needs to be added.
    *
    * @return true if it is added successfully, false otherwise.
    */
    public boolean addToShoppingCart(Product product, int quantity) {
       return shoppingCart.addQuantifiedProduct(new QuantifiedProduct(product, quantity));
    }

    
    /**
    * This method is used to update the Buyer about the Event status.
    *
    * @param event, the Event that is being observed.
    */
    public void update(Event event, String message) {
        this.getMailbox().addMessage("message");
    }
}

