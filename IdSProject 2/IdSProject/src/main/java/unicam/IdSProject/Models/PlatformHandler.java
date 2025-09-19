package unicam.IdSProject.Models;

import unicam.IdSProject.Models.Mailbox;
import unicam.IdSProject.Controllers.Curator;

public class PlatformHandler {

    private Mailbox mailbox;

    private List<Curator> curators;

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
