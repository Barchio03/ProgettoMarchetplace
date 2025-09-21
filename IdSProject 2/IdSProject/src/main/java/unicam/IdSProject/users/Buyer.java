package unicam.IdSProject.users;

import lombok.Getter;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.models.Mailbox;
import unicam.IdSProject.models.ShoppingCart;

/**
*
* This class represents a Buyer
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*/
@Getter
public class Buyer {
    
    private String name;
    private ShoppingCart shoppingCart;
    private Mailbox mailbox;
    private int id;
    private static int currentId;

    /**
    * This method creates a new Buyer object
    */
    public Buyer(String name){
        this.name = name;
    }

    
    
    private static int getCurrentId() {
        return currentId;
    }

    public String getName() {
        return name;
    }

    public ShoppingCart getShoppingCart(){ return shoppingCart; }

    public int getId() {
        return id;
    }

    public Mailbox getMailbox() {
        return mailbox;
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
