package unicam.IdSProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.models.EventBoard;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.models.ProductBoard;

/**
*
 * This class contains the logic behind the acceptance of a Visitable object
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi 
 *
 */
@Component
public class AcceptVisitor implements Visitor {

    @Autowired
    private final ProductBoard productBoard;
    @Autowired
    private final EventBoard eventBoard;

    /**
    * This method creates a new AcceptVisitor object
    */
    @Autowired
    public AcceptVisitor(ProductBoard productBoard, EventBoard eventBoard) {
        this.productBoard=productBoard;
        this.eventBoard=eventBoard;
    }

    @Override
    public void visit(Product product) {
        productBoard.addProduct(product);
        product.getCreator().getMailbox().addMessage("La tua richiesta per il prodotto "+
                product.getName()+ " è stata accettata");
    }

    @Override
    public void visit(Event event) {
        eventBoard.addEvent(event);
        event.getCreator().getMailbox().addMessage("La tua richiesta per l'evento "+
                event.getName()+ " è stata accettata");
    }
}
