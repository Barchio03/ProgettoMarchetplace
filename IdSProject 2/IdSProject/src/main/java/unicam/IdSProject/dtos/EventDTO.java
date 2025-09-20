package unicam.IdSProject.dtos;

import unicam.IdSProject.models.Animator;
import unicam.IdSProject.models.Buyer;
import unicam.IdSProject.models.Seller;

import java.util.ArrayList;

public class EventDTO {
    private String name;
    private Animator creator;
    private int maxAttendees;
    private String description;
    private ArrayList<Seller> collaborators;
    private ArrayList<Buyer> subscribers;

    public EventDTO(String name, Animator creator, int maxAttendees, String description, ArrayList<Seller> collaborators, ArrayList<Buyer> subscribers){
        this.name = name;
        this.creator = creator;
        this.maxAttendees = maxAttendees;
        this.description = description;
        this.collaborators = collaborators;
        this.subscribers = subscribers;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animator getCreator() {
        return creator;
    }

    public void setCreator(Animator creator) {
        this.creator = creator;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public void setMaxAttendees(int maxAttendees) {
        this.maxAttendees = maxAttendees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Seller> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(ArrayList<Seller> collaborators) {
        this.collaborators = collaborators;
    }

    public ArrayList<Buyer> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<Buyer> subscribers) {
        this.subscribers = subscribers;
    }
}
