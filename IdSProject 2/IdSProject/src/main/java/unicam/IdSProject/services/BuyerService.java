package unicam.IdSProject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unicam.IdSProject.QuantifiedProduct;
import unicam.IdSProject.ShoppingCart;
import unicam.IdSProject.dtos.requests.ProductBoughtDTO;
import unicam.IdSProject.mappers.EventMapper;
import unicam.IdSProject.mappers.ProductMapper;
import unicam.IdSProject.models.*;
import unicam.IdSProject.repositories.MessageRepository;
import unicam.IdSProject.repositories.ProductBoard;
import unicam.IdSProject.users.Buyer;

@RequiredArgsConstructor
@Service
public class BuyerService {

    private final ProductMapper productMapper;
    private final EventMapper eventMapper;

    private final MessageRepository messageRepository;

    private final ProductBoard productBoard;

    private final Buyer buyer;


    public ResponseEntity<Object> addProductToShoppingKart(ProductBoughtDTO productBoughtDTO, int quantity) {
        Product product = productMapper.toEntityWithAllFields(productBoughtDTO);

        if (!productBoard.contains(product)) return new ResponseEntity<>("Il prodotto non esiste", HttpStatus.BAD_REQUEST);
        if (product.getStockNumber() <= quantity) return new ResponseEntity<>("Non ci sono abbastanza scorte di questo prodotto", HttpStatus.BAD_REQUEST); 

        QuantifiedProduct qProduct = new QuantifiedProduct(product, quantity);

        if (buyer.getShoppingCart().addQuantifiedProduct(qProduct)) {
            return new ResponseEntity<>("Prodotto aggiunto al carrello", HttpStatus.OK);
        } else return new ResponseEntity<>("Errore", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Object> buyShoppingCart() {
        if (buyer.getShoppingCart() == null || buyer.getShoppingCart().getQuantifiedProducts().isEmpty()){
            return new ResponseEntity<>("Carrello Vuoto", HttpStatus.BAD_REQUEST);
        }

        buyer.getShoppingCart().getQuantifiedProducts()
                .stream().map(quantifiedProduct -> this.decreaseStock(quantifiedProduct));
        
        String receipt = this.makeReceipt(buyer.getShoppingCart());
        buyer.getShoppingCart().clear();     
        return new ResponseEntity<>(receipt, HttpStatus.OK);

    }

//    public ResponseEntity<Object> subscribeToEvent(EventBoughtDTO eventBoughtDTO) {
//        Event event = eventMapper.toEntityWithAllFields(eventBoughtDTO);
//
//        if (event == null){
//            return new ResponseEntity<>("Evento nullo", HttpStatus.BAD_REQUEST);
//        }
//
//        if (event.subscribe(buyer))
//            return new ResponseEntity<>("Iscrizione avvenuta con successo", HttpStatus.OK);
//        else return new ResponseEntity<>("Utente già iscritto", HttpStatus.CONFLICT);
//
//    }

//    public ResponseEntity<Object> unsubscribeToEvent(EventBoughtDTO eventBoughtDTO) {
//        Event event = eventMapper.toEntityWithAllFields(eventBoughtDTO);
//
//        if (event == null){
//            return new ResponseEntity<>("Evento nullo", HttpStatus.BAD_REQUEST);
//        }
//
//        if (event.unsubscribe(buyer))
//            return new ResponseEntity<>("Disiscrizione avvenuta con successo", HttpStatus.OK);
//        else return new ResponseEntity<>("Iscrizione non possibile", HttpStatus.CONFLICT);
//    }


    private QuantifiedProduct decreaseStock(QuantifiedProduct product) {
        product.getProduct().setStockNumber(product.getProduct().getStockNumber()-product.getStockNumber());
        return product;
    }

    private String makeReceipt(ShoppingCart shoppingCart){
        String receipt = "Ricevuta di " + buyer.getName() + "\n";
        for (QuantifiedProduct qProduct : shoppingCart.getQuantifiedProducts()){
            String printProduct = "Nome: " + qProduct.getProduct().getName() +
                    "\nNumero stock: " + qProduct.getStockNumber() +
                    "\nPrezzo: " + qProduct.getProduct().getPrice() * qProduct.getStockNumber() +"€\n\n";
            receipt = receipt + printProduct;
        }
        receipt = receipt + "Prezzo totale: " + shoppingCart.getTotalPrice() + "$";
        messageRepository.save(new Message(null, shoppingCart.getBuyer(),receipt));
        // Aggiungere ReceiptRepository per PlatformHandler
        return receipt;
    }

}
