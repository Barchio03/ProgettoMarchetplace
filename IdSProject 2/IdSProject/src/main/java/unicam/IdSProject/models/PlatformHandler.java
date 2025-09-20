package unicam.IdSProject.models;

import unicam.IdSProject.controllers.Curator;
import java.util.ArrayList;

/**
*
* This class represents the Platform Handler of the marketplace
*
* @author Aguiari Erika, Ilaria Morettini, Barchiesi Luca
*
*/
public class PlatformHandler {

    private Mailbox mailbox;
    private ArrayList<Curator> curators;

    /**
    * This method creates a new PlatformHandler object
    */
    public PlatformHandler(){
    }


    
    public Mailbox getMailbox() {
        return mailbox;
    }

    public ArrayList<Curator> getCurators(){
        return curators;
    }

}
