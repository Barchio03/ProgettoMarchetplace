package unicam.IdSProject.users;

import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.models.ProductBundle;

/**
*
* This class represents a Distributor
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*/
@Getter
@Setter
public class Distributor {

    private String name;
    private final int id;

    /**
    * This method creates a new Distributor object
    */
    public Distributor(int id, String name) {

        this.id = id;
        this.name = name;
    }


    public ProductBundle createBundle() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }
}
