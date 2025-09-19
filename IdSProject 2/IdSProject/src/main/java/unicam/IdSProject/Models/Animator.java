package unicam.IdSProject.Models;

/**
*
* This class represents an Animator
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*/
public class Animator {

    private String name;

    private String description;

    private final int id;

    private static int currentId;

    private final Mailbox mailbox;

    /**
     * This method creates a new Animator object
     */
    public Animator(String name, String description) {
        this.name=name;
        this.description=description;
        this.mailbox = new Mailbox();
        this.id=currentId++;
    }

    private static int getCurrentId() {
        return currentId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Mailbox getMailbox() {
        return mailbox;
    }
}
