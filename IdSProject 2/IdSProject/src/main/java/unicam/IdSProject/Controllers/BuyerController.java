package unicam.IdSProject.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unicam.IdSProject.Models.EventBoard;
import unicam.IdSProject.Models.Buyer;
import unicam.IdSProject.Models.Event;
import unicam.IdSProject.Models.Product;
import unicam.IdSProject.Models.ProductBoard;

public class BuyerController {

    private final Buyer buyer;

    private final ProductBoard productBoard;

    private final EventBoard eventboard;

    public BuyerController(Buyer buyer, ProductBoard productBoard, EventBoard eventBoard){
        this.buyer = buyer;
        this.productBoard = productBoard;
        this.eventboard = eventBoard;
    }


    /**
     *
     * This method adds a product to the shopping cart.
     *
     * @param product, the product that needs to be added.
     *
     * @return true if the product is added successfully, false otherwise.
     *
     */
    public boolean addProduct(Product product, int quantity) {
        buyer.addToShoppingCart(product, quantity);
        return true;
    }



    /**
     *
     * This method is used to buy all the products in the shopping cart.
     *
     * @return RespondeEntity<Object>, the response about the procedure
     *
     */
    public ResponseEntity<Object> buyShoppingCart(){
        if (buyer.getShoppingCart() == null || buyer.getShoppingCart().getQuantifiedProducts().isEmpty()){
            return new ResponseEntity<>("Carrello vuoto o insesistente", HttpStatus.BAD_REQUEST);
        }

        //Ci sarebbe la necessità di creare una nuova classe addetta all'acquisto di prodotti ed eventi
        //Da farlo con la stretta struttura SpringBoot di RequestHandler

        
    /*  if(shoppingHandler.callPaymentSystem(paymentSystem)){
            return new ResponseEntity<>("I prodotti sono stati acquistati", HttpStatus.OK);

        }                                                                                       */
        return new ResponseEntity<>("Errore nel pagamento!", HttpStatus.EXPECTATION_FAILED);

    }



    /**
     *
     * This method is used to update the buyer about the event status.
     *
     * @param event, the event that is being observed.
     *
     * @return RespondeEntity<Object>, the response about the procedure
     *
     */
    public ResponseEntity<Object> buyEventTicket(Event event){
        if (event == null){
            return new ResponseEntity<>("Carrello vuoto o insesistente", HttpStatus.BAD_REQUEST);
        }

    /*  if(shoppingHandler.callPaymentSystem(paymentSystem)){
            return new ResponseEntity<>("Il biglietto per l'evento è stato acquistato", HttpStatus.OK);
        }                                                                                       */

        return new ResponseEntity<>("Errore nel pagamento!", HttpStatus.EXPECTATION_FAILED);
    }
}

