package unicam.IdSProject.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a Product made by a Producer
 *
 * @author Erika Aguiari, Luca Barchiesi
 *
 */
@Getter
@Setter
@Entity
@DiscriminatorValue("1")
public class ProducerProduct extends Product {


    /**
     * This method creates a new Product object.
     */
    public ProducerProduct() {
        super();
    }
}
