package unicam.IdSProject;

/**
 * This class represents the animator
 */
public class Animator {

    /**
     * The name of the animator profile
     */
    private String name;

    /**
     * The description of the animator profile
     */
    private String description;

    /**
     * The animator's id
     */
    private int id;

    private static int currentId;

    private Mailbox mailbox;

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
     * @returnthe name of the animator
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

    /**
     * Creates a new event
     *
     * @return
     */
    public Event createEvent() {
        return null;
    }

    public boolean deleteEvent(Event event) {
        return false;
    }

    public Mailbox getMailbox() {
        return mailbox;
    }
}
