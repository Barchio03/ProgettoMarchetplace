package unicam.IdSProject.controllers;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import unicam.IdSProject.repositories.EventBoard;
import unicam.IdSProject.repositories.ProductBoard;
import unicam.IdSProject.services.PlatformHandlerService;

/**
*
* This class implements the methods for a PlatFormHandler used to interact with the marketplace.
*
* @author Erika Aguiari, Luca Barchiesi
*
*/

@Controller
@AllArgsConstructor
public class PlatformHandlerController {

    private final PlatformHandlerService platformHandlerService;
    private ProductBoard productBoard;
    private EventBoard eventBoard;
    
    /**
    * This method blocks the application to a specific user
    */
    public void blockBuyer() {}


    /**
    * This method unblocks a previously blocked user
    */
    public void unblockBuyer() {}

    /**
     * This method verifies if a receipt has been received
     *
     * @return the response of the method
     */
    public ResponseEntity<Object> viewReceipts() {
        return platformHandlerService.getReceipts();
    }

    /**
    * This method verifies if a message has been received
    *
    * @return the response of the method
    */
    public ResponseEntity<Object> viewMessages() {
        return platformHandlerService.openMailbox();
    }


}
