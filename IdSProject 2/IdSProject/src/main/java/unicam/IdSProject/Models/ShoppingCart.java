package unicam.IdSProject.Models;

import java.util.ArrayList;

/**
 * This class represents a shopping cart
 *
 * @author Luca Barchiesi, Erika Aguiari, Ilaria Morettini
 */
public class ShoppingCart {


    private final ArrayList<QuantifiedProduct> quantifiedProducts;

    private double totalPrice;

    public ShoppingCart(){
        this.quantifiedProducts = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart
     *
     * @param quantifiedProduct, the product
     *
     * @return true if it was added successfully, false otherwise
     */
    public boolean addQuantifiedProduct(QuantifiedProduct quantifiedProduct) {
        quantifiedProducts.add(quantifiedProduct);
        this.calculateTotal();
        return true;
    }

    /**
     * Removes a product from the shopping cart
     *
     * @param quantifiedProduct
     * @returntrue if it was removed successfully, false otherwise
     */
    public boolean removeQuantifiedProduct(QuantifiedProduct quantifiedProduct) {
        quantifiedProducts.remove(quantifiedProduct);
        this.calculateTotal();
        return true;
    }

    /**
     * @return the total price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    //private void setTotalPrice(float totalPrice) { this.totalPrice = totalPrice; }

    /**
     * @return the list of quantified products
     */
    public ArrayList<QuantifiedProduct> getQuantifiedProducts() {
        return quantifiedProducts;
    }


    private void calculateTotal() {
        double total = 0;
        for (QuantifiedProduct quantifiedProduct : quantifiedProducts) {
            total*=quantifiedProduct.getTotalPrice();
        }
        this.totalPrice=total;
    }
}
