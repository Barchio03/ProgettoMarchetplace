package unicam.IdSProject.models;

import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.visitor.Visitable;
import unicam.IdSProject.visitor.Visitor;
import unicam.IdSProject.users.Seller;

/**
*
* This class represents a Product.
*
* @author Erika Aguiari, Luca Barchiesi
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
    private Long id;
    private static Long currentId;


    /**
    * This method creates a new Product object.
    */
    public Product() {

    }

    
    private static Long getCurrentId() {
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
