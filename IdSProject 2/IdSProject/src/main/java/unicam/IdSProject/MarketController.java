package unicam.IdSProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.Models.Animator;
import unicam.IdSProject.Models.Seller;

@Controller
public class MarketController {

    private ProductBoard productBoard;

    @Autowired
    private RequestHandler requestHandler;

    private Seller seller;
    private Buyer buyer;
    private Animator animator;
    private PlatformHandler platformHandler;

    public MarketController(){
        this.productBoard = new ProductBoard();
        //this.requestHandler = new RequestHandler();
        this.seller=new Seller("Vendor 1", "Just a vendor");
        this.buyer=new Buyer();
        this.animator=new Animator("Animator 1", "Just an animator");
        this.platformHandler=new PlatformHandler();

        Product product = new ProducerProduct();
        product.setName("Prodotto A");
        product.setDescription("Un prodotto generico");
        product.setPrice(5);
        product.setStockNumber(5);
        productBoard.addProduct(product);

        seller.setName("Vendor 1");
        seller.setDescription("Just a vendor");
        seller.setLocation(new Location("43.000 N", "12.000 E"));
        seller.getMailbox().addMessage("mi vedi?");
    }

    // -- MARKET --

    @RequestMapping(value="/market")
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productBoard.getProducts(), HttpStatus.OK);
    }


    @RequestMapping(value = "/profile/{user}")
    public ResponseEntity<Object> showProfile(@PathVariable("user") String user){
        return switch (user) {
            case "seller" -> new ResponseEntity<>(seller.toString(), HttpStatus.OK);
            case "buyer" -> new ResponseEntity<>(buyer, HttpStatus.OK);
            case "animator" -> new ResponseEntity<>(animator, HttpStatus.OK);
            default -> new ResponseEntity<>("Il profilo " + user + " non esiste", HttpStatus.NOT_FOUND);
        };
    }

    @RequestMapping(value="/profile/{user}/mailbox")
    public ResponseEntity<Object> openSellerMailbox(@PathVariable("user") String user){
        return switch (user) {
            case "seller" -> new ResponseEntity<>(seller.getMailbox().getMessages(), HttpStatus.OK);
            case "buyer" -> new ResponseEntity<>(buyer.getMailbox().getMessages(), HttpStatus.OK);
            case "animator" -> new ResponseEntity<>(animator.getMailbox().getMessages(), HttpStatus.OK);
            case "handler" -> new ResponseEntity<>(platformHandler.getMailbox().getMessages(), HttpStatus.OK);
            default -> new ResponseEntity<>("Il profilo " + user + " non ha una mailbox", HttpStatus.NOT_FOUND);
        };
    }


}
