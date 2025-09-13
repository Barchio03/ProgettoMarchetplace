package unicam.IdSProject;

import java.util.ArrayList;

/**
 * This class represents the mailbox where users receive messages
 *
 * @author Aguiari Erika, Ilaria Morettini, Barchiesi Luca
 */
public class Mailbox {

    /**
     * The mailbox where messages are stored
     */
    private ArrayList<String> mailbox;

    /**
     * Creates a new Mailbox
     */
    public Mailbox(){
        mailbox = new ArrayList<String>();
    }

    /**
     * Adds a message to the mailbox
     *
     * @param message to add
     */
    public void addMessage(String message) {
            mailbox.add(message);
    }

    /**
     * @return the messages inside the mailbox
     */
    public ArrayList<String> getMessages() {
        return mailbox;
    }

    /**
     * Deletes all the messages inside the mailbox
     */
    public void refresh() {
        mailbox.clear();
    }
}
