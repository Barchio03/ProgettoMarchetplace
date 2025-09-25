package unicam.IdSProject.users;

import lombok.Getter;
import unicam.IdSProject.models.Mailbox;

/**
*
* This class represents the Platform Handler of the marketplace
*
 * @author Erika Aguiari, Luca Barchiesi
*
*/
public class PlatformHandler {

    private Mailbox mailbox;



    /**
    * This method creates a new PlatformHandler object
    */
    public PlatformHandler(){
    }


    
    public Mailbox getMailbox() {
        return mailbox;
    }

}
