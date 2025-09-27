package unicam.IdSProject.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
*
* This class represents a Product made by a Transformer
*
* @author Erika Aguiari, Luca Barchiesi
*
*/
@Getter
@Setter
@Entity
@DiscriminatorValue("2")
public class TransformerProduct extends Product {

    @NotNull
    private Product sourceProduct;

    /**
    * This method creates a new TrasformerProduct object
    */
    public TransformerProduct() {
        super();
    }

}
