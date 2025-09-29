package unicam.IdSProject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unicam.IdSProject.QuantifiedProduct;
import unicam.IdSProject.ShoppingCart;
import unicam.IdSProject.dtos.requests.*;
import unicam.IdSProject.dtos.response.ProducerProductDTO;
import unicam.IdSProject.ids.SubId;
import unicam.IdSProject.mappers.EventMapper;
import unicam.IdSProject.mappers.ProductMapper;
import unicam.IdSProject.models.*;
import unicam.IdSProject.repositories.EventBoard;
import unicam.IdSProject.repositories.MessageRepository;
import unicam.IdSProject.repositories.ProductBoard;
import unicam.IdSProject.repositories.SubscriberRepository;
import unicam.IdSProject.users.Buyer;

@RequiredArgsConstructor
@Service
public class BuyerService {

    private final ProductMapper productMapper;

    private final MessageRepository messageRepository;
    private final SubscriberRepository subscriberRepository;

    private final ProductBoard productBoard;
    private final EventBoard eventBoard;

    private final Mailbox mailbox;

    private final ShoppingCart shoppingCart= new ShoppingCart();
    private Buyer buyer = new Buyer("buyer1", "Buyer");


    public ResponseEntity<Object> addProductToShoppingCart(Long id, int quantity) {
        if (!productBoard.contains(id)) return new ResponseEntity<>("Il prodotto non esiste", HttpStatus.BAD_REQUEST);
        Product product = productBoard.getProduct(id);
        if (product.getStockNumber() < quantity) return new ResponseEntity<>("Non ci sono abbastanza scorte di questo prodotto", HttpStatus.BAD_REQUEST);

        QuantifiedProduct qProduct = new QuantifiedProduct(product, quantity);

        if (shoppingCart.addQuantifiedProduct(qProduct)) {
            return new ResponseEntity<>("Prodotto aggiunto al carrello", HttpStatus.OK);
        } else return new ResponseEntity<>("Errore", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> buyShoppingCart() {
        if (shoppingCart == null || shoppingCart.getQuantifiedProducts().isEmpty()){
            return new ResponseEntity<>("Carrello Vuoto", HttpStatus.BAD_REQUEST);
        }

        for (QuantifiedProduct quantifiedProduct : shoppingCart.getQuantifiedProducts()) {
            productBoard.updateStock(quantifiedProduct.getProduct(), quantifiedProduct.getProduct().getStockNumber()-quantifiedProduct.getStockNumber());
            messageRepository.save(new Message(null, quantifiedProduct.getProduct().getCreator(),
                    "Il tuo prodotto " + quantifiedProduct.getProduct().getName() + " è stato acquistato in "
                            + quantifiedProduct.getStockNumber() + " quantità da "+ buyer.getName()));
        }
        
        String receipt = this.makeReceipt(shoppingCart);
        shoppingCart.clear();
        return new ResponseEntity<>(receipt, HttpStatus.OK);

    }

    public ResponseEntity<Object> subscribeToEvent(EventBoughtDTO eventBoughtDTO) {
        if (!eventBoard.contains(eventBoughtDTO.getId())){
            return new ResponseEntity<>("Evento nullo", HttpStatus.BAD_REQUEST);
        }

        Subscriber subscriber = new Subscriber(eventBoughtDTO.getId(), buyer.getId());
        if (subscriberRepository.existsById(new SubId(eventBoughtDTO.getId(), buyer.getId())))
            return new ResponseEntity<>("Utente già iscritto", HttpStatus.CONFLICT);

        Event event = eventBoard.getEvent(eventBoughtDTO.getId());
        if (event.getMaxAttendees()!= 0 && event.getMaxAttendees()==event.getAttendees())
            return new ResponseEntity<>("Ticket Terminati", HttpStatus.NOT_ACCEPTABLE);

        eventBoard.addSubscriberToEvent(event);
        subscriberRepository.save(subscriber);
        return new ResponseEntity<>("Iscrizione avvenuta con successo", HttpStatus.OK);

    }

    public ResponseEntity<Object> unsubscribeToEvent(EventBoughtDTO eventBoughtDTO) {
        if (!eventBoard.contains(eventBoughtDTO.getId())){
            return new ResponseEntity<>("Evento nullo", HttpStatus.BAD_REQUEST);
        }

        Subscriber subscriber = new Subscriber(eventBoughtDTO.getId(), buyer.getId());
        if (!subscriberRepository.existsById(new SubId(eventBoughtDTO.getId(), buyer.getId())))
            return new ResponseEntity<>("Utente già disiscritto", HttpStatus.CONFLICT);

        Event event = eventBoard.getEvent(eventBoughtDTO.getId());
        if (event.getMaxAttendees()!= 0)
            eventBoard.removeSubscriberToEvent(event);

        subscriberRepository.delete(subscriber);
        return new ResponseEntity<>("Disiscrizione avvenuta con successo", HttpStatus.OK);
    }

    public ResponseEntity<Object> openMailbox() {
        return new ResponseEntity<>(mailbox.getMessages(buyer.getId()), HttpStatus.OK) ;
    }

    private String makeReceipt(ShoppingCart shoppingCart){
        String receipt = "Ricevuta di " + buyer.getName() + "\n";
        for (QuantifiedProduct qProduct : shoppingCart.getQuantifiedProducts()){
            String printProduct = "Nome: " + qProduct.getProduct().getName() +
                    "\nNumero stock: " + qProduct.getStockNumber() +
                    "\nPrezzo: " + qProduct.getProduct().getPrice() * qProduct.getStockNumber() +"€\n\n";
            receipt = receipt + printProduct;
        }
        receipt = receipt + "Prezzo totale: " + shoppingCart.getTotalPrice() + "€";
        messageRepository.save(new Message(null, buyer.getId(),receipt));
        return receipt;
    }

}
