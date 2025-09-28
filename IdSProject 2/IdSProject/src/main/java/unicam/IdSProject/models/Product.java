package unicam.IdSProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import unicam.IdSProject.visitor.Visitable;
import unicam.IdSProject.visitor.Visitor;

import java.io.Serializable;
import java.util.Objects;

/**
*
* This class represents a Product.
*
* @author Erika Aguiari, Luca Barchiesi
*
*/
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",
        discriminatorType = DiscriminatorType.INTEGER)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="products")
public abstract class Product implements Visitable, Serializable {

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
    private String creator;

    /**
    * This method creates a new Product object.
    */
    public Product() {}


    @Tolerate
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    @Tolerate
    @Override
    public boolean equals(Object obj){

        if (obj == null){
            return false;
        }
        if(!(obj instanceof Product)){
            return false;
        }
        else{
            return this.getName().equals(((Product) obj).getName()) && this.getCreator().equals(((Product) obj).getCreator());
        }
    }

}
