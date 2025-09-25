package unicam.IdSProject.models;

import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.visitor.Visitable;
import unicam.IdSProject.visitor.Visitor;
import unicam.IdSProject.users.Animator;
import unicam.IdSProject.users.Buyer;
import unicam.IdSProject.users.Seller;

import java.util.ArrayList;

/**
*
* This class represents an Event.
*
* @author Erika Aguiari, Luca Barchiesi
*
*/
@Getter
public class Event implements Visitable {

    @Setter
    private String name;
    @Setter
    private Animator creator;
    @Setter
    private int maxAttendees;
    @Setter
    private String description;
    @Setter
    private ArrayList<Seller> collaborators;
    @Setter
    private ArrayList<Buyer> subscribers;
    private final Long id;


    /**
     * This method creates a new Event object
     */
    public Event(String name, String description, Animator creator, ArrayList<Seller> collaborators, Long id){
        this.name=name;
        this.description=description;
        this.creator=creator;
        this.collaborators=collaborators;
        this.id = id;
    }

    /**
     * This method creates a new Event object with a setted number of attendees
     */
    public Event(String name, String description, Animator creator, ArrayList<Seller> collaborators, Long id, int maxAttendees){
        this.name=name;
        this.description=description;
        this.creator=creator;
        this.collaborators=collaborators;
        this.id = id;
        this.maxAttendees=maxAttendees;
    }



    /**
    *
    * This method is used by a Buyer to subscribe to an Event.
    *
    * @param buyer, the Buyer who wants to subscribe to an Event.
    *
    * @return true if the operation ended successfully, false otherwise.
    */
    public boolean subscribe(Buyer buyer) {
        if(maxAttendees!=0) {
            if(subscribers.size()==maxAttendees)
                return false;
        }
        if (!subscribers.contains(buyer)){
            subscribers.add(buyer);

            return true;
        } else return false;
    }



    /**
    *
    * This method is used by a Buyer to unsubscribe to an Event.
    *
    * @param buyer, the Buyer who wants to unsubscribe to an Event.
    *
    * @return true if the operation ended successfully, false otherwise.
    *
    */
    public boolean unsubscribe(Buyer buyer) {
        if (subscribers.contains(buyer)){
            subscribers.remove(buyer);
            return true;
        } else return false;
    }

    /**
     * This method notifies the subscribers when needed
     *
     * @param message, the message to spread
     */
    public void notifySubscribers(String message) {
        for (Buyer sub : subscribers) {
            sub.update(this, message);
        }
    }


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
            return this.id.equals(event.id);
        }
    }

}
