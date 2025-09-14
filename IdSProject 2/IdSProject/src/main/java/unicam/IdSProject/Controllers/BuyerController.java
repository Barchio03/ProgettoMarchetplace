package unicam.IdSProject.Controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.EventBoard;
import unicam.IdSProject.Models.Buyer;
import unicam.IdSProject.Models.Event;
import unicam.IdSProject.Models.Product;
import unicam.IdSProject.ProductBoard;

import java.util.ResourceBundle;

/**
 * This class represents the buyer's controller
 */
@Controller
public class BuyerController {

    /**
     * The buyer, for testing purposes
     */
    private Buyer buyer;

    /**
     * The product board
     */
    @Autowired
    private ProductBoard productBoard;

    /**
     * The event board
     */
    @Autowired
    private EventBoard eventboard;

    /**
     * Creates a new Controller
     *
     * @param productBoard
     * @param eventBoard
     */
    @Autowired
    public BuyerController(ProductBoard productBoard, EventBoard eventBoard){
        this.buyer = new Buyer();
        this.productBoard = productBoard;
        this.eventboard = eventBoard;
    }

    /**
     *
     * This method adds a product to the shopping cart.
     *
     * @param id, the product id
     *
     * @param quantity, the quantity of products
     *
     * @return true if the product is added successfully, false otherwise.
     *
     */
    @RequestMapping(value="/buyer/addToCart")
    public ResponseEntity<Object> addProduct(@PathParam("id") int id,@PathParam("quantity") int quantity) {
        Product product = productBoard.getProduct(id);
        if (product == null) return new ResponseEntity<>("Id Prodotto invalido", HttpStatus.NOT_FOUND);
        if (buyer.addToShoppingCart(product, quantity))
            return new ResponseEntity<>("Prodotto aggiunto al carrello", HttpStatus.OK);
        else return new ResponseEntity<>("Prodotto invalido",HttpStatus.BAD_REQUEST);
    }



    /**
     *
     * This method is used to buy all the products in the shopping cart.
     *
     * @return true if the products are sold successfully, false otherwise.
     *
     */

    public boolean buyShoppingCart(){
        return false;
    }



    /**
     *
     * This method is used to update the buyer about the event status.
     *
     * @param event, the event that is being observed.
     *
     */
    public boolean buyEventTicket(Event event){
        return false;
    }
}

