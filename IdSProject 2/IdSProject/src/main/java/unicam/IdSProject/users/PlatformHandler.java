package unicam.IdSProject.users;

import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.models.Mailbox;

/**
*
* This class represents the Platform Handler of the marketplace
*
* @author Aguiari Erika, Ilaria Morettini, Barchiesi Luca
*
*/
@Getter
@Setter
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
