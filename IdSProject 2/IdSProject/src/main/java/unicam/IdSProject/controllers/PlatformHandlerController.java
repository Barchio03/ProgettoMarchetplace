package unicam.IdSProject.controllers;
import unicam.IdSProject.models.PlatformHandler;

/**
*
* This class implements the methods for a PlatFormHandler used to interact with the marketplace.
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class PlatformHandlerController {

    private final PlatformHandler platformHandler;


    /**
    * This method creates a new PlatformHandler object
    */
    public PlatformHandlerController(PlatformHandler platformHandler){
        this.platformHandler = platformHandler;
    }


    
    
    //      |                                |
    //      |  Tutti metodi da implementare  |
    //      V                                V


    
    /**
    * This method blocks the application to a specific user
    */
    public void blockUser() {}                                        //Cambiare il teorico bool unauthorized a true
                                                                      //Con i DTO possiamo nascondere il campo unauthorized all'utente e gestire la cosa facilmente

    /**
    * This method unblocks a previously blocked user
    */
    public void unblockUser() {}                                      //Se è true cambiare a false, dare eccezione altrimenti

    /**
    * This method appoints a new Curator
    *
    * @return true if it appoints a new Curator, false otherwise
    */
    public boolean appointCurator() {                                 //Anche qui l'interfaccia user e una lista con tutti gli user
        return false;                                                 //può fare molto comodo
    }

    /**
    * This method verifies if a receipt has been received
    *
    * @return true if the receipt is received, false otherwise        //Come cerca la ricevuta? Inserendo uno specifico user?
    */
    public boolean verifyReceivedReceipt() {                          //Come funziona? 
        return false;                                                 //Bisogna creare una classe Receipt con dentro Messaggio e Destinatario della ricevuta?
    }                                                                 //


}
