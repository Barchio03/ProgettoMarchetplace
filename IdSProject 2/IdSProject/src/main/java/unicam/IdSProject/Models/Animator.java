package unicam.IdSProject.Models;

/**
 * This class represents the animator
 */
public class Animator {

    private String name;

    private String description;

    private final int id;

    private static int currentId;

    private final Mailbox mailbox;

    /**
     * Creates a new animator
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

    /**
     * @return name, the name of the animator
     */
    public String getName() {
        return name;
    }

    /**
     * @param name, the name of the animator
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description of the animator
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description, the description of the animator
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the animator's id
     */
    public int getId() {
        return id;
    }



    public Mailbox getMailbox() {
        return mailbox;
    }
}
