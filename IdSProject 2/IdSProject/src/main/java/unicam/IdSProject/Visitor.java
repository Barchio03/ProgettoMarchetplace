package unicam.IdSProject;

import unicam.IdSProject.Models.Event;

/**
 * This interface declares the methods to visit the concrete visitables (those who implement the Visitable interface)
 */
public interface Visitor {

    /**
     * Visits a product
     *
     * @param product
     */
    public void visit(Product product);

    /**
     * Visits an event
     *
     * @param event
     */
    public void visit(Event event);
}
