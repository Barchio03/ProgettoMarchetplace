package unicam.IdSProject.models;

import unicam.IdSProject.controllers.Curator;

/**
*
* This class represents the Platform Handler of the marketplace
*
* @author Aguiari Erika, Ilaria Morettini, Barchiesi Luca
*
*/
public class PlatformHandler {

    private Mailbox mailbox;
    private List<Curator> curators;

    /**
    * This method creates a new PlatformHandler object
    */
    public PlatformHandler(Mailbox mailbox){
        this.mailbox = mailbox
    }


    
    public Mailbox getMailbox() {
        return mailbox;
    }

    public List<Curator> getCurators(){
        return curators
    }
}
