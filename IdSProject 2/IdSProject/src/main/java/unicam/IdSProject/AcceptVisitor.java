package unicam.IdSProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class has the logic behind the acceptance of a Visitable object
 *
 * @author Erika Aguiari, Luca Barchiesi, Ilaria Morettini
 */
@Component
public class AcceptVisitor implements Visitor {

    /**
     * The product board to add the products to
     */
    @Autowired
    private ProductBoard productBoard;

    /**
     * The event board to add the events to
     */
    @Autowired
    private EventBoard eventBoard;

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
