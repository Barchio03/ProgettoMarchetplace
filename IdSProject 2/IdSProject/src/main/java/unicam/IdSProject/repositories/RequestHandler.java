package unicam.IdSProject.repositories;
import org.springframework.stereotype.Component;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.models.Product;

import java.util.ArrayList;

/**
*
* This class contains the lists of Objects that need to be verified by the Curator
*
* @author Erika Aguiari, Luca Barchiesi
*
*/
@Component
public class RequestHandler {

    private final ArrayList<Product> productRequests;
    private final ArrayList<Event> eventRequests;

    /**
     * This method creates a new RequestHandler object
     */
    public RequestHandler() {
        this.productRequests = new ArrayList<>();
        this.eventRequests = new ArrayList<>();
    }

    /**
     * This method adds a Product to the list
     *
     * @param product, the Product to add
     *
     * @return true if it was added successfully, false otherwise
     */
    public boolean addProduct(Product product) {
        if (productRequests.contains(product)){
            return false;
        }
        return productRequests.add(product);
    }

    /**
     * This method returns the first Product of the list to verify and deletes it from the list
     *
     * @return the next Product to verify
     */
    public Product getNextProduct(){
        Product temp = productRequests.getFirst();
        productRequests.removeFirst();
        return temp;
    }

    /**
     * This method adds an Event to the list
     *
     * @param event, the Event to add
     *
     * @return true if it was added successfully, false otherwise
     */
    public boolean addEvent(Event event) {

        if (eventRequests.contains(event)){
            return false;
        }
        return eventRequests.add(event);
    }

    /**
     * This method returns the first Event of the list to verify and deletes it from the list
     *
     * @return the next Event to verify
     */
    public Event getNextEvent(){
        Event temp = eventRequests.getFirst();
        eventRequests.removeFirst();
        return temp;
    }
}
