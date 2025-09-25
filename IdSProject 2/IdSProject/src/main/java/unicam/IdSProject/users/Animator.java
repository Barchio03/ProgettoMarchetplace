package unicam.IdSProject.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.models.Mailbox;

/**
*
* This class represents an Animator
*
* @author Erika Aguiari, Luca Barchiesi
*/

@Getter
@Setter
@Entity
public class Animator {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @JsonInclude()
    @Transient
    private final Mailbox mailbox;

    /**
     * This method creates a new Animator object
     */
    public Animator(String name, String description) {
        this.name=name;
        this.description=description;
        this.mailbox = new Mailbox();
    }

}
