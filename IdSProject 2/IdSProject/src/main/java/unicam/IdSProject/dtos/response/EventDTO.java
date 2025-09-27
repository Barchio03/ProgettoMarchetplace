package unicam.IdSProject.dtos.response;

import lombok.Data;

@Data
public class EventDTO {
    private String name;
    private String creator;
    private int maxAttendees;
    private String description;
    private String collaborators;



}
