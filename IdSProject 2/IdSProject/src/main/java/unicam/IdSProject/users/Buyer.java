package unicam.IdSProject.users;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import unicam.IdSProject.ShoppingCart;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.models.Mailbox;
import unicam.IdSProject.visitor.Visitable;

/**
*
* This class represents a Buyer
*
* @author Erika Aguiari, Luca Barchiesi
*/
@Getter
@Setter
public class Buyer {

    private String id;

    private String name;

    private Mailbox mailbox;

    /**
    * This method creates a new Buyer object
    */
    public Buyer(String id, String name){
        this.id = id;
        this.name = name;
        this.mailbox = new Mailbox();
    }

    /**
     * This method is used to update the Buyer about the Event status.
     *
     * @param event, the Event that is being observed.
     */
    public void update(Event event, String message) {
        Mailbox.addMessage(this.id, "Notifica da " + event.getName() + ": " + message);
    }
}
