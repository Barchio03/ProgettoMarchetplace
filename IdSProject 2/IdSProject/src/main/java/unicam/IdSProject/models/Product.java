package unicam.IdSProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.visitor.Visitable;
import unicam.IdSProject.visitor.Visitor;
import unicam.IdSProject.users.Seller;

import java.util.Objects;

/**
*
* This class represents a Product.
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product implements Visitable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private float price;
    @NotNull
    private String description;

    private String distributorDescription;
    @NotNull
    private int stockNumber;
    @NotNull
    private Long creator;

    /**
    * This method creates a new Product object.
    */
    public Product() {}


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
            return Objects.equals(this.id, product.id);
        }
    }

}
