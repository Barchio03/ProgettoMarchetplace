package unicam.IdSProject.models;

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
public class TransformerProduct extends Product {

    private Product sourceProduct;

    /**
    * This method creates a new TrasformerProduct object
    */
    public TransformerProduct() {
        super();
    }

}
