package unicam.IdSProject.models;

import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.Visitable;
import unicam.IdSProject.Visitor;

/**
*
* This class represents a Product.
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
@Getter
@Setter
public abstract class Product implements Visitable {

    private String name;
    private float price;
    private String description;
    private String distributorDescription;
    private int stockNumber;
    private Seller creator;
    private int id;
    private static int currentId;


    /**
    * This method creates a new Product object.
    */
    public Product() {

    }

    
    private static int getCurrentId() {
        return currentId;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj){

        if (obj == null){
            return false;
        }
        if(!(obj instanceof Product product)){
            return false;
        }
        else{
            return this.id == product.id;
        }
    }

}
