package unicam.IdSProject.users;

import lombok.Getter;
import lombok.Setter;

/**
*
* This class represents an Animator
*
* @author Erika Aguiari, Luca Barchiesi
*/

@Getter
@Setter
public class Animator {

    private String id;

    private String name;

    private String description;

    /**
     * This method creates a new Animator object
     */
    public Animator(String id, String name, String description) {
        this.id=id;
        this.name=name;
        this.description=description;
    }

}
