package unicam.IdSProject.models;

import java.util.ArrayList;

/**
*
* This class represents the Mailbox where users receive messages
*
* @author Aguiari Erika, Ilaria Morettini, Barchiesi Luca
*
*/
public class Mailbox {

    private final ArrayList<String> mailbox;

    /**
     * This method creates a new Mailbox object
     */
    public Mailbox(){
        mailbox = new ArrayList<String>();
    }


    
    /**
     * This method adds a message into the Mailbox
     *
     * @param message, the message to add
     */
    public void addMessage(String message) {
            mailbox.add(message);
    }
    

    /**
     * This method returns all the messages inside the Mailbox
     *
     * @return the messages inside the Mailbox
     */
    public ArrayList<String> getMessages() {
        return mailbox;
    }

    /**
     * This method deletes all the messages inside the Mailbox
     */
    public void refresh() {
        mailbox.clear();
    }
}
