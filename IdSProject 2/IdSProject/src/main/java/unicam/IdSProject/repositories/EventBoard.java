package unicam.IdSProject.repositories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.users.Animator;
import unicam.IdSProject.models.Event;

import java.util.ArrayList;

/**
 * This class represents an Event Board, it contains all the Events
 *
 * @author Luca Barchiesi, Erika Aguiari
 */
@AllArgsConstructor
public class EventBoard {

    private final EventRepository eventRepository ;


    /**
     * This method returns a list of all the Event in the repository
     *
     * @return a list of all the Event in the repository
     */
    public ArrayList<Event> getEvents(){
        return (ArrayList<Event>) eventRepository.findAll();
    }


    /**
     * This method adds an Event to the Event Board
     *
     * @param event, the Event to add
     *
     * @return true if the Event was added successfully, false otherwise
     */
    public boolean addEvent(Event event) {
        if (eventRepository.existsById(event.getId())){
            return false;
        }
        eventRepository.save(event);
        return true;
    }

    /**
     * This method removes an Event from the Event Board
     *
     * @param event, the Event to delete
     *
     * @return true is the Event was deleted successfully, false otherwise
     */
    public boolean removeEvent(Event event) {
        if (!eventRepository.existsById(event.getId())){
            return false;
        }
        eventRepository.delete(event);
        return true;
    }

    /**
     * This method removes an Event from the Event Board
     *
     * @param id, the id of the Event to delete
     *
     * @return true is the Event was deleted successfully, false otherwise
     */
    public boolean removeEvent(Long id) {
        if (eventRepository.existsById(id)){
            return false;
        }
        eventRepository.deleteById(id);
        return true;
    }

    /**
     * This method verifies whether an Event is in the Event Board
     *
     * @param event, the Event to search for
     *
     * @return true if the Event is present, false otherwise
     */
    public boolean contains(Event event) {
        return eventRepository.existsById(event.getId());
    }

     /**
     * This method return a list of Events organized by the same Animator
     *
     * @param animator, the Animator from witch searching the Events
     *
     * @return the list of Events organized by the Animator
     */
    public ArrayList<Event> getEvents(Animator animator) {
        ArrayList<Event> sublist = new ArrayList<>();
        ArrayList<Event> events = (ArrayList<Event>) eventRepository.findAll();
        for (Event event : events) {
            if (event.getCreator().equals(animator)) sublist.add(event);
        }
        return sublist;
    }

}
