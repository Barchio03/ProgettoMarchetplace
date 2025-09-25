package unicam.IdSProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.visitor.Visitable;
import unicam.IdSProject.visitor.Visitor;

import java.util.Objects;

/**
 *
 * This class represents an Event.
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
 *
 */

@Entity
@Getter
@Setter
@Table(name="events")
public class Event implements Visitable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String creator;
    @NotNull
    private int maxAttendees;
    @NotNull
    private String description;
    @NotNull
    private String collaborators;


//    private ArrayList<Buyer> subscribers;



    /**
     *
     * This method is used by a Buyer to subscribe to an Event.
     *
     * @param buyer, the Buyer who wants to subscribe to an Event.
     *
     * @return true if the operation ended successfully, false otherwise.
     */
//    public boolean subscribe(Buyer buyer) {
//        if(maxAttendees!=0) {
//            if(subscribers.size()==maxAttendees)
//                return false;
//        }
//        if (!subscribers.contains(buyer)){
//            subscribers.add(buyer);
//
//            return true;
//        } else return false;
//    }



    /**
     *
     * This method is used by a Buyer to unsubscribe to an Event.
     *
     * @param buyer, the Buyer who wants to unsubscribe to an Event.
     *
     * @return true if the operation ended successfully, false otherwise.
     *
     */
//    public boolean unsubscribe(Buyer buyer) {
//        if (subscribers.contains(buyer)){
//            subscribers.remove(buyer);
//            return true;
//        } else return false;
//    }

    /**
     * This method notifies the subscribers when needed
     *
     * @param message, the message to spread
     */
//    public void notifySubscribers(String message) {
//        for (Buyer sub : subscribers) {
//            sub.update(this, message);
//        }
//    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if(!(obj instanceof Event event)){
            return false;
        }
        else{
            return Objects.equals(this.id, event.id);
        }
    }

}
