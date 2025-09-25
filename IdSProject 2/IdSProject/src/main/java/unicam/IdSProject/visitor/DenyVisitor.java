package unicam.IdSProject.visitor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.models.Message;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.repositories.MessageRepository;

/**
*
 * This class contains the logic behind the denial of a Visitable object
 *
 * @author Erika Aguiari, Luca Barchiesi
 *
 */
@Setter
@RequiredArgsConstructor
public class DenyVisitor implements Visitor {

    private final MessageRepository messageRepository;

    private String message;

    @Override
    public void visit(Product product) {
        messageRepository.save(new Message(null, product.getCreator(), "La tua richiesta per il prodotto "+
                product.getName()+ " è stata negata. \nMotivo: "+message));
    }

    @Override
    public void visit(Event event) {
        messageRepository.save(new Message(null, event.getCreator(), "La tua richiesta per l'evento "+
                event.getName()+ " è stata negata. \nMotivo: "+message));
    }

}
