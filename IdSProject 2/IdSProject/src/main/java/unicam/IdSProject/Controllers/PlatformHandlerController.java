package unicam.IdSProject.Controllers;
import unicam.IdSProject.Models.PlatformHandler;
import java.util.ArrayList;

/**
*
* This class implements the methods for a PlatFormHandler used to interact with the marketplace.
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class PlatformHandlerController {

    private final PlatformHandler platformHandler;

    //Si potrebbe far estendere un'interfaccia User a tutti coloro che utilizzano la piattaforma
    //e non sono PlatformHandler in modo tale da poterli raggruppare tutti in una lista.
    //Così facendo basta che il platformHandler setti un bool unautorized da false a true e lo user
    //sarebbe poi facilmente bannabile dalla piattaforma. Se invece c'è un modo più facile per fare
    //ciò su SpringBoot, ben venga.

    //private ArrayList<User> allUsers;

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
    public void blockUser() {}

    /**
    * This method unblocks a previously blocked user
    */
    public void unblockUser() {}

    /**
    * This method appoints a new Curator
    *
    * @return true if it appoints a new Curator, false otherwise
    */
    public boolean appointCurator() {
        return false;
    }

    /**
    * This method verifies if a receipt has been received
    *
    * @return true if the receipt is received, false otherwise
    */
    public boolean verifyReceivedReceipt() {
        return false;
    }


}
