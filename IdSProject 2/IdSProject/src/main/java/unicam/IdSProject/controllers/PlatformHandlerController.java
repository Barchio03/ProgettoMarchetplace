package unicam.IdSProject.controllers;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import unicam.IdSProject.models.PlatformHandler;
import unicam.IdSProject.services.PlatformHandlerService;

/**
*
* This class implements the methods for a PlatFormHandler used to interact with the marketplace.
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/

@Controller
@AllArgsConstructor
public class PlatformHandlerController {

    private final PlatformHandlerService platformHandlerService;
    
    /**
    * This method blocks the application to a specific user
    */
    public void blockBuyer() {}                                        //Cambiare il teorico bool unauthorized a true
                                                                      //Con i DTO possiamo nascondere il campo unauthorized all'utente e gestire la cosa facilmente

    /**
    * This method unblocks a previously blocked user
    */
    public void unblockBuyer() {}                                      //Se è true cambiare a false, dare eccezione altrimenti


    public ResponseEntity<Object> viewReceipts() {
        return platformHandlerService.getReceipts();
    }

    /**
    * This method verifies if a receipt has been received
    *
    * @return true if the receipt is received, false otherwise        //Come cerca la ricevuta? Inserendo uno specifico user?
    */
    public ResponseEntity<Object> viewMessages() {
        return platformHandlerService.openMailbox();
    }


}
