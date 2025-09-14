package unicam.IdSProject;

import unicam.IdSProject.Models.Product;
import unicam.IdSProject.Models.Seller;
import unicam.IdSProject.Models.TransformerProduct;

public class ProductBuilder {

    private Product product;

    public ProductBuilder(){}

    public void reset() {
        product=null;
    }

    public void setName(String name) {
        product.setName(name);
    }

    public void setPrice(int price) {
        product.setPrice(price);
    }

    public void setDescription(String description) {
        product.setDescription(description);
    }

    public void setCreator(Seller seller) {

    }

    public void setSourceProduct(TransformerProduct product) {
        product.setSourceProduct(product);
    }

    public Product createProduct() {
        return product;
    }

}
