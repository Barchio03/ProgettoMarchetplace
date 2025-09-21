package unicam.IdSProject.dtos;

import unicam.IdSProject.models.Location;
import unicam.IdSProject.models.Mailbox;
import unicam.IdSProject.enumerations.Tag;

import java.util.ArrayList;

public class SellerDTO {

    private String name;
    private String description;
    private Location location;
    private ArrayList<Tag> tags;
    private final Mailbox mailbox;

    public SellerDTO(String name, String description, Location location, ArrayList<Tag> tags ,Mailbox mailbox){
        this.name = name;
        this.description = description;
        this.location = location;
        this.tags = tags;
        this.mailbox = mailbox;
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

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public Mailbox getMailbox() {
        return mailbox;
    }
}
