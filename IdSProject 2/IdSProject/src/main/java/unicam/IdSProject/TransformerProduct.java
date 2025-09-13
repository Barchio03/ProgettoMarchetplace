package unicam.IdSProject;

public class TransformerProduct extends Product {

    private Product sourceProduct;

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
