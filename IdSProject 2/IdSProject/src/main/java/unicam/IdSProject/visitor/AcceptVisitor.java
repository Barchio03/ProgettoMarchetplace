package unicam.IdSProject.visitor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.models.Message;
import unicam.IdSProject.repositories.EventBoard;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.repositories.MessageRepository;
import unicam.IdSProject.repositories.ProductBoard;

/**
*
 * This class contains the logic behind the acceptance of a Visitable object
 *
 * @author Erika Aguiari, Luca Barchiesi
 *
 */

@Component
@RequiredArgsConstructor
public class AcceptVisitor implements Visitor {

    private final MessageRepository messageRepository;

    private final ProductBoard productBoard;

    private final EventBoard eventBoard;

    @Override
    public void visit(Product product) {
        productBoard.addProduct(product);
        messageRepository.save(new Message(null, product.getCreator(), "La tua richiesta per il prodotto "+
                product.getName()+ " è stata accettata"));
    }

    @Override
    public void visit(Event event) {
        eventBoard.addEvent(event);
        messageRepository.save(new Message(null, event.getCreator(), "La tua richiesta per l'evento "+
                event.getName()+ " è stata accettata"));
    }
}
