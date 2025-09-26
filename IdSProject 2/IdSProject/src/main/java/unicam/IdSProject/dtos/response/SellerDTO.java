package unicam.IdSProject.dtos.response;

import lombok.Data;
import unicam.IdSProject.models.Location;
import unicam.IdSProject.models.Mailbox;
import unicam.IdSProject.enumerations.Tag;

import java.util.ArrayList;

@Data
public class SellerDTO {

    private String name;
    private String description;
    private LocationDTO location;
    private ArrayList<Tag> tags;



}
