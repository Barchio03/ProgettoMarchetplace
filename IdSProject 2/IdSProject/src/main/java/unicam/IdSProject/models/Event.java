package unicam.IdSProject.models;

import unicam.IdSProject.Visitable;
import unicam.IdSProject.Visitor;
import unicam.IdSProject.users.Animator;
import unicam.IdSProject.users.Buyer;
import unicam.IdSProject.users.Seller;

import java.util.ArrayList;

/**
*
* This class represents an Event.
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class Event implements Visitable {

    private String name;
    private Animator creator;
    private int maxAttendees;
    private String description;
    private ArrayList<Seller> collaborators;
    private ArrayList<Buyer> subscribers;
    private final Long id;
    private static Long currentId;


    /**
     * This method creates a new Event object
     */
    public Event(String name, String description, Animator creator, ArrayList<Seller> collaborators){
        this.name=name;
        this.description=description;
        this.creator=creator;
        this.collaborators=collaborators;
        this.id=currentId++;
    }

    /**
     * This method creates a new Event object with a setted number of attendees
     */
    public Event(String name, String description, Animator creator, ArrayList<Seller> collaborators, int maxAttendees){
        this.name=name;
        this.description=description;
        this.creator=creator;
        this.collaborators=collaborators;
        this.maxAttendees=maxAttendees;
        this.id=currentId++;
    }

    private static Long getCurrentId() {
        return currentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animator getCreator() {
        return creator;
    }

    public void setCreator(Animator creator) {
        this.creator = creator;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public void setMaxAttendees(int maxAttendees) {
        this.maxAttendees = maxAttendees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public ArrayList<Seller> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(ArrayList<Seller> collaborators) {
        this.collaborators = collaborators;
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
            return this.id == event.id;
        }
    }

}
