package unicam.IdSProject.dtos.response;

import lombok.Data;
import unicam.IdSProject.users.Animator;
import unicam.IdSProject.users.Buyer;
import unicam.IdSProject.users.Seller;

import java.util.ArrayList;

@Data
public class EventDTO {
    private String name;
    private AnimatorDTO creator;
    private int maxAttendees;
    private String description;
    private String collaborators;

}
