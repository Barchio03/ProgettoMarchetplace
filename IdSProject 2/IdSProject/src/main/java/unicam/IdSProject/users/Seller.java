package unicam.IdSProject.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.enumerations.Tag;
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
@Entity
@AllArgsConstructor
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Long location;

    private ArrayList<Tag> tags;

//    @Transient
//    private Mailbox mailbox;



    
    /**
    * This method creates a new Seller object
    */
    public Seller(String name, String description ) {

    }


    @Override
    public String toString(){
        return "Nome: "+this.getName() +
                "\nDescrizione: "+this.getDescription() +
                "\nLocation: "+this.getLocation().toString();
    }
}
