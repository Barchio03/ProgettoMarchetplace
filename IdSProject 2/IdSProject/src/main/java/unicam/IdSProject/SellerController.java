package unicam.IdSProject;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public class SellerController {

    @Autowired
    private RequestHandler requestHandler;
    @Autowired
    private ProductBoard productBoard;

    private Seller seller;

    public SellerController(Seller seller){


        this.seller = seller;

    }

    /**
     *
     * This method is used to remove a product from the marketplace.
     *
     * @return true if the product is removed successfully, false otherwise.
     *
     */
    public boolean removeProduct() {
        return false;
    }


    // -- PRODUCER --

    @RequestMapping(value = "/producer/addProduct")
    public ResponseEntity<Object> addProducerProduct(@RequestBody ProducerProduct product){
        if (seller.getTags().contains(Tag.PRODUCER)) {
            product.setCreator(seller);
            if (requestHandler.addProduct(product))
                return new ResponseEntity<>("Prodotto in processo di verifica", HttpStatus.CREATED);
            else return new ResponseEntity<>("Richiesta già in atto", HttpStatus.BAD_REQUEST);
        } else return new ResponseEntity<>("Non autorizzato", HttpStatus.UNAUTHORIZED);
    }

    // -- TRANSFORMER --

    @RequestMapping(value = "/transformer/addProduct")
    public ResponseEntity<Object> addTransformerProduct(@RequestBody TransformerProduct product){
        if (seller.getTags().contains(Tag.TRANSFORMER)) {
            product.setCreator(seller);
            if (requestHandler.addProduct(product))
                return new ResponseEntity<>("Prodotto in processo di verifica", HttpStatus.CREATED);
            else return new ResponseEntity<>("Richiesta già in atto", HttpStatus.BAD_REQUEST);
        } else return new ResponseEntity<>("Non autorizzato", HttpStatus.UNAUTHORIZED);
    }


    @RequestMapping(value = "/producer/addProduct")
    public ResponseEntity<Object> removeProduct(@PathParam("id") int id) {
        if (productBoard.removeProduct(id)){
            return new ResponseEntity<>("Prodotto rimosso con successo", HttpStatus.OK);
        }
        return new ResponseEntity<>("Id non pervenuto", HttpStatus.NOT_FOUND);

    }



}
