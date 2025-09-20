package unicam.IdSProject.Models.DTOs;

import unicam.IdSProject.Models.Mailbox;
import unicam.IdSProject.Models.ShoppingCart;

public class BuyerDTO {
    private String name;

    private Mailbox mailbox;

    private ShoppingCart shoppingCart;

    public BuyerDTO(String name, Mailbox mailbox, ShoppingCart shoppingCart){
        this.name = name;
        this.mailbox = mailbox;
        this.shoppingCart = shoppingCart;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mailbox getMailbox() {
        return mailbox;
    }

    public void setMailbox(Mailbox mailbox) {
        this.mailbox = mailbox;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
