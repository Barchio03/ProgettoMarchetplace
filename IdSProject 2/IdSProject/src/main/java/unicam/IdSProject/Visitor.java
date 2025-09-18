package unicam.IdSProject;

import unicam.IdSProject.Models.Event;
import unicam.IdSProject.Models.Product;

/**
 * This interface declares the methods to visit the concrete visitables (those who implement the Visitable interface)
 */
public interface Visitor {

    /**
     * Visits a product
     *
     * @param product
     */
    void visit(Product product);

    /**
     * Visits an event
     *
     * @param event
     */
    void visit(Event event);
}
