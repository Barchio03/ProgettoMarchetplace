package unicam.IdSProject.Models;

/**
*
* This class represents a Product made by a Transformer
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class TransformerProduct extends Product {

    private Product sourceProduct;

    /**
    * This method creates a new TrasformerProduct object
    */
    public TransformerProduct() {
        super();
    }


    public Product getSourceProduct() {
        return sourceProduct;
    }

    public void setSourceProduct(Product sourceProduct) {
        this.sourceProduct = sourceProduct;
    }
}
