package unicam.IdSProject;

import java.util.ArrayList;

/**
*
* This class represents an event.
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class Event implements Visitable{

    /**
     * The name of the event
     */
    private String name;

    /**
     * The creator of the event
     */
    private Animator creator;

    /**
     * The maximum number of attendees, if set to 0 there's no limit
     */
    private int maxAttendees;

    /**
     * The description of the event
     */
    private String description;

    /**
     * The id of the event
     */
    private int id;

    private static int currentId;

    /**
     * The collaborators to the event
     */
    private ArrayList<Seller> collaborators;

    /**
     * The people who have subscribes to join the event
     */
    private ArrayList<Buyer> subscribers;

    /**
     * Creates a new event
     */
    public Event(String name, String description, Animator creator, ArrayList<Seller> collaborators){
        this.name=name;
        this.description=description;
        this.creator=creator;
        this.collaborators=collaborators;
        this.id=currentId++;
    }

    /**
     * Creates a new event with a set number of attendees
     */
    public Event(String name, String description, Animator creator, ArrayList<Seller> collaborators, int maxAttendees){
        this.name=name;
        this.description=description;
        this.creator=creator;
        this.collaborators=collaborators;
        this.maxAttendees=maxAttendees;
        this.id=currentId++;
    }

    private static int getCurrentId() {
        return currentId;
    }

    /**
     * @return the name of the event
     */
    public String getName() {
        return name;
    }

    /**
     * @param name of the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the creator of the event
     */
    public Animator getCreator() {
        return creator;
    }

    /**
     * @param creator of the event
     */
    public void setCreator(Animator creator) {
        this.creator = creator;
    }

    /**
     * @return the maximum number of attendees
     */
    public int getMaxAttendees() {
        return maxAttendees;
    }

    /**
     * @param maxAttendees, the maximum number of attendees
     */
    public void setMaxAttendees(int maxAttendees) {
        this.maxAttendees = maxAttendees;
    }

    /**
     * @return the description of the event
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description, the description of the event
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the id of the event
     */
    public int getId() {
        return id;
    }

    /**
     * @return the collaborators of the event
     */
    public ArrayList<Seller> getCollaborators() {
        return collaborators;
    }

    /**
     * @param collaborators, the collaborators of the event
     */
    public void setCollaborators(ArrayList<Seller> collaborators) {
        this.collaborators = collaborators;
    }

    /**
    *
    * This method is used by a buyer to subscribe to an event.
    *
    * @param buyer, the buyer who wants to subscribe to an event.
    *
    * @return true if the operation ended successfully, false otherwise.
    *
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
    * This method is used by a buyer to unsubscribe to an event.
    *
    * @param buyer, the buyer who wants to unsubscribe to an event.
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
     * Notifies the subscribers when needed
     *
     * @param message, the message to spread
     */
    public void notifySubscribers(String message) {
        for (Buyer sub : subscribers) {
            sub.update(this, message);
        }
    }

    /**
     * Accepts a visitor to be verified by the Curator
     *
     * @param visitor to accept
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
