package unicam.IdSProject.classes;

import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.models.Product;

/**
*
* This class represents the Product inside a Shopping Cart
*
* @author Erika Aguiari, Luca Barchiesi
*
*/

@Getter
@Setter
public class QuantifiedProduct {

    private Product product;
    private int stockNumber;
    private double totalPrice;

    /**
     * This method creates a new QuantifiedProduct object
     */
    public QuantifiedProduct(Product product, int stockNumber) {
        this.product=product;
        this.stockNumber=stockNumber;
        this.totalPrice=product.getPrice() * stockNumber;
    }

}
