package unicam.IdSProject.dtos.response;

import lombok.Data;
import unicam.IdSProject.users.Animator;
import unicam.IdSProject.users.Buyer;
import unicam.IdSProject.users.Seller;

import java.util.ArrayList;

@Data
public class EventDTO {
    private String name;
    private Animator creator;
    private int maxAttendees;
    private String description;
    private ArrayList<Seller> collaborators;
    private ArrayList<Buyer> subscribers;

}
