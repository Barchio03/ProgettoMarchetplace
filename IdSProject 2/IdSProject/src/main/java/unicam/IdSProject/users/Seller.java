package unicam.IdSProject.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.enumerations.Tag;
import unicam.IdSProject.models.Location;
import unicam.IdSProject.models.Mailbox;

import java.util.ArrayList;

/**
*
* This class represents a Seller
*
* @author Erika Aguiari, Luca Barchiesi
*
*/
@Getter
@Setter
@AllArgsConstructor
public class Seller {

    private String id;

    private String name;

    private String description;

    private Location location;

    private ArrayList<Tag> tags;


    @Override
    public String toString(){
        return "Nome: "+this.getName() +
                "\nDescrizione: "+this.getDescription() +
                "\nLocation: "+this.getLocation().toString();
    }
}
