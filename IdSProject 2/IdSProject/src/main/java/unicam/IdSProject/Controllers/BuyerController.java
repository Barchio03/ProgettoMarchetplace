package unicam.IdSProject.Controllers;

import unicam.IdSProject.Models.EventBoard;
import unicam.IdSProject.Models.Buyer;
import unicam.IdSProject.Models.Event;
import unicam.IdSProject.Models.Product;
import unicam.IdSProject.Models.ProductBoard;

public class BuyerController {

    private Buyer buyer;

    private ProductBoard productBoard;

    private EventBoard eventboard;

    public BuyerController(Buyer buyer, ProductBoard productBoard, EventBoard eventBoard){
        this.buyer = buyer;
        this.productBoard = productBoard;
        this.eventboard = eventBoard;
    }


    /**
     *
     * This method adds a product to the shopping cart.
     *
     * @param product, the product that needs to be added.
     *
     * @return true if the product is added successfully, false otherwise.
     *
     */
    public boolean addProduct(Product product, int quantity) {
        buyer.addToShoppingCart(product, quantity);
        return true;
    }



    /**
     *
     * This method is used to buy all the products in the shopping cart.
     *
     * @return true if the products are sold successfully, false otherwise.
     *
     */
    public boolean buyShoppingCart(){
        return false;
    }



    /**
     *
     * This method is used to update the buyer about the event status.
     *
     * @param event, the event that is being observed.
     *
     */
    public boolean buyEventTicket(Event event){
        return false;
    }
}

