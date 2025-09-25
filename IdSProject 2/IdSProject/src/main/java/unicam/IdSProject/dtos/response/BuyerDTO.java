package unicam.IdSProject.dtos.response;

import lombok.Data;
import unicam.IdSProject.models.Mailbox;
import unicam.IdSProject.ShoppingCart;

@Data
public class BuyerDTO {
    private String name;

    private Mailbox mailbox;

    private ShoppingCart shoppingCart;

}
