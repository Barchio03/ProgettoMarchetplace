package unicam.IdSProject;

import org.springframework.web.bind.annotation.RequestBody;

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
