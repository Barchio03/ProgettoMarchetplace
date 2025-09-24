package unicam.IdSProject.users;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
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
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
@Getter
@Setter
@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Location location;

    private ArrayList<Tag> tags;

    private final Mailbox mailbox;



    
    /**
    * This method creates a new Seller object
    */
    public Seller(String name, String description ) {
        this.mailbox=new Mailbox();
    }


    @Override
    public String toString(){
        return "Nome: "+this.getName() +
                "\nDescrizione: "+this.getDescription() +
                "\nLocation: "+this.getLocation().toString();
    }
}
