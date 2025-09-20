package unicam.IdSProject.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * This class represents an Event Board and it contains all the Events
 *
 * @author Luca Barchiesi, Erika Aguiari, Ilaria Morettini
 */
@Component
public class EventBoard {


    private final ArrayList<Event> events;

    /**
    * This method creates a new EventBoard object
    */
    public EventBoard(){
        this.events = new ArrayList<Event>();
    }

    /**
     * This method adds an Event to the Event Board
     *
     * @param event, the Event to add
     *
     * @return true if the Event was added successfully, false otherwise
     */
    public boolean addEvent(Event event) {
        return events.add(event);
    }

    /**
     * This method removes an Event from the Event Board
     *
     * @param event, the Event to delete
     *
     * @return true is the Event was deleted successfully, false otherwise
     */
    public boolean removeEvent(Event event) {
        return events.remove(event);
    }

    /**
     * This method removes an Event from the Event Board
     *
     * @param id, the id of the Event to delete
     *
     * @return true is the Event was deleted successfully, false otherwise
     */
    public boolean removeEvent(int id) {
        for( Event event:  events) {
            if (event.getId() == id) {
                events.remove(event);
                return true;
            }
        }
        return false;
    }

    /**
     * This method verifies whether an Event is in the Event Board
     *
     * @param event, the Event to search for
     *
     * @return true if the Event is present, false otherwise
     */
    public boolean contains(Event event) {
        return events.contains(event);
    }

     /**
     * This method return a list of Events organized by the same Animator
     *
     * @param animator, the Animator from witch searching the Events
     *
     * @return the list of Events organized by the Animator
     */
    public ArrayList<Event> getEvents(Animator animator) {
        ArrayList<Event> sublist = new ArrayList<Event>();
        for (Event event : events) {
            if (event.getCreator().equals(animator)) sublist.add(event);
        }
        return sublist;
    }

}
