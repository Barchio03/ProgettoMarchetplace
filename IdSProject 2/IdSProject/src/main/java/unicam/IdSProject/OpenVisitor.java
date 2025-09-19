package unicam.IdSProject;
import unicam.IdSProject.Models.Event;
import unicam.IdSProject.Models.Product;
import unicam.IdSProject.Models.RequestHandler;

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
