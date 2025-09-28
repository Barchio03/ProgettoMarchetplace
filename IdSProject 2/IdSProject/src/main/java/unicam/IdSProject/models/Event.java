package unicam.IdSProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.visitor.Visitable;
import unicam.IdSProject.visitor.Visitor;

import java.util.Objects;

/**
 *
 * This class represents an Event.
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
 *
 */

@Entity
@Getter
@Setter
@Table(name="events")
public class Event implements Visitable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String creator;
    @NotNull
    private int attendees = 0;
    @NotNull
    private int maxAttendees;
    @NotNull
    private String description;

    private String collaborators;


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if(!(obj instanceof Event)){
            return false;
        }
        else{
            return this.getName().equals(((Event) obj).getName()) && this.getCreator().equals(((Event) obj).getCreator());
        }
    }
}
