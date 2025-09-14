package unicam.IdSProject.Models;

import unicam.IdSProject.QuantifiedProduct;
import unicam.IdSProject.ShoppingCart;

/**
*
* This method creates an object Product.
*
* @author Luca Barchiesi
*
*/
public class Buyer {
    
    private String name;

    private ShoppingCart shoppingCart;

    private Mailbox mailbox;

    private int id;

    private static int currentId;


    
    private static int getCurrentId() {
        return currentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Mailbox getMailbox() {
        return mailbox;
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
    public boolean addToShoppingCart(Product product, int quantity) {
       return shoppingCart.addQuantifiedProduct(new QuantifiedProduct(product, quantity));
    }


    
    /**
    *
    * This method is used to update the buyer about the event status.
    *
    * @param event, the event that is being observed.
    *
    */
    public void update(Event event, String message) {
        this.getMailbox().addMessage("message");
    }

}
