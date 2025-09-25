package unicam.IdSProject.users;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.models.Event;

/**
*
* This class represents a Buyer
*
* @author Erika Aguiari, Luca Barchiesi
*/
@Getter
@Setter
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotNull
    private String name;
    @NotNull
    private Long shoppingCart;
//    private Mailbox mailbox;


    /**
    * This method creates a new Buyer object
    */
    public Buyer(String name){
        this.name = name;
    }


//    public Mailbox getMailbox() {
//        return mailbox;
//    }




    /**
     * This method is used to update the Buyer about the Event status.
     *
     * @param event, the Event that is being observed.
     */
    public void update(Event event, String message) {
//        this.getMailbox().addMessage("message");
    }
}
