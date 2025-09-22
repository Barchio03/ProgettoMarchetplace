package unicam.IdSProject.visitor;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.models.Product;

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
