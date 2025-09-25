package unicam.IdSProject;

import unicam.IdSProject.models.Product;

/**
*
* This class represents the Product inside a Shopping Cart
*
* @author Erika Aguiari, Luca Barchiesi
*
*/
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

    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public double getTotalPrice() { return totalPrice; }

}
