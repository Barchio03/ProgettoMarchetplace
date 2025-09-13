package unicam.IdSProject;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * This class contains the lists of objects that need to be verified by the curator
 *
 * @author Luca Barchiesi, Erika Aguiari, Ilaria Morettini
 */
@Component
public class RequestHandler {

    /**
     * The list of products to be verified
     */
    private ArrayList<Product> productRequests;

    /**
     * The list of events to be verified
     */
    private ArrayList<Event> eventRequests;

    /**
     * Creates a new request handler
     */
    public RequestHandler() {
        this.productRequests = new ArrayList<Product>();
        this.eventRequests = new ArrayList<Event>();
    }

    /**
     * Adds a product to the list
     *
     * @param product
     *
     * @return true if the product was added successfully, false otherwise
     */
    public boolean addProduct(Product product) {
        return productRequests.add(product);
    }

    /**
     * Returns and deletes the first product of the list
     *
     * @return the next product to verify
     */
    public Product getNextProduct(){
        Product temp = productRequests.get(0);
        productRequests.remove(0);
        return temp;
    }

    /**
     * Adds an event to the list
     *
     * @param event
     *
     * @return true if the event was added successfully, false otherwise
     */
    public boolean addEvent(Event event) {
        return eventRequests.add(event);
    }

    /**
     * Returns and deletes the first event of the list
     *
     * @return the next event to verify
     */
    public Event getNextEvent(){
        Event temp = eventRequests.get(0);
        eventRequests.remove(0);
        return temp;
    }
}
