package unicam.IdSProject;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.repositories.RequestHandler;

/**
*
 * This class contains the logic behind the opening of a Visitable object
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi 
 *
 */
public class OpenVisitor implements Visitor {

    private RequestHandler requestHandler;

    @Override
    public void visit(Product product) {
        product.toString();
    }

    @Override
    public void visit(Event event) {
        event.toString();
    }
}
