package unicam.IdSProject.dtos.requests;

import lombok.Data;

@Data
public class EventCreatedDTO {
    private String name;
    private int maxAttendees;
    private String description;
    private String collaborators;
}
