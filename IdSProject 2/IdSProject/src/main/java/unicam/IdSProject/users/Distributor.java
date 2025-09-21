package unicam.IdSProject.users;

import unicam.IdSProject.models.ProductBundle;

/**
*
* This class represents a Distributor
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*/
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


    
    public int getId() {
        return id;
    }

    public ProductBundle createBundle() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
