package unicam.IdSProject;

import unicam.IdSProject.Models.ProducerProduct;
import unicam.IdSProject.Models.TransformerProduct;

public class ProductDirector {

    private ProductBuilder productBuilder;

    public ProductDirector() {}

    public ProducerProduct produceProducerProduct() {
        productBuilder.reset();
        productBuilder.setName("");
        return null;
    }

    public TransformerProduct produceTransformerProduct() {
        return null;
    }

}
