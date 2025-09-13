package unicam.IdSProject;

import javax.swing.text.html.HTML;
import java.util.ArrayList;


/**
*
* This class is used to represent a seller.
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class Seller {

    private String name;

    private String description;

    private Location location;

    private ArrayList<Tag> tags;

    private int id;

    private static int currentId;

    private Mailbox mailbox;

    
    /**
    * This method creates an object Seller.
    */
    public Seller(String name, String description ) {
        this.mailbox=new Mailbox();
    }

    private static int getCurrentId() {
        return currentId;
    }

    /**
     * @return the name of the seller
     */
    public String getName() {
        return name;
    }

    /**
     * @param name, the name of the seller
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description of the seller
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description, the description of the seller
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the location of the seller
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location, the location of the seller
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    /**
     * @return the id of the seller
     */
    public int getId() {
        return id;
    }

    
    /**
    *
    * This method is used to add a product to the marketplace.
    *
    * @return true if the product is added successfully, false otherwise.
    *
    */
    public boolean addProduct() {
        return false;
    }

    /**
    *
    * This method is used to remove a product from the marketplace.
    *
    * @return true if the product is removed successfully, false otherwise.
    *
    */
    public boolean removeProduct() {
        return false;
    }

    public Mailbox getMailbox() {
        return mailbox;
    }

    public String toString(){
        return "Nome: "+this.getName()+
                "\nDescrizione: "+this.getDescription()+
                "\nLocation: "+this.getLocation().toString();

    }
}
