package unicam.IdSProject.dtos.requests;

import lombok.Data;
import unicam.IdSProject.users.Seller;

import java.util.ArrayList;

@Data
public class EventCreationDTO {

    private String name;
    private int maxAttendees;
    private String description;

}
