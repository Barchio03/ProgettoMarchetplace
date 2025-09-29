package unicam.IdSProject.models;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
*
* This class represents a Bundle of Products made by a Distributor
*
* @author Erika Aguiari, Luca Barchiesi
*
*/
@Entity
@Getter
@Setter
@DiscriminatorValue("3")
public class ProductBundle extends Product{
    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    private ArrayList<Long> products;

    /**
     * This method creates a new ProductBundle object
     */
    public ProductBundle() {
        super();
    }
}
