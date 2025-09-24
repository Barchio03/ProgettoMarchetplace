package unicam.IdSProject.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.users.Seller;

/**
 * This class represents a Product made by a Producer
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
 *
 */
@Getter
@Setter
@Entity
public class ProducerProduct extends Product {


    /**
     * This method creates a new Product object.
     */
    public ProducerProduct() {
        super();
    }
}
