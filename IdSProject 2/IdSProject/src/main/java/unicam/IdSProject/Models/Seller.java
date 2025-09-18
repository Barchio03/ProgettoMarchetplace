package unicam.IdSProject.Models;

import unicam.IdSProject.Tag;

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

    private final Mailbox mailbox;

    private int id;

    private static int currentId;



    
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

    /**
     * @return the tag assigned to the seller
     */
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
     * @return the mailbox of the seller
     */
    public Mailbox getMailbox() {
        return mailbox;
    }


    public String toString(){
        return "Nome: "+this.getName()+
                "\nDescrizione: "+this.getDescription()+
                "\nLocation: "+this.getLocation().toString();

    }
}
