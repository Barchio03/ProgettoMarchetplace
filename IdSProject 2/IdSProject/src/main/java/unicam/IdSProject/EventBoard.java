package unicam.IdSProject;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * This class contains all the events
 *
 * @author Luca Barchiesi, Erika Aguiari, Ilaria Morettini
 */
@Component
public class EventBoard {

    /**
     * The list of events
     */
    private ArrayList<Event> events;

    public EventBoard(){
        this.events = new ArrayList<Event>();
    }

    /**
     * Adds an event to the event board
     *
     * @param event to add
     *
     * @return true if the event was added successfully, false otherwise
     */
    public boolean addEvent(Event event) {
        return events.add(event);
    }

    /**
     * removes an event from the event board
     *
     * @param event to delete
     *
     * @return true is the event was deleted successfully, false otherwise
     */
    public boolean removeEvent(Event event) {
        return events.remove(event);
    }

    /**
     * Verifies whether an event is in the event board
     *
     * @param event
     *
     * @return true if the event is in the board, false otherwise
     */
    public boolean contains(Event event) {
        return events.contains(event);
    }

    public ArrayList<Event> getEvents(Animator animator) {
        ArrayList<Event> sublist = new ArrayList<Event>();
        for (Event event : events) {
            if (event.getCreator().equals(animator)) sublist.add(event);
        }
        return sublist;
    }

}
