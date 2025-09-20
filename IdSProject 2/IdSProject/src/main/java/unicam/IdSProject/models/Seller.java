package unicam.IdSProject.models;
import unicam.IdSProject.Tag;
import java.util.ArrayList;

/**
*
* This class represents a Seller
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class Seller {

    private String name;
    private String description;
    private Location location;
    private ArrayList<Tag> tags;
    private final Mailbox mailbox;
    private int id;
    private static int currentId;

    
    /**
    * This method creates a new Seller object
    */
    public Seller(String name, String description ) {
        this.mailbox=new Mailbox();
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public int getId() {
        return id;
    }

    public Mailbox getMailbox() {
        return mailbox;
    }

    @Override
    public String toString(){
        return "Nome: "+this.getName() +
                "\nDescrizione: "+this.getDescription() +
                "\nLocation: "+this.getLocation().toString();
    }
}
