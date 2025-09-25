package unicam.IdSProject.visitor;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.models.Product;

/**
*
 * This class contains the logic behind the denial of a Visitable object
 *
 * @author Erika Aguiari, Luca Barchiesi
 *
 */
public class DenyVisitor implements Visitor {

    private final String message;

    /**
    * This method creates a new DenyVisitor object
    */
    public DenyVisitor(String message) {
        this.message=message;
    }

    @Override
    public void visit(Product product) {
        product.getCreator().getMailbox().addMessage("La tua richiesta per il prodotto "+
                product.getName()+ " è stata negata. \nMotivo: "+message);
    }

    @Override
    public void visit(Event event) {
        event.getCreator().getMailbox().addMessage("La tua richiesta per l'evento "+
                event.getName()+ " è stata negata. \nMotivo: "+message);
    }
}
