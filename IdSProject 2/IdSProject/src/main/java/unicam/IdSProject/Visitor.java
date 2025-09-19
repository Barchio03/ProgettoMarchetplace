package unicam.IdSProject;
import unicam.IdSProject.Models.Event;
import unicam.IdSProject.Models.Product;

/**
*
* This interface declares the methods to visit the concrete visitables (those who implement the Visitable interface)
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public interface Visitor {

    /**
     * This method visits a Product
     *
     * @param product
     */
    void visit(Product product);

    /**
     * This method visits an Event
     *
     * @param event
     */
    void visit(Event event);
}
